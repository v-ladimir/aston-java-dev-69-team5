package tests.sort;

import customClasses.Animal;
import customClasses.Barrel;
import customClasses.Person;
import fillingStrategies.ListConstructor;
import fillingStrategies.random.RandomAnimalGenerator;
import fillingStrategies.random.RandomBarrelGenerator;
import fillingStrategies.random.RandomPersonGenerator;
import sort.TimSort;

public class TestTimSort {
    public static void main(String[] args) {
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
