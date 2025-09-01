package fillingStrategies.manual;

import creators.ObjectCreator;
import customClasses.Animal;

public class ManualAnimalCreator implements ObjectCreator<Animal> {

    @Override
    public Animal createObject() {
        String species = inputSpecies();
        String eyeColor = inputEyeColor();
        boolean hasFur = inputHasFur();

        return new Animal.Builder()
                .setSpecies(species)
                .setEyeColor(eyeColor)
                .setHasFur(hasFur)
                .build();
    }

    private String inputSpecies() {
        ConsoleUtil.print("Input species:\n");
        return ConsoleUtil.userStringInput();
    }

    private String inputEyeColor() {
        ConsoleUtil.print("Input eye color:\n");
        return ConsoleUtil.userStringInput();
    }

    private boolean inputHasFur() {
        ConsoleUtil.print("Select whether the animal has fur:\n");
        ConsoleUtil.print("1. Has fur\n");
        ConsoleUtil.print("2. Hasn't fur\n");
        ConsoleUtil.print("User input:\n");
        int userInput = ConsoleUtil.userIntInput(1, 2);
        return userInput == 1;
    }
}
