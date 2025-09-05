package tests;

import customClasses.Person;

public class TestPersonBuilder implements Testing {
    @Override
    public boolean testFunction() {
        int age = 1;
        Person.Gender gender = Person.Gender.MALE;
        String lastName = "Titov";

        Person testPerson = new Person.Builder()
                .setAge(age)
                .setGender(gender)
                .setLastName(lastName)
                .build();

        boolean testResult = testPerson != null
                && testPerson.getAge() == age
                && testPerson.getGender() == gender
                && testPerson.getLastName().equals(lastName);

        System.out.println(testPerson);
        return testResult;
    }
}
