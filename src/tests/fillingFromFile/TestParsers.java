package tests.fillingFromFile;

import customClasses.Animal;
import customClasses.Barrel;
import customClasses.Person;
import fillingStrategies.file.parsers.AnimalParser;
import fillingStrategies.file.parsers.BarrelParser;
import fillingStrategies.file.parsers.PersonParser;

public class TestParsers {
    public static void main(String[] args) {
        AnimalParser animalParser = new AnimalParser();
        Animal animal = animalParser.getObjectFromString(
                "Вид животного - Кот, цвет глаз - Зелёный, наличие шерсти - Да");
        System.out.println(animal);

        BarrelParser barrelParser = new BarrelParser();
        Barrel barrel = barrelParser.getObjectFromString(
                "Объем бочки - 84.1, тип содержимого - Мед, материал бочки - Сталь");
        System.out.println(barrel);

        PersonParser personParser = new PersonParser();
        Person person = personParser.getObjectFromString(
                "Фамилия - Иванов, возраст - 15, пол - Мужской");
        System.out.println(person);
    }
}
