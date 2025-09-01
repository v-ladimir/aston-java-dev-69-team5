package fillingStrategies.random;

import creators.ObjectCreator;
import customClasses.Barrel;


import java.util.Random;

public class RandomBarrelGenerator implements ObjectCreator<Barrel> {
    private final Random random = new Random();
    private String[] storedMaterialArray = {"Water", "Wine", "Oil", "Honey", "Beer", "Pickles", "Grain", "Salt", "Fish", "Apples", "Whiskey"};

    @Override
    public Barrel createObject() {
        double volume = getRandomVolume();
        String storedMaterial = getRandomStoredMaterial();
        Barrel.BarrelMaterial barrelMaterial = getRandomBarrelMaterial();

        Barrel generatedBarrel = new Barrel.Builder()
                .setVolume(volume)
                .setStoredMaterial(storedMaterial)
                .setBarrelMaterial(barrelMaterial)
                .build();

        return generatedBarrel;
    }

    private double getRandomVolume() {
        final double minVolume = 0.1;
        final double maxVolume = 1000.0;
        double randomVolume = random.nextDouble(minVolume, maxVolume);
        randomVolume = Math.round(randomVolume * 10) / 10.0;
        return randomVolume;
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
