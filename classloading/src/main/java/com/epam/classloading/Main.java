package com.epam.classloading;

import org.apache.log4j.Logger;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            CustomClassLoader customClassLoader = new CustomClassLoader();

            Animal[] animals = new Animal[2];
            animals[0] = (Animal) getClassInstance(customClassLoader, "com.epam.classloading.Cat");
            animals[1] = (Animal) getClassInstance(customClassLoader, "com.epam.classloading.Dog");

            for (Animal animal : animals) {
                animal.play();
                animal.voice();
            }
        } catch (Exception ex) {
            LOG.error(ex);
        }
    }

    private static Object getClassInstance(CustomClassLoader customClassLoader, String className)
            throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> catClass = customClassLoader.loadClass(className);
        LOG.debug(className + " is loaded successfully");
        return catClass.newInstance();
    }
}
