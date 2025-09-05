package creators;

public class ObjectCreatorProvider<T> {
    private ObjectCreatorStrategies<T> objectCreator;

    public ObjectCreatorProvider(ObjectCreatorStrategies<T> objectCreator) {
        this.objectCreator = objectCreator;
    }

    public void setObjectCreator(ObjectCreatorStrategies<T> objectCreator) {
        this.objectCreator = objectCreator;
    }

    public T createObject() {
        return objectCreator.createObject();
    }
}
