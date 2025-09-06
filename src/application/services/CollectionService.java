package application.services;

import customClasses.Animal;
import customClasses.Barrel;
import customClasses.Person;

import java.util.ArrayList;
import java.util.List;

// Сервис для работы с коллекцией
public class CollectionService {
    private List<?> collection;
    private String collectionType = "Не выбрана";
    private int searchIndex = -1;

    public void setCollectionType(String type) {
        this.collectionType = type;
        switch (type) {
            case "Животное" -> collection = new ArrayList<Animal>();
            case "Бочка" -> collection = new ArrayList<Barrel>();
            case "Человек" -> collection = new ArrayList<Person>();
        }
    }

    public String getCollectionType() {
        return collectionType;
    }

    public List<?> getCollection() {
        return collection;
    }

    public void setSearchIndex(int index) {
        searchIndex = index;
    }

    public int getSearchIndex() {
        return searchIndex;
    }

    public void searchIndexReset() {
        searchIndex = -1;
    }

    public void setCollection(List<?> newCollection) {
        this.collection = newCollection;
    }

    public boolean isEmpty() {
        return collection == null || collection.isEmpty();
    }

    public void clearCollection() {
        if (collection != null) {
            collection.clear();
        }
    }

    public int getSize() {
        return collection != null ? collection.size() : 0;
    }

    public boolean isSorted() {
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
