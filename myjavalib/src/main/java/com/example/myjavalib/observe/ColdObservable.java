package com.example.myjavalib.observe;

import java.util.concurrent.TimeUnit;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.schedulers.Schedulers;

public class ColdObservable {
    public static void main(String[] args) {
          Observable<Long> observable = Observable.create(new ObservableOnSubscribe<Long>() {
            @Override
            public void subscribe(ObservableEmitter<Long> emitter) throws Exception {
                //每10毫秒发送一次
                Observable.interval(10, TimeUnit.MILLISECONDS, Schedulers.computation())
                        .take(Integer.MAX_VALUE)
                        .subscribe(emitter::onNext);
            }
        }).observeOn(Schedulers.newThread()).publish();//热发射

        ((ConnectableObservable<Long>) observable).connect();//转换为热发射
          observable.subscribe(new io.reactivex.functions.Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("consumer1: " + aLong);
            }
        });

        try {
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        observable.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Long aLong) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

        observable.subscribe(new io.reactivex.functions.Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("consumer2: " + aLong);
            }
        });

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
