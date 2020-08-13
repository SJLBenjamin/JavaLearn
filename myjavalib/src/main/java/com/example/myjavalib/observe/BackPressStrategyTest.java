package com.example.myjavalib.observe;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.schedulers.Schedulers;

public class BackPressStrategyTest {
    public static void main(String[] args) {
        strategy();
    }

    static void strategy(){

        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> emitter) throws Exception {
                for (int i=0;i<10;i++){
                    emitter.onNext(i+"");
                }

            }
        }, BackpressureStrategy.ERROR).subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread()).subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(10);
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext==="+s);
            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        });
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
