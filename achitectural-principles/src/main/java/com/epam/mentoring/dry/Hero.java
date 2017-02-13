package com.epam.mentoring.dry;

public abstract class Hero {
    abstract void fight();
    abstract void train();
    abstract void prepareWeapon();

    /**
     * Example of the DRY principle
     */
    void prepareForBattle() {
        train();
        prepareWeapon();
    }
}
