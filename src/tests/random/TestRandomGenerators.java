package tests.random;

import fillingStrategies.random.RandomAnimalGenerator;
import fillingStrategies.random.RandomBarrelGenerator;
import fillingStrategies.random.RandomPersonGenerator;

public class TestRandomGenerators {
    public static void main(String[] args) {
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
