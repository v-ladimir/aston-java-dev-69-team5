package tests.customClasses;

import customClasses.Barrel;
import tests.Testing;

public class TestBarrel implements Testing {

    public static void main(String[] args) {
        new TestBarrel().testFunction();
    }

    @Override
    public void testFunction() {
        System.out.println("Testing Barrel");
        System.out.println(new Barrel.Builder()
                .setVolume(1)
                .setStoredMaterial("вода")
                .setBarrelMaterial(Barrel.BarrelMaterial.WOOD)
                .build());
        try {
            System.out.println(new Barrel.Builder()
                    .setVolume(0)
                    .setStoredMaterial("")
                    .setBarrelMaterial(Barrel.BarrelMaterial.WOOD)
                    .build());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(new Barrel.Builder()
                    .setStoredMaterial("")
                    .setBarrelMaterial(Barrel.BarrelMaterial.WOOD)
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(new Barrel.Builder()
                    .setVolume(1)
                    .setBarrelMaterial(Barrel.BarrelMaterial.WOOD)
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(new Barrel.Builder()
                    .setVolume(1)
                    .setStoredMaterial("вода")
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(new Barrel.Builder()
                    .setVolume(1)
                    .setStoredMaterial("вода")
                    .setBarrelMaterial(Barrel.BarrelMaterial.fromDisplayName("камень"))
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
