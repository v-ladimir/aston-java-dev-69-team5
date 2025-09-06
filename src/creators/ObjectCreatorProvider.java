package creators;

import fillingStrategies.file.creators.FileAnimalCreator;
import fillingStrategies.file.creators.FileBarrelCreator;
import fillingStrategies.file.creators.FilePersonCreator;
import fillingStrategies.manual.ManualAnimalCreator;
import fillingStrategies.manual.ManualBarrelCreator;
import fillingStrategies.manual.ManualPersonCreator;
import fillingStrategies.random.RandomAnimalGenerator;
import fillingStrategies.random.RandomBarrelGenerator;
import fillingStrategies.random.RandomPersonGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ObjectCreatorProvider<T> {
    private Map<String, Supplier<ObjectCreator>> creators = new HashMap<>();;

    public ObjectCreatorProvider() {
        creators.put("Животное+Manual", () -> new ManualAnimalCreator());
        creators.put("Бочка+Manual", () -> new ManualBarrelCreator());
        creators.put("Человек+Manual", () -> new ManualPersonCreator());
        creators.put("Животное+Random", () -> new RandomAnimalGenerator());
        creators.put("Бочка+Random", () -> new RandomBarrelGenerator());
        creators.put("Человек+Random", () -> new RandomPersonGenerator());
        creators.put("Животное+File", () -> new FileAnimalCreator());
        creators.put("Бочка+File", () -> new FileBarrelCreator());
        creators.put("Человек+File", () -> new FilePersonCreator());
    }

    public ObjectCreator getCreator(String keyMap) {
        return creators.get(keyMap).get();
    }
}
