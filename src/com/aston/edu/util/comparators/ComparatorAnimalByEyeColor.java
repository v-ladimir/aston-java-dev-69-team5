package com.aston.edu.util.comparators;

import com.aston.edu.model.Animal;

import java.util.Comparator;

public class ComparatorAnimalByEyeColor implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getEyeColor().compareTo(o2.getEyeColor());
    }
}
