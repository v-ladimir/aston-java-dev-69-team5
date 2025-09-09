package fillingStrategies.file.parsers;

public interface Parser<T> {
    T getObjectFromString(String string);
}
