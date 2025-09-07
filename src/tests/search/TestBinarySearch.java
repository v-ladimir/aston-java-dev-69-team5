package tests.search;

import customClasses.Animal;
import customClasses.Barrel;
import customClasses.Person;
import fillingStrategies.ListConstructor;
import fillingStrategies.random.RandomAnimalGenerator;
import fillingStrategies.random.RandomBarrelGenerator;
import fillingStrategies.random.RandomPersonGenerator;
import search.BinarySearch;
import sort.TimSort;

import java.util.List;

public class TestBinarySearch {
    public static void main(String[] args) {
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
