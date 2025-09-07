package tests.customClasses;

import customClasses.Person;

public class TestPerson {
    public static void main(String[] args) {
        Person person1 = new Person.Builder()
                .setGender(Person.Gender.MALE)
                .setAge(1)
                .setLastName("Иванов")
                .build();
        System.out.println(person1);

        Person person2 = new Person.Builder()
                .setAge(-1)
                .setLastName("")
                .build();
        System.out.println(person2);
    }
}
