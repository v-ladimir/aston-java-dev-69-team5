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
}
