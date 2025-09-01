package application.services;

import customClasses.Animal;
import customClasses.Barrel;
import customClasses.Person;
import fillingStrategies.manual.ManualAnimalCreator;
import fillingStrategies.manual.ManualBarrelCreator;
import fillingStrategies.manual.ManualPersonCreator;
import search.BinarySearch;
import sort.TimSort;

import java.util.Comparator;
import java.util.List;

public class SortService {
    private final CollectionService collectionService;
    private final OutputService outputService;

    public SortService(CollectionService collectionService, OutputService outputService) {
        this.collectionService = collectionService;
        this.outputService = outputService;
    }

    public void sortCollection() {
        if (collectionService.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }

        TimSort timSort = new TimSort();

        Comparator<Animal> animalComparator = Comparator
                .comparing(Animal::getSpecies)
                .thenComparing(Animal::getEyeColor)
                .thenComparing(Animal::hasFur);

        Comparator<Barrel> barrelComparator = Comparator
                .comparing(Barrel::getVolume)
                .thenComparing(Barrel::getStoredMaterial)
                .thenComparing(Barrel::getBarrelMaterial);

        Comparator<Person> personComparator = Comparator
                .comparing(Person::getLastName)
                .thenComparing(Person::getAge)
                .thenComparing(Person::getGender);

        switch (collectionService.getCollectionType()) {
            case "Животное" -> timSort.sort(collectionService.getCollection(), animalComparator);
            case "Бочка" -> timSort.sort(collectionService.getCollection(), barrelComparator);
            case "Человек" -> timSort.sort(collectionService.getCollection(), personComparator);
        }

        System.out.println("Коллекция отсортирована");
        outputService.showCollection();
    }
}
