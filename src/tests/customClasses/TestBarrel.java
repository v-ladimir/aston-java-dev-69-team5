package tests.customClasses;

import customClasses.Barrel;

public class TestBarrel {
    public static void main(String[] args) {
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
