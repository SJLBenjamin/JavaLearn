package com.example.javalearn.dagger;

import com.example.javalearn.MainActivity;
import dagger.Component;

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
