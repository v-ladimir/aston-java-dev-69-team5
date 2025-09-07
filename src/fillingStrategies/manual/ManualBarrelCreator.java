package fillingStrategies.manual;

import fillingStrategies.ObjectCreator;
import customClasses.Barrel;

public class ManualBarrelCreator implements ObjectCreator<Barrel> {

    @Override
    public Barrel createObject() {
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
        ConsoleUtil.print("Введите объем:\n");
        double inputVolume = 0;
        int minValue = 0;
        int maxValue = 1000;
        while (true) {
            try {
                inputVolume = Double.parseDouble(ConsoleUtil.userStringInput());
                if(inputVolume <= minValue || inputVolume > maxValue) {
                    ConsoleUtil.print("Некорректный ввод. Объем должен быть в диапазоне %d - %d\n".formatted(minValue, maxValue));
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                ConsoleUtil.print("Некорректный ввод. Необходимо ввести целое или дробное число\n");
            }
        }
        return inputVolume;
    }

    private String inputStoredMaterial() {
        ConsoleUtil.print("Введите тип содержимого бочки:\n");
        String input;
        while(true) {
            input = ConsoleUtil.userStringInput();
            if (input.isBlank()) {
                ConsoleUtil.print("Параметр не может быть пустым. Введите корректные данные\n");
                continue;
            }
            break;
        }
        return input;
    }

    private Barrel.BarrelMaterial inputBarrelMaterial() {
        ConsoleUtil.print("Выберите материал из которого изготовлена бочка:\n");
        int pointsNumber = Barrel.BarrelMaterial.values().length;
        for (int i = 0; i < pointsNumber; i++) {
            ConsoleUtil.print("%d. %s\n".formatted(i + 1, Barrel.BarrelMaterial.values()[i]));
        }
        ConsoleUtil.print("Ввод пользователя:\n");
        int userInput = ConsoleUtil.userIntInput(1, pointsNumber);
        return Barrel.BarrelMaterial.values()[userInput - 1];
    }
}
