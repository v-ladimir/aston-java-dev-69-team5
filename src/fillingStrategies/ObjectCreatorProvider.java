package fillingStrategies;

import fillingStrategies.file.creators.*;
import fillingStrategies.manual.*;
import fillingStrategies.random.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ObjectCreatorProvider {
    private Map<String, Supplier<ObjectCreator>> creators = new HashMap<>();;

    public ObjectCreatorProvider() {
        creators.put("Животное+Manual", ManualAnimalCreator::new);
        creators.put("Бочка+Manual", ManualBarrelCreator::new);
        creators.put("Человек+Manual", ManualPersonCreator::new);
        creators.put("Животное+Random", RandomAnimalGenerator::new);
        creators.put("Бочка+Random", RandomBarrelGenerator::new);
        creators.put("Человек+Random", RandomPersonGenerator::new);
        creators.put("Животное+File", FileAnimalCreator::new);
        creators.put("Бочка+File", FileBarrelCreator::new);
        creators.put("Человек+File", FilePersonCreator::new);
    }

    public ObjectCreator getCreator(String keyMap) {
        return creators.get(keyMap).get();
    }
}
