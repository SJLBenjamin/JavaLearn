package com.example.myjavalib.observe;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FlowableTest {
    public static void main(String[] args) {
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> emitter) throws Exception {
                for (; ; ) {
                    emitter.onNext("1");
                }
            }
        }, BackpressureStrategy.ERROR).subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("s==="+s);
                    }
                });
    }

}
