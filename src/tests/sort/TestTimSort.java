package tests.sort;

import customClasses.*;
import fillingStrategies.ListConstructor;
import fillingStrategies.random.*;
import sort.TimSort;
import tests.Testing;

public class TestTimSort implements Testing {

    public static void main(String[] args) {
        new TestTimSort().testFunction();
    }

    @Override
    public void testFunction() {
        System.out.println("Testing TimSort");
        ListConstructor<Animal> animalListConstructor = new ListConstructor<>(new RandomAnimalGenerator());
        TimSort<Animal> animalTimSort = new TimSort<>();
        animalTimSort.sort(animalListConstructor.getListSingleThread(10), Animal.getComparator())
                .forEach(System.out::println);
        System.out.println();

        ListConstructor<Barrel> barrelListConstructor = new ListConstructor<>(new RandomBarrelGenerator());
        TimSort<Barrel> barrelTimSort = new TimSort<>();
        barrelTimSort.sort(barrelListConstructor.getListSingleThread(10), Barrel.getComparator())
                .forEach(System.out::println);
        System.out.println();

        ListConstructor<Person> personListConstructor = new ListConstructor<>(new RandomPersonGenerator());
        TimSort<Person> personTimSort = new TimSort<>();
        personTimSort.sort(personListConstructor.getListSingleThread(10), Person.getComparator())
                .forEach(System.out::println);
        System.out.println();
    }
}
