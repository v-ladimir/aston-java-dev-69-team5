package fillingStrategies.manual;

import creators.ObjectCreator;
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
        return ConsoleUtil.userStringInput();
    }

    private Barrel.BarrelMaterial inputBarrelMaterial() {
        ConsoleUtil.print("Choose barrel material:\n");
        int pointsNumber = Barrel.BarrelMaterial.values().length;
        for (int i = 0; i < pointsNumber; i++) {
            ConsoleUtil.print("%d. %s\n".formatted(i + 1, Barrel.BarrelMaterial.values()[i]));
        }
        ConsoleUtil.print("User input:\n");
        int userInput = ConsoleUtil.userIntInput(1, pointsNumber);
        return Barrel.BarrelMaterial.values()[userInput - 1];
    }
}
