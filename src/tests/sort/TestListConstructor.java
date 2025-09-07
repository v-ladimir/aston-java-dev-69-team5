package tests.sort;

import customClasses.Animal;
import customClasses.Barrel;
import customClasses.Person;
import fillingStrategies.ListConstructor;
import fillingStrategies.random.RandomAnimalGenerator;
import fillingStrategies.random.RandomBarrelGenerator;
import fillingStrategies.random.RandomPersonGenerator;

public class TestListConstructor {
    public static void main(String[] args) {
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
