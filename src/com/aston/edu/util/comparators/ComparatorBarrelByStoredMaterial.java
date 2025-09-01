package com.aston.edu.util.comparators;

import com.aston.edu.model.Barrel;

import java.util.Comparator;

public class ComparatorBarrelByStoredMaterial implements Comparator<Barrel> {
    @Override
    public int compare(Barrel o1, Barrel o2) {
        return o1.getStoredMaterial().compareTo(o2.getStoredMaterial());
    }
}
