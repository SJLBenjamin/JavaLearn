package com.example.myjavalib.observe;

public class ObserveTest {


    public static void main(String[] args) {
      User user1=  new User("1");
        User user2=  new User("2");
        User user3=  new User("3");
        User user4=  new User("4");
        //user4.update("666");
        wechartService observable = new wechartService();
        observable.add(user1);
        observable.add(user2);
        observable.add(user3);
        observable.add(user4);
        ((wechartService)observable).pushMassage("123");
    }
}

