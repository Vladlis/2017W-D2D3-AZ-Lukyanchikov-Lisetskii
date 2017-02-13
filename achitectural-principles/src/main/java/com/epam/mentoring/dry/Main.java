package com.epam.mentoring.dry;

public class Main {
    public static void main(String[] args) {
        Hero[] heros = new Hero[] {
                new Archer(),
                new Wizard(),
        };

        for (Hero hero : heros) {
            hero.prepareForBattle();
            hero.fight();
        }
    }
}
