package application.services;

import customClasses.Animal;
import customClasses.Barrel;
import customClasses.Person;
import fillingStrategies.manual.ManualAnimalCreator;
import fillingStrategies.manual.ManualBarrelCreator;
import fillingStrategies.manual.ManualPersonCreator;
import search.BinarySearch;

import java.util.List;

public class SearchService {
    private final CollectionService collectionService;

    public SearchService(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    public void searchInCollection() {
        if (collectionService.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }

        if (!isSorted(collectionService.getCollection(), collectionService.getCollectionType())) {
            System.out.println("Коллекция не отсортирована! Сначала отсортируйте её.");
            return;
        }

        int index = -1;
        System.out.print("Введите данные объекта для поиска: ");

        switch (collectionService.getCollectionType()) {
            case "Животное" ->
                    index = BinarySearch.binarySearch(
                            (List<Comparable<Animal>>) collectionService.getCollection(),
                            new ManualAnimalCreator().createObject()
                    );
            case "Бочка" ->
                    index = BinarySearch.binarySearch(
                            (List<Comparable<Barrel>>) collectionService.getCollection(),
                            new ManualBarrelCreator().createObject()
                    );
            case "Человек" ->
                    index = BinarySearch.binarySearch(
                            (List<Comparable<Person>>) collectionService.getCollection(),
                            new ManualPersonCreator().createObject()
                    );
        }

        System.out.println("\n=== РЕЗУЛЬТАТЫ ПОИСКА ===");
        if (index >= 0) {
            System.out.println("Поиск завершен. Найденное значение находится под индексом " + index);
            System.out.println(collectionService.getCollection().get(index));
        } else {
            System.out.println("Ничего не найдено");
        }
    }

    private boolean isSorted(List<?> collection, String collectionType) {
        if (collection == null || collection.size() <= 1) {
            return true;
        }

        switch (collectionType) {
            case "Животное" -> {
                return isSortedAnimal((List<Animal>) collection);
            }
            case "Бочка" -> {
                return isSortedBarrel((List<Barrel>) collection);
            }
            case "Человек" -> {
                return isSortedPerson((List<Person>) collection);
            }
            default -> {
                return false;
            }
        }
    }

    private boolean isSortedAnimal(List<Animal> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSortedBarrel(List<Barrel> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSortedPerson(List<Person> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }
}
