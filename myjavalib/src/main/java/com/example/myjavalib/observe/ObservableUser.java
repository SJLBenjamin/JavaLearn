package com.example.myjavalib.observe;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
/*
* Observable基本使用
* */
public class ObservableUser {
    public static void main(String[] args) {
    /*
     * 简单使用
     * */
        Observable.create(new ObservableOnSubscribe<String>() {
        @Override
        public void subscribe(ObservableEmitter<String> emitter) throws Exception {//被观察者发送数据
            System.out.println("ObservableEmitter<String> emitter");
            emitter.onNext("ObservableEmitter");
        }
    }).subscribe(new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {//订阅成功
            System.out.println("onSubscribe");
        }

        @Override
        public void onNext(String s) {//观察者接收数据
            System.out.println("onNext");
        }

        @Override
        public void onError(Throwable e) {
            System.out.println("onError");
        }

        @Override
        public void onComplete() {
            System.out.println("onComplete");
        }
    });
    }
}
