package com.example.myjavalib.observe;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectTest {
    public static void main(String[] args) {
        ReplaySubject<String> replaySubject =ReplaySubject.createWithSize(1);
        //ReplaySubject<String> replaySubject =ReplaySubject.create();
        replaySubject.onNext("1");
        replaySubject.onNext("2");
        replaySubject.onNext("3");
        replaySubject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });
        replaySubject.onNext("4");
        replaySubject.onNext("5");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
