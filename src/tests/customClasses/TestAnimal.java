package tests.customClasses;

import customClasses.Animal;

public class TestAnimal {
    public static void main(String[] args) {
        Animal animal1 = new Animal.Builder()
                .setSpecies("кот")
                .setEyeColor("зелёный")
                .setHasFur(true)
                .build();
        System.out.println(animal1);

        Animal animal2 = new Animal.Builder()
                .setSpecies("")
                .setHasFur(true)
                .build();
        System.out.println(animal2);

    }
}
