package com.programmingninja.dagger2tutorial.helper;

import com.programmingninja.dagger2tutorial.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {SharePrefModule.class})
public interface MyComponent {
    void inject(MainActivity ma);
}
