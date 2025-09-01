package fillingStrategies.manual;

import creators.ObjectCreator;
import application.ConsoleUtil;
import customClasses.Person;

public class ManualPersonCreator implements ObjectCreator<Person> {

    @Override
    public Person createObject() {
        Person.Gender gender = inputGender();
        int age = inputAge();
        String lastName = inputLastName();

        Person createdPerson = new Person.Builder()
                .setGender(gender)
                .setAge(age)
                .setLastName(lastName)
                .build();
        return createdPerson;
    }

    private Person.Gender inputGender() {
        ConsoleUtil.print("Choose gender:\n");
        ConsoleUtil.print("1. Male\n");
        ConsoleUtil.print("2. Female\n");
        ConsoleUtil.print("User input:\n");
        int numGender = ConsoleUtil.userIntInput(1, 2);
        Person.Gender chosenGender = numGender == 1 ? Person.Gender.MALE : Person.Gender.FEMALE;
        return chosenGender;
    }

    private int inputAge() {
        ConsoleUtil.print("Input age:\n");
        int inputAge = ConsoleUtil.userIntInput(0, 100);
        return inputAge;
    }

    private String inputLastName() {
        ConsoleUtil.print("Input last name:\n");
        String inputLastName = ConsoleUtil.userStringInput();
        return inputLastName;
    }
}
