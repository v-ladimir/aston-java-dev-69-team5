package tests;

import customClasses.Animal;
import search.BinarySearch;

import java.util.List;

public class TestBinarySearch {
    public static void main(String[] args) {
        Animal animal1 = new Animal.Builder()
                .setEyeColor("1")
                .setSpecies("red")
                .setHasFur(true)
                .setHasFur(false)
                .build();
        Animal animal2 = new Animal.Builder()
                .setEyeColor("2")
                .setSpecies("white")
                .setHasFur(true)
                .setHasFur(false)
                .build();
        Animal animal3 = new Animal.Builder()
                .setEyeColor("3")
                .setSpecies("black")
                .setHasFur(true)
                .setHasFur(false)
                .build();
        Animal animal4 = new Animal.Builder()
                .setEyeColor("4")
                .setSpecies("red")
                .setHasFur(true)
                .setHasFur(false)
                .build();
        Animal animal5 = new Animal.Builder()
                .setEyeColor("5")
                .setSpecies("blue")
                .setHasFur(true)
                .setHasFur(false)
                .build();
        Animal animal6 = new Animal.Builder()
                .setEyeColor("6")
                .setSpecies("yellow")
                .setHasFur(true)
                .setHasFur(false)
                .build();
        System.out.println(BinarySearch.binarySearch(List.of(animal1, animal2, animal3, animal4, animal5, animal6), animal6));
    }
}
