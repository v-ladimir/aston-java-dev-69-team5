package com.aston.edu.factory.manual;

import com.aston.edu.factory.ObjectCreator;
import com.aston.edu.model.Barrel;
import com.aston.edu.util.ConsoleUtil;

public class ManualBarrelCreator implements ObjectCreator<Barrel> {

    @Override
    public Barrel createObject() {
        double volume = inputVolume();
        String storedMaterial = inputStoredMaterial();
        Barrel.BarrelMaterial barrelMaterial = inputBarrelMaterial();

        Barrel createdBarrel = new Barrel.Builder()
                .setVolume(volume)
                .setStoredMaterial(storedMaterial)
                .setBarrelMaterial(barrelMaterial)
                .build();
        return createdBarrel;
    }

    private double inputVolume() {
        ConsoleUtil.print("Input volume:\n");
        double inputVolume;
        try {
            inputVolume = Double.parseDouble(ConsoleUtil.userStringInput());
        } catch (NumberFormatException e) {
            throw new RuntimeException("Incorrect input. Double must be input");
        }
        return inputVolume;
    }

    private String inputStoredMaterial() {
        ConsoleUtil.print("Input stored material:\n");
        String inputStoredMaterial = ConsoleUtil.userStringInput();
        return inputStoredMaterial;
    }

    private Barrel.BarrelMaterial inputBarrelMaterial() {
        ConsoleUtil.print("Choose barrel material:\n");
        int pointsNumber = Barrel.BarrelMaterial.values().length;
        for (int i = 0; i < pointsNumber; i++) {
            ConsoleUtil.print("%d. %s\n".formatted(i + 1, Barrel.BarrelMaterial.values()[i]));
        }
        ConsoleUtil.print("User input:\n");
        int userInput = ConsoleUtil.userIntInput(1, pointsNumber);
        Barrel.BarrelMaterial chosenMaterial = Barrel.BarrelMaterial.values()[userInput - 1];
        return chosenMaterial;
    }
}
