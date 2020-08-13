package com.example.myjavalib.observe;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectTest {
    public static void main(String[] args) {
        BehaviorSubject<String> behaviorSubject = BehaviorSubject.create();
        behaviorSubject.onNext("1");
        behaviorSubject.onNext("2");

        behaviorSubject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });
        behaviorSubject.onNext("3");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
