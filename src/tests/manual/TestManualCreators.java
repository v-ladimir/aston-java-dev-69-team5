package tests.manual;

import fillingStrategies.manual.*;
import tests.Testing;

public class TestManualCreators implements Testing {

    public static void main(String[] args) {
        new TestManualCreators().testFunction();
    }

    @Override
    public void testFunction() {
        System.out.println("Testing ManualCreators");
        ManualAnimalCreator animalCreator = new ManualAnimalCreator();
        ManualBarrelCreator barrelCreator = new ManualBarrelCreator();
        ManualPersonCreator personCreator = new ManualPersonCreator();

        System.out.println(animalCreator.createObject());
        System.out.println(barrelCreator.createObject());
        System.out.println(personCreator.createObject());
    }
}
