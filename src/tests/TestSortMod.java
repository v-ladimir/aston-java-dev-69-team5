package tests;

import customClasses.Person;
import fillingStrategies.ListConstructor;
import fillingStrategies.random.RandomPersonGenerator;
import sort.TimSort;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class TestSortMod implements Testing {
    public static void main(String[] args) {
        new TestSortMod().testFunction();
    }

    @Override
    public void testFunction() {
        List<Person> list = new ListConstructor<Person>(new RandomPersonGenerator()).getListSingleThread(10);
        list.forEach(person -> System.out.println(person));
        System.out.println();

        Comparator<Person> comparatorByNumberField = Comparator.comparing(Person::getAge);
        Function<Person, Integer> getNumberField = Person::getAge;

        TimSort<Person> timSort = new TimSort<>();
        list = timSort.sortModify(list, comparatorByNumberField, getNumberField);
        list.forEach(person -> System.out.println(person));
        System.out.println();


    }
}
