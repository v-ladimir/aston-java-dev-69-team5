package com.aston.edu.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Comparable<Person>, Serializable {
    private static final long serialVersionUID = 1L;

    private final Gender gender;
    private final int age;
    private final String lastName;

    public enum Gender {
        MALE, FEMALE;
    }

    private Person(Builder builder) {
        this.gender = builder.gender;
        this.age = builder.age;
        this.lastName = builder.lastName;
    }

    public static class Builder {
        private Gender gender;
        private int age = -1;
        private String lastName;

        public Builder setGender(Gender gender) {
            if (gender == null) {
                throw new IllegalArgumentException("Gender cannot be null");
            }
            this.gender = gender;
            return this;
        }

        public Builder setAge(int age) {
            int maxAge = 130;
            if (age < 0 || age > maxAge) {
                throw new IllegalArgumentException("Age must be between 0 and " + maxAge);
            }
            this.age = age;
            return this;
        }

        public Builder setLastName(String lastName) {
            if (lastName == null || lastName.isBlank()) {
                throw new IllegalArgumentException("Last name cannot be null or empty");
            }
            this.lastName = lastName;
            return this;
        }

        private void validate() {
            if (this.gender == null) {
                throw new IllegalStateException("Gender not set");
            }
            if (this.age == -1) {
                throw new IllegalStateException("Age not set");
            }
            if (this.lastName == null) {
                throw new IllegalStateException("Last name not set");
            }
        }

        private void setDefaultState() {
            gender = null;
            age = -1;
            lastName = null;
        }

        public Person build() {
            validate();
            Person generatedPerson = new Person(this);
            setDefaultState();
            return generatedPerson;
        }
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public int compareTo(Person o) {
        if (o == null) {
            return 1;
        }
        int compareResult = this.lastName.compareTo(o.lastName);
        if (compareResult != 0) {
            return compareResult;
        }
        compareResult = Integer.compare(this.age, o.age);
        if (compareResult != 0) {
            return compareResult;
        }
        compareResult = this.gender.compareTo(o.gender);
        return compareResult;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && gender == person.gender && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, age, lastName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender=" + gender +
                ", age=" + age +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}