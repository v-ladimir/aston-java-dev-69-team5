package fillingStrategies.file;

public interface Parser<T> {
    public T getObjectFromString(String string);
}
