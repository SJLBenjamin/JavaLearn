package com.example.javalearn.dagger;
import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    String name;
    int age;

    public MainActivityModule(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Provides
    Person providerPerson(){
        return new Person(name,age);
    }


}
