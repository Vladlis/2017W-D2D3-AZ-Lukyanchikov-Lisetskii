package com.epam.classloading;

public class Dog implements Animal {
    @Override
    public void play() {
        System.out.println("Bring a stick");
    }

    @Override
    public void voice() {
        System.out.println("Bark");
    }
}
