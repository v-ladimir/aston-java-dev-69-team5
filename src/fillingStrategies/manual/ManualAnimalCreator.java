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
        ConsoleUtil.print("Введите вид животного:\n");
        return ConsoleUtil.userStringInput();
    }

    private String inputEyeColor() {
        ConsoleUtil.print("Введите цвет глаз:\n");
        return ConsoleUtil.userStringInput();
    }

    private boolean inputHasFur() {
        ConsoleUtil.print("Выберите имеет ли животное шерсть:\n");
        ConsoleUtil.print("1. Имеет\n");
        ConsoleUtil.print("2. Не имеет\n");
        ConsoleUtil.print("Выбор пользователя:\n");
        int userInput = ConsoleUtil.userIntInput(1, 2);
        return userInput == 1;
    }
}
