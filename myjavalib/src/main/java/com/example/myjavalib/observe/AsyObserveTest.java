package com.example.myjavalib.observe;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.AsyncSubject;


public class AsyObserveTest {
    public static void main(String[] args) {
        AsyncSubject();
    }

    static void AsyncSubject(){
        AsyncSubject<String> subject = AsyncSubject.create();

       /* Observable<String> stringObservable = AsyncSubject.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("1");
                emitter.onNext("2");
                emitter.onComplete();
            }
        });*/

        subject.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s);
            }
        });

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        subject.onNext("1");
        subject.onNext("2");
        subject.onComplete();//只发送onComplete前的数据
    }
}
