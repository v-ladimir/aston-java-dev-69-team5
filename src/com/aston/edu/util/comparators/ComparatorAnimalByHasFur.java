package com.aston.edu.util.comparators;

import com.aston.edu.model.Animal;

import java.util.Comparator;

public class ComparatorAnimalByHasFur implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return Boolean.compare(o1.hasFur(), o2.hasFur());
    }
}
