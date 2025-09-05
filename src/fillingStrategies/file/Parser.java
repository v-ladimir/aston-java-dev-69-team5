package fillingStrategies.file;

public interface Parser<T> {
    T getObjectFromString(String string);
}
