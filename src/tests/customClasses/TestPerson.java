package tests.customClasses;

import customClasses.Person;
import tests.Testing;

public class TestPerson implements Testing {

    public static void main(String[] args) {
        new TestPerson();
    }

    @Override
    public void testFunction() {
        System.out.println("Testing Person");
        System.out.println(new Person.Builder()
                .setGender(Person.Gender.MALE)
                .setAge(1)
                .setLastName("Иванов")
                .build());
        try {
            System.out.println(new Person.Builder()
                    .setGender(Person.Gender.fromDisplayName("трансгендер"))
                    .setAge(1)
                    .setLastName("Иванов")
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(new Person.Builder()
                    .setAge(1)
                    .setLastName("Иванов")
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(new Person.Builder()
                    .setGender(Person.Gender.MALE)
                    .setAge(-1)
                    .setLastName("Иванов")
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(new Person.Builder()
                    .setGender(Person.Gender.MALE)
                    .setAge(1)
                    .setLastName("")
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(new Person.Builder()
                    .setGender(Person.Gender.MALE)
                    .setLastName("Иванов")
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            System.out.println(new Person.Builder()
                    .setGender(Person.Gender.MALE)
                    .setAge(1)
                    .build());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
