package application.services;

import customClasses.*;
import sort.TimSort;

public class SortService {
    private final CollectionService collectionService;
    private final OutputService outputService;

    public SortService(CollectionService collectionService, OutputService outputService) {
        this.collectionService = collectionService;
        this.outputService = outputService;
    }
    // Метод для работы с сортировкой коллекции
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
}
