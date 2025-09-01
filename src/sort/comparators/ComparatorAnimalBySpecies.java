package sort.comparators;

import customClasses.Animal;

import java.util.Comparator;

public class ComparatorAnimalBySpecies implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getSpecies().compareTo(o2.getSpecies());
    }
}
