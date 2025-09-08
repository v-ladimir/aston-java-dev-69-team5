package tests.search;

import customClasses.*;
import fillingStrategies.ListConstructor;
import fillingStrategies.random.*;
import search.BinarySearch;
import sort.TimSort;
import tests.Testing;

import java.util.List;

public class TestBinarySearch implements Testing {

    public static void main(String[] args) {
        new TestBinarySearch().testFunction();
    }

    @Override
    public void testFunction() {
        System.out.println("Testing BinarySearch");
        ListConstructor<Animal> animalListConstructor = new ListConstructor<>(new RandomAnimalGenerator());
        TimSort<Animal> animalTimSort = new TimSort<>();
        List<Animal> animalSortList =
                animalTimSort.sort(animalListConstructor.getListSingleThread(10), Animal.getComparator());
        System.out.println(BinarySearch.binarySearch(animalSortList, animalSortList.get(0)));

        ListConstructor<Barrel> barrelListConstructor = new ListConstructor<>(new RandomBarrelGenerator());
        TimSort<Barrel> barrelTimSort = new TimSort<>();
        List<Barrel> barrelSortList =
                barrelTimSort.sort(barrelListConstructor.getListSingleThread(10), Barrel.getComparator());
        System.out.println(BinarySearch.binarySearch(barrelSortList, barrelSortList.get(0)));

        ListConstructor<Person> personListConstructor = new ListConstructor<>(new RandomPersonGenerator());
        TimSort<Person> personTimSort = new TimSort<>();
        List<Person> personSortList =
                personTimSort.sort(personListConstructor.getListSingleThread(10), Person.getComparator());
        System.out.println(BinarySearch.binarySearch(personSortList, personSortList.get(0)));
    }
}
