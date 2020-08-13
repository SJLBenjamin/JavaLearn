package com.example.myjavalib.observe;

import java.util.ArrayList;
import java.util.List;

public class wechartService implements Observable {
    List<Observe> mList = new ArrayList<Observe>();
    private String message;
    @Override
    public void add(Observe observe) {
        mList.add(observe);
    }

    @Override
    public void remove(Observe observe) {
        mList.remove(observe);
    }

    public void pushMassage(String message){
        this.message=message;
        System.out.println("发送数据了");
        NotifyObserve();

    }

    @Override
    public void NotifyObserve() {
        for (Observe observe:mList) {
            observe.update(message);
        }
    }
}
