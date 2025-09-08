package fillingStrategies.manual;

import fillingStrategies.ObjectCreator;
import customClasses.Person;

import java.util.Scanner;

public class ManualPersonCreator implements ObjectCreator<Person> {

    @Override
    public Person createObject() {
        Person.Gender gender = inputGender();
        int age = inputAge();
        String lastName = inputLastName();

        return new Person.Builder()
                .setGender(gender)
                .setAge(age)
                .setLastName(lastName)
                .build();
    }

    private Person.Gender inputGender() {
        System.out.println("Выберите пол:");
        System.out.println("1. Мужской");
        System.out.println("2. Женский");
        System.out.print("Выбор пользователя:");
        int numGender = ConsoleUtil.userIntInput(1, 2);
        return numGender == 1 ? Person.Gender.MALE : Person.Gender.FEMALE;
    }

    private int inputAge() {
        System.out.print("Введите возраст: ");
        return ConsoleUtil.userIntInput(0, 100);
    }

    private String inputLastName() {
        System.out.print("Введите фамилию: ");
        String input;
        while(true) {
            input = new Scanner(System.in).nextLine();
            if (input.isBlank()) {
                System.out.println("Параметр не может быть пустым. Введите корректные данные.");
                continue;
            }
            break;
        }
        return input;
    }
}
