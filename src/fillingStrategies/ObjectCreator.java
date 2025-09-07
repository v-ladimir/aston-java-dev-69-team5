package fillingStrategies;

import creators.ObjectCreatorStrategies;
import fillingStrategies.manual.*;
import fillingStrategies.random.*;
import java.util.HashMap;
import java.util.Map;

public class ObjectCreator {
    private Map<String, ObjectCreatorStrategies> creators = new HashMap<>();;

    public ObjectCreator() {
        creators.put("Животное, manualInput", new ManualAnimalCreator());
        creators.put("Бочка, manualInput", new ManualBarrelCreator());
        creators.put("Человек, manualInput", new ManualPersonCreator());
        creators.put("Животное, randomInput", new RandomAnimalGenerator());
        creators.put("Бочка, randomInput", new RandomBarrelGenerator());
        creators.put("Человек, randomInput", new RandomPersonGenerator());
    }

    public Map<String, ObjectCreatorStrategies> getCreators() {
        return creators;
    }
}
