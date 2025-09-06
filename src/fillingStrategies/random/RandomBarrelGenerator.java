package fillingStrategies.random;

import fillingStrategies.ObjectCreator;
import customClasses.Barrel;
import java.util.Random;

public class RandomBarrelGenerator implements ObjectCreator<Barrel> {
    private final Random random = new Random();
    private String[] storedMaterialArray =
            {"Вода", "Вино", "Бензин", "Мед", "Пиво", "Зерно", "Соль", "Рыба", "Яблоки", "Виски"};

    @Override
    public Barrel createObject() {
        double volume = getRandomVolume();
        String storedMaterial = getRandomStoredMaterial();
        Barrel.BarrelMaterial barrelMaterial = getRandomBarrelMaterial();

        return new Barrel.Builder()
                .setVolume(volume)
                .setStoredMaterial(storedMaterial)
                .setBarrelMaterial(barrelMaterial)
                .build();
    }

    private double getRandomVolume() {
        final double minVolume = 0.1;
        final double maxVolume = 1000.0;
        double randomVolume = random.nextDouble(minVolume, maxVolume);
        return Math.round(randomVolume * 10) / 10.0;
    }

    private String getRandomStoredMaterial() {
        int indexRandomStoredMaterial = random.nextInt(storedMaterialArray.length);
        return storedMaterialArray[indexRandomStoredMaterial];
    }

    private Barrel.BarrelMaterial getRandomBarrelMaterial() {
        int indexRandomBarrelMaterial = random.nextInt(Barrel.BarrelMaterial.values().length);
        return Barrel.BarrelMaterial.values()[indexRandomBarrelMaterial];
    }
}
