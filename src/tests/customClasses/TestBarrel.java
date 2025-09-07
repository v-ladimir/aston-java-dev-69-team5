package tests.customClasses;

import customClasses.Barrel;

public class TestBarrel {
    public static void main(String[] args) {
        Barrel barrel1 = new Barrel.Builder()
                .setVolume(1)
                .setStoredMaterial("вода")
                .setBarrelMaterial(Barrel.BarrelMaterial.WOOD)
                .build();
        System.out.println(barrel1);

        Barrel barrel2 = new Barrel.Builder()
                .setVolume(0)
                .setStoredMaterial("")
                .build();
        System.out.println(barrel2);
    }
}
