package com.example.javalearn.observe;

import java.util.ArrayList;
import java.util.List;

public class Observable {
    private List<Observe> mList = new ArrayList<Observe>();
    public void add(Observe observe){
        mList.add(observe);
    }

    public void remove(Observe observe){
        mList.remove(observe);
    }

    public  void update(Observe observe){
        for (Observe observer:mList) {
            observer.update(observe);
        }
    }
}
