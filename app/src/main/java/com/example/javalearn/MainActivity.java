package com.example.javalearn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.example.javalearn.dagger.Person;
import com.jakewharton.rxbinding3.view.RxView;


import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import dalvik.system.DexClassLoader;
import io.reactivex.functions.Consumer;
import kotlin.Unit;


public class MainActivity extends AppCompatActivity {
    MainActivity mainActivity = this;
    String TAG="MainActivity";

    @Inject
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DaggerMainActivityComponent.builder()
//                .mainActivityModule(new MainActivityModule("张三",20))
//                .build()
//                .inject(this);
       // Log.d(TAG,"名字为"+person.getName()+"  年龄为"+person.getAge());


    /*    try {
            Field pathList = HotRestoreUtils.findFiled(this.getClassLoader(), "pathList");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }*/


        DexClassLoader pathClassLoader = new DexClassLoader("com.example.myjavalib.rwLock.RWLock", null,null,MainActivity.class.getClassLoader());
        //Log.d(TAG,"pathClassLoader=="+ pathClassLoader.getParent());

       // ClassLoader classLoader = MainActivity.class.getClassLoader();
        // Log.d(TAG,"MainActivity=="+classLoader.getParent());


       // pathClassLoader.loadClass();
        //Test test;
        //获取系统类和自定义类的ClassLoader
       /* try {

            Log.d(TAG,"MainActivity=="+MainActivity.class.getClassLoader());
             Class c1= MainActivity.class.getClassLoader().loadClass("com.example.javalearn.Test");


            Log.d(TAG,"Activity=="+Activity.class.getClassLoader());
             Class c2= Activity.class.getClassLoader().loadClass("com.example.javalearn.Test");



             Log.d(TAG,"C=="+c1.getName());
        } catch (ClassNotFoundException e) {
            Log.d(TAG,e.getMessage());
            e.printStackTrace();
        }

        try {
            Class c=classLoader.loadClass("android.widget.Toast");
            Log.d(TAG,"android xC=="+c.getName());
        } catch (ClassNotFoundException e) {
            Log.d(TAG,"android x=="+e.getMessage());
            e.printStackTrace();
        }*/

       //事件防止抖动
        RxView.clicks(findViewById(R.id.bt_began)).throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe(new Consumer<Unit>() {
            @Override
            public void accept(Unit unit) throws Exception {
                Toast.makeText(MainActivity.this,"按钮被点击了",Toast.LENGTH_SHORT).show();
                Log.d("bt_began","accept");
            }
        });


//        findViewById(R.id.bt_began).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                //AsynchTaskLearn.asynchTash(mainActivity);
//            }
//        });
    }
}
