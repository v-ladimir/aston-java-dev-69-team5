package com.aston.edu.factory;

public class ObjectCreatorProvider<T> {
    private ObjectCreator<T> objectCreator;

    public ObjectCreatorProvider(ObjectCreator<T> objectCreator) {
        this.objectCreator = objectCreator;
    }

    public void setObjectCreator(ObjectCreator<T> objectCreator) {
        this.objectCreator = objectCreator;
    }

    public T createObject() {
        return objectCreator.createObject();
    }
}
