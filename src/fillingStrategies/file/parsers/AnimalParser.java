package fillingStrategies.file.parsers;

import customClasses.Animal;
import fillingStrategies.file.Parser;

public class AnimalParser implements Parser<Animal> {
    @Override
    public Animal getObjectFromString(String string) {
        String[] dataArray = string.split(",");
        String species = dataArray[0].split("-")[1].trim();
        String eyeColor = dataArray[1].split("-")[1].trim();
        boolean hasFur = Boolean.parseBoolean(dataArray[2].split("-")[1].trim());
        return new Animal.Builder()
                .setSpecies(species)
                .setEyeColor(eyeColor)
                .setHasFur(hasFur)
                .build();
    }
}
