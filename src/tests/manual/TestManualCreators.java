package tests.manual;

import fillingStrategies.manual.ManualAnimalCreator;
import fillingStrategies.manual.ManualBarrelCreator;
import fillingStrategies.manual.ManualPersonCreator;

public class TestManualCreators {
    public static void main(String[] args) {
        ManualAnimalCreator animalCreator = new ManualAnimalCreator();
        ManualBarrelCreator barrelCreator = new ManualBarrelCreator();
        ManualPersonCreator personCreator = new ManualPersonCreator();

        System.out.println(animalCreator.createObject());
        System.out.println(barrelCreator.createObject());
        System.out.println(personCreator.createObject());
    }
}
