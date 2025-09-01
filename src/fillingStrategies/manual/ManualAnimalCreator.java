package fillingStrategies.manual;

import creators.ObjectCreator;
import application.ConsoleUtil;
import customClasses.Animal;

public class ManualAnimalCreator implements ObjectCreator<Animal> {

    @Override
    public Animal createObject() {
        String species = inputSpecies();
        String eyeColor = inputEyeColor();
        boolean hasFur = inputHasFur();

        Animal createdAnimal = new Animal.Builder()
                .setSpecies(species)
                .setEyeColor(eyeColor)
                .setHasFur(hasFur)
                .build();
        return createdAnimal;
    }

    private String inputSpecies() {
        ConsoleUtil.print("Input species:\n");
        String inputSpecies = ConsoleUtil.userStringInput();
        return inputSpecies;
    }

    private String inputEyeColor() {
        ConsoleUtil.print("Input eye color:\n");
        String inputEyeColor = ConsoleUtil.userStringInput();
        return inputEyeColor;
    }

    private boolean inputHasFur() {
        ConsoleUtil.print("Select whether the animal has fur:\n");
        ConsoleUtil.print("1. Has fur\n");
        ConsoleUtil.print("2. Hasn't fur\n");
        ConsoleUtil.print("User input:\n");
        int userInput = ConsoleUtil.userIntInput(1, 2);
        boolean hasFur = userInput == 1 ? true : false;
        return hasFur;
    }
}
