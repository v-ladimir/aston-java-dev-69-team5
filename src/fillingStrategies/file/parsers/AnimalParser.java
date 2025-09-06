package fillingStrategies.file.parsers;

import customClasses.Animal;

public class AnimalParser implements Parser<Animal> {
    @Override
    public Animal getObjectFromString(String string) {
        String[] dataArray = string.split(",");
        String species = dataArray[0].split("-")[1].trim();
        String eyeColor = dataArray[1].split("-")[1].trim();
        String displayHasFur = dataArray[2].split("-")[1].trim();
        boolean hasFur = "да".equalsIgnoreCase(displayHasFur);
        return new Animal.Builder()
                .setSpecies(species)
                .setEyeColor(eyeColor)
                .setHasFur(hasFur)
                .build();
    }
}
