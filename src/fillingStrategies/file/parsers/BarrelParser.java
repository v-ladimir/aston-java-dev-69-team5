package fillingStrategies.file.parsers;

import customClasses.Barrel;

public class BarrelParser implements Parser<Barrel> {
    @Override
    public Barrel getObjectFromString(String string) {
        String[] dataArray = string.split(",");
        double volume = Double.parseDouble(dataArray[0].split("-")[1].trim());
        String storedMaterial = dataArray[1].split("-")[1].trim();
        Barrel.BarrelMaterial barrelMaterial = Barrel.BarrelMaterial.fromDisplayName(dataArray[2].split("-")[1].trim());
        return new Barrel.Builder()
                .setVolume(volume)
                .setStoredMaterial(storedMaterial)
                .setBarrelMaterial(barrelMaterial)
                .build();
    }
}
