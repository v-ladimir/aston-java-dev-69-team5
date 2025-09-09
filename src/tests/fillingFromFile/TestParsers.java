package tests.fillingFromFile;

import customClasses.*;
import fillingStrategies.file.parsers.*;
import tests.Testing;

public class TestParsers implements Testing {

    public static void main(String[] args) {
        new TestParsers().testFunction();
    }

    @Override
    public void testFunction() {
        System.out.println("Testing Parsers");
        AnimalParser animalParser = new AnimalParser();
        Animal animal =
                animalParser.getObjectFromString("Вид животного - Кот, цвет глаз - Зелёный, наличие шерсти - Да");
        System.out.println(animal);

        BarrelParser barrelParser = new BarrelParser();
        Barrel barrel =
                barrelParser.getObjectFromString("Объем бочки - 84.1, тип содержимого - Мед, материал бочки - Сталь");
        System.out.println(barrel);

        PersonParser personParser = new PersonParser();
        Person person =
                personParser.getObjectFromString("Фамилия - Иванов, возраст - 15, пол - Мужской");
        System.out.println(person);
    }
}
