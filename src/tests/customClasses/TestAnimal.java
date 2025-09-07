package tests.customClasses;

import customClasses.Animal;

public class TestAnimal {
    public static void main(String[] args) {
        System.out.println(new Animal.Builder()
                .setSpecies("кот")
                .setEyeColor("зелёный")
                .setHasFur(true)
                .build());
        try {
            System.out.println(new Animal.Builder()
                    .setSpecies("")
                    .setEyeColor("зелёный")
                    .setHasFur(true)
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(new Animal.Builder()
                    .setSpecies("кот")
                    .setEyeColor("")
                    .setHasFur(true)
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(new Animal.Builder()
                    .setSpecies("кот")
                    .setHasFur(true)
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(new Animal.Builder()
                    .setEyeColor("зелёный")
                    .setHasFur(true)
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(new Animal.Builder()
                    .setSpecies("кот")
                    .setEyeColor("зелёный")
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
