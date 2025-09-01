package sort.comparators;

import customClasses.Barrel;

import java.util.Comparator;

public class ComparatorBarrelByBarrelMaterial implements Comparator<Barrel> {
    @Override
    public int compare(Barrel o1, Barrel o2) {
        return o1.getBarrelMaterial().compareTo(o2.getBarrelMaterial());
    }
}
