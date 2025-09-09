package tests.sort;

import customClasses.*;
import fillingStrategies.ListConstructor;
import fillingStrategies.random.*;
import tests.Testing;

public class TestListConstructor implements Testing {

    public static void main(String[] args) {
        new TestListConstructor().testFunction();
    }

    @Override
    public void testFunction() {
        System.out.println("Testing ListConstructor");
        ListConstructor<Animal> animalListConstructor = new ListConstructor<>(new RandomAnimalGenerator());
        animalListConstructor.getListSingleThread(10).forEach(System.out::println);
        System.out.println();

        ListConstructor<Barrel> barrelListConstructor = new ListConstructor<>(new RandomBarrelGenerator());
        barrelListConstructor.getListSingleThread(10).forEach(System.out::println);
        System.out.println();

        ListConstructor<Person> personListConstructor = new ListConstructor<>(new RandomPersonGenerator());
        personListConstructor.getListSingleThread(10).forEach(System.out::println);
    }
}
