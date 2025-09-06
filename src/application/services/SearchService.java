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
    // Метод для работы с поиском
    public int searchInCollection() {
        int index = -1;
        if (collectionService.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return index;
        }
        if (!collectionService.isSorted()) {
            System.out.println("Коллекция не отсортирована! Сначала отсортируйте её.");
            return index;
        }
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
            collectionService.setSearchIndex(index);
            System.out.println(collectionService.getCollection().get(index));
        } else {
            System.out.println("Ничего не найдено");
        }
        return index;
    }
}
