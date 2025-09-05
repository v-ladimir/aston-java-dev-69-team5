package tests;

import customClasses.Animal;
import search.BinarySearch;

import java.util.List;

public class TestBinarySearch implements Testing{
    @Override
    public boolean testFunction() {
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
        List<Comparable<Animal>> list = List.of(animal1, animal2, animal3, animal4, animal5, animal6);
        System.out.println(list.indexOf(animal6) + " = " + BinarySearch.binarySearch(list, animal6));

        if (list.indexOf(animal6) == BinarySearch.binarySearch(list, animal6)) {
            return true;
        }
        return false;
    }
}
