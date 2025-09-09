package fillingStrategies.manual;

import fillingStrategies.ObjectCreator;
import customClasses.Barrel;
import util.ConsoleUtil;

import java.util.Scanner;

public class ManualBarrelCreator implements ObjectCreator<Barrel> {

    @Override
    public Barrel createObject() {
        System.out.println("Заполните данные для создания объекта");
        double volume = inputVolume();
        String storedMaterial = inputStoredMaterial();
        Barrel.BarrelMaterial barrelMaterial = inputBarrelMaterial();

        return new Barrel.Builder()
                .setVolume(volume)
                .setStoredMaterial(storedMaterial)
                .setBarrelMaterial(barrelMaterial)
                .build();
    }

    private double inputVolume() {
        System.out.print("Введите объем: ");
        double inputVolume = 0;
        int minValue = 0;
        int maxValue = 1000;
        while (true) {
            try {
                inputVolume = Double.parseDouble(ConsoleUtil.userStringInput());
                if(inputVolume <= minValue || inputVolume > maxValue) {
                    System.out.printf("Некорректный ввод. Объем должен быть в диапазоне %d - %d%n", minValue, maxValue);
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Необходимо ввести целое или дробное число.");
            }
        }
        return inputVolume;
    }

    private String inputStoredMaterial() {
        System.out.println("Введите тип содержимого бочки:");
        String input;
        while(true) {
            input = ConsoleUtil.userStringInput();
            if (input.isBlank()) {
                System.out.println("Параметр не может быть пустым. Введите корректные данные");
                continue;
            }
            break;
        }
        return input;
    }

    private Barrel.BarrelMaterial inputBarrelMaterial() {
        System.out.println("Выберите материал из которого изготовлена бочка: ");
        int pointsNumber = Barrel.BarrelMaterial.values().length;
        for (int i = 0; i < pointsNumber; i++) {
            System.out.printf("%d. %s%n", i + 1, Barrel.BarrelMaterial.values()[i].getDisplayName());
        }
        System.out.print("Ввод пользователя: ");
        int userInput = ConsoleUtil.userIntInput(1, pointsNumber);
        return Barrel.BarrelMaterial.values()[userInput - 1];
    }
}
