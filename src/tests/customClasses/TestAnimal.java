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

        try {
            Animal animal2 = new Animal.Builder()
                    .setSpecies("")
                    .setEyeColor("зелёный")
                    .setHasFur(true)
                    .build();
            System.out.println(animal2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Animal animal2 = new Animal.Builder()
                    .setSpecies("кот")
                    .setEyeColor("")
                    .setHasFur(true)
                    .build();
            System.out.println(animal2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Animal animal2 = new Animal.Builder()
                    .setSpecies("кот")
                    .setHasFur(true)
                    .build();
            System.out.println(animal2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Animal animal2 = new Animal.Builder()
                    .setEyeColor("зелёный")
                    .setHasFur(true)
                    .build();
            System.out.println(animal2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Animal animal2 = new Animal.Builder()
                    .setSpecies("кот")
                    .setEyeColor("зелёный")
                    .build();
            System.out.println(animal2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
