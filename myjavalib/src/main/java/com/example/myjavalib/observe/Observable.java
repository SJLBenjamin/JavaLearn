package com.example.myjavalib.observe;

import java.util.ArrayList;
import java.util.List;

public interface Observable {

     void add(Observe observe);

     void remove(Observe observe);

      void NotifyObserve();
}
