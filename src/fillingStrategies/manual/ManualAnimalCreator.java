package fillingStrategies.manual;

import fillingStrategies.ObjectCreator;
import customClasses.Animal;
import util.ConsoleUtil;

import java.util.Scanner;

public class ManualAnimalCreator implements ObjectCreator<Animal> {

    @Override
    public Animal createObject() {
        System.out.println("Заполните данные для создания объекта");
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
        System.out.print("Введите вид животного: ");
        String input;
        while(true) {
            input = ConsoleUtil.userStringInput();
            if (input.isBlank()) {
                System.out.println("Параметр не может быть пустым. Введите корректные данные.");
                continue;
            }
            break;
        }
        return input;
    }

    private String inputEyeColor() {
        System.out.print("Введите цвет глаз: ");
        String input;
        while(true) {
            input = ConsoleUtil.userStringInput();
            if (input.isBlank()) {
                System.out.println("Параметр не может быть пустым. Введите корректные данные.");
                continue;
            }
            break;
        }
        return input;
    }

    private boolean inputHasFur() {
        System.out.println("Выберите имеет ли животное шерсть:");
        System.out.println("1. Имеет");
        System.out.println("2. Не имеет");
        System.out.print("Выбор пользователя: ");
        int userInput = ConsoleUtil.userIntInput(1, 2);
        return userInput == 1;
    }
}
