package com.example.myjavalib.observe;



public class User implements Observe {
    String TAG = "User";
    String name;
    String message;
    public User(String name){
        this.name = name;
    }
    @Override
    public void update(Object object) {
        message=(String)object;
        readMessage();
    }

    public void readMessage(){
        System.out.println("收到了name=="+name+"消息=="+message);
    }
}
