package com.aston.edu.factory.random;

import com.aston.edu.factory.ObjectCreator;
import com.aston.edu.model.Animal;

import java.util.Random;

public class RandomAnimalGenerator implements ObjectCreator<Animal> {
    private final Random random = new Random();
    private String[] speciesArray = {"Cat", "Dog", "Lion", "Tiger", "Elephant", "Monkey",
            "Giraffe", "Zebra", "Bear", "Wolf", "Fox", "Deer", "Rabbit", "Horse", "Kangaroo"};
    private String[] eyeColorArray = {"Blue", "Brown", "Green", "Gray", "Amber", "Red", "Black"};

    @Override
    public Animal createObject() {
        String species = getRandomSpecies();
        String eyeColor = getRandomEyeColor();
        boolean hasFur = getRandomHasFur();

        Animal generatedAnimal = new Animal.Builder()
                .setSpecies(species)
                .setEyeColor(eyeColor)
                .setHasFur(hasFur)
                .build();

        return generatedAnimal;
    }

    private String getRandomSpecies() {
        int indexRandomSpecies = random.nextInt(speciesArray.length);
        return speciesArray[indexRandomSpecies];
    }

    private String getRandomEyeColor() {
        int indexRandomEyeColor = random.nextInt(eyeColorArray.length);
        return eyeColorArray[indexRandomEyeColor];
    }

    private boolean getRandomHasFur() {
        return random.nextBoolean();
    }
}
