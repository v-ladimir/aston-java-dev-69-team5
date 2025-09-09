package application.services;

import customClasses.*;
import sort.TimSort;

import java.util.Comparator;
import java.util.function.Function;

public class SortService {
    private final CollectionService collectionService;

    public SortService(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    public void sortCollection() {
        if (collectionService.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        TimSort timSort = new TimSort();
        switch (collectionService.getCollectionType()) {
            case "Животное" -> timSort.sort(collectionService.getCollection(), Animal.getComparator());
            case "Бочка" -> timSort.sort(collectionService.getCollection(), Barrel.getComparator());
            case "Человек" -> timSort.sort(collectionService.getCollection(), Person.getComparator());
        }
        System.out.println("Коллекция отсортирована");
    }

    public void sortCollectionModify() {
        if (collectionService.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }
        TimSort timSort = new TimSort();
        switch (collectionService.getCollectionType()) {
            case "Животное" -> System.out.println("У класса типа Animal нет целочисленного поля." +
                    "\nСортировка не может быть выполнена");
            case "Бочка" -> System.out.println("У класса типа Barrel нет целочисленного поля." +
                    "\nСортировка не может быть выполнена");
            case "Человек" -> {
                Comparator<Person> comparatorByNumberField = Comparator.comparing(Person::getAge);
                Function<Person, Integer> getNumberField = Person::getAge;
                timSort.sortModify(collectionService.getCollection(), comparatorByNumberField, getNumberField);
                System.out.println("Отсортированы объекты коллекции только с четным числовым полем");
            }
        }
    }
}
