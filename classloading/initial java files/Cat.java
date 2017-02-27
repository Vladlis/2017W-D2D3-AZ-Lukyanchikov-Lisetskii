package com.epam.classloading;

public class Cat implements Animal {
    @Override
    public void play() {
        System.out.println("Catch a toy mouse");
    }

    @Override
    public void voice() {
        System.out.println("Meow");
    }
}
