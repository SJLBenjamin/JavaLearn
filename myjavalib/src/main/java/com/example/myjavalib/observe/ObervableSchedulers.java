package com.example.myjavalib.observe;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class ObervableSchedulers {
    public static void main(String[] args) {

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("test");
                System.out.println("subscribe被观察者的线程" + Thread.currentThread().getName());
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(Schedulers.io()).filter(new Predicate<String>() {
            @Override
            public boolean test(String s) throws Exception {
                System.out.println("filter操作符的线程" + Thread.currentThread().getName());
                return true;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("Disposable的线程 " + Thread.currentThread().getName());
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext 观察者的线程" + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete 观察者的线程" + Thread.currentThread().getName());
            }
        });

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
