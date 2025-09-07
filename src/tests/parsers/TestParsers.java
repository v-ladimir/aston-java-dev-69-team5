package tests.parsers;

import customClasses.Animal;
import customClasses.Barrel;
import customClasses.Person;
import fillingStrategies.file.parsers.AnimalParser;
import fillingStrategies.file.parsers.BarrelParser;
import fillingStrategies.file.parsers.PersonParser;

public class TestParsers {
    public static void main(String[] args) {
        AnimalParser animalParser = new AnimalParser();
        String string = "Вид животного - Кот, цвет глаз - Зелёный, наличие шерсти - да";
        Animal animal = animalParser.getObjectFromString(string);
        System.out.println(animal);

        BarrelParser barrelParser = new BarrelParser();
        string = "Объем бочки - 84.1, тип содержимого - Мед, материал бочки - Сталь";
        Barrel barrel = barrelParser.getObjectFromString(string);
        System.out.println(barrel);

        PersonParser personParser = new PersonParser();
        string = "Фамилия - Иванов, возраст - 15, пол - Мужской";
        Person person = personParser.getObjectFromString(string);
        System.out.println(person);
    }
}
