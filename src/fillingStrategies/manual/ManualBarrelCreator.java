package fillingStrategies.manual;

import creators.ObjectCreatorStrategies;
import customClasses.Barrel;

public class ManualBarrelCreator implements ObjectCreatorStrategies<Barrel> {

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
        double inputVolume;
        try {
            inputVolume = Double.parseDouble(ConsoleUtil.userStringInput());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Некорректный ввод. Необходимо ввести целое или дробное число");
        }
        return inputVolume;
    }

    private String inputStoredMaterial() {
        ConsoleUtil.print("Введите тип содержимого бочки:\n");
        return ConsoleUtil.userStringInput();
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
