package com.aston.edu.factory;

import java.util.ArrayList;
import java.util.List;

public class ListConstructor<T> {
    private ObjectCreatorProvider<T> objectCreator;

    public ObjectCreatorProvider<T> getObjectCreator() {
        return objectCreator;
    }

    public void setObjectCreator(ObjectCreatorProvider<T> objectCreator) {
        this.objectCreator = objectCreator;
    }

    public List<T> getList(int size) {
        if (objectCreator == null) {
            throw new IllegalStateException("object creator not set");
        }
        if (size == 0) {
            throw new IllegalArgumentException("size must be > 0");
        }

        List<T> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(objectCreator.createObject());
        }
        return list;
    }
}
