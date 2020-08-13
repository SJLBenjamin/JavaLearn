package com.example.myjavalib;

public class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("miao miao miao");
    }

    @Override
    public void catSpeak() {
        System.out.println("catSpeak");
    }
}
