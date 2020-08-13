package com.example.myjavalib.observe;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

public class PublishSubjectTest {
    public static void main(String[] args) throws InterruptedException {
        PublishSubject<String> publishSubject =PublishSubject.create();
        publishSubject.onNext("1");
        publishSubject.onNext("2");
        publishSubject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });
        publishSubject.onNext("3");
        publishSubject.onNext("4");
        publishSubject.onNext("5");
        publishSubject.onNext("6");
        Thread.sleep(100);
    }
}
