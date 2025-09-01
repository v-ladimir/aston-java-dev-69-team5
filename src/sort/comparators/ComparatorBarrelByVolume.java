package sort.comparators;

import customClasses.Barrel;

import java.util.Comparator;

public class ComparatorBarrelByVolume implements Comparator<Barrel> {
    @Override
    public int compare(Barrel o1, Barrel o2) {
        return Double.compare(o1.getVolume(), o2.getVolume());
    }
}
