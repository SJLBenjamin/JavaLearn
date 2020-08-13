package com.example.myjavalib;

public class MyClass {
    public static void main(String[] args) {

        FactoryProxy factoryProxy = new FactoryProxy(new Dog());
        Animal animal = (Animal)factoryProxy.getProInstance();
        animal.speak();


        FactoryProxy catFactoryProxy = new FactoryProxy(new Cat());
        Animal catAnimal = (Animal)catFactoryProxy.getProInstance();
        catAnimal.catSpeak();

       /* Thread t2 = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("t2开始运行");
                try {
                    sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++)
                    System.out.println("t2");
            }
        };


        final Thread t1 = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("t1开始运行");
                try {
                    sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++)
                    System.out.println("t1");
            }
        };

        Thread t4 = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("t4开始运行");
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 4; i++) {
                    System.out.println("t4");
                }
            }
        };
        Thread t3 = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("t3开始运行");
                try {
                    sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 10; i++) {
                    System.out.println("t3");
                }
            }
        };
        t1.start();
        t2.start();
        t3.start();
        t4.start();
*/
    }

    public static void ye(int i){
        System.out.println(++i);
    }

}
