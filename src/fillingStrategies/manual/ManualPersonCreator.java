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
        ConsoleUtil.print("Choose gender:\n");
        ConsoleUtil.print("1. Male\n");
        ConsoleUtil.print("2. Female\n");
        ConsoleUtil.print("User input:\n");
        int numGender = ConsoleUtil.userIntInput(1, 2);
        return numGender == 1 ? Person.Gender.MALE : Person.Gender.FEMALE;
    }

    private int inputAge() {
        ConsoleUtil.print("Input age:\n");
        return ConsoleUtil.userIntInput(0, 100);
    }

    private String inputLastName() {
        ConsoleUtil.print("Input last name:\n");
        return ConsoleUtil.userStringInput();
    }
}
