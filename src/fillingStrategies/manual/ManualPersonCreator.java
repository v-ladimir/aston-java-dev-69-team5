package fillingStrategies.manual;

import creators.ObjectCreator;
import customClasses.Person;

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
        ConsoleUtil.print("Выберите пол:\n");
        ConsoleUtil.print("1. Мужской\n");
        ConsoleUtil.print("2. Женский\n");
        ConsoleUtil.print("Выбор пользователя:\n");
        int numGender = ConsoleUtil.userIntInput(1, 2);
        return numGender == 1 ? Person.Gender.MALE : Person.Gender.FEMALE;
    }

    private int inputAge() {
        ConsoleUtil.print("Введите возраст:\n");
        return ConsoleUtil.userIntInput(0, 100);
    }

    private String inputLastName() {
        ConsoleUtil.print("Введите фамилию:\n");
        return ConsoleUtil.userStringInput();
    }
}
