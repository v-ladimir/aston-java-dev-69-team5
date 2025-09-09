package tests.customClasses;

import customClasses.Animal;
import tests.Testing;

public class TestAnimal implements Testing {

    public static void main(String[] args) {
        new TestAnimal().testFunction();
    }

    @Override
    public void testFunction() {
        System.out.println("Testing Animal");
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
