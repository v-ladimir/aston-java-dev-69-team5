package tests.random;

import fillingStrategies.random.*;
import tests.Testing;

public class TestRandomGenerators implements Testing {

    public static void main(String[] args) {
        new TestRandomGenerators().testFunction();
    }

    @Override
    public void testFunction() {
        System.out.println("Testing RandomGenerators");
        RandomAnimalGenerator genAnimal = new RandomAnimalGenerator();
        RandomBarrelGenerator genBarrel = new RandomBarrelGenerator();
        RandomPersonGenerator genPerson = new RandomPersonGenerator();

        for (int i = 0; i < 10; i++) {
            System.out.println(genAnimal.createObject());
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println(genBarrel.createObject());
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.println(genPerson.createObject());
        }
    }
}
