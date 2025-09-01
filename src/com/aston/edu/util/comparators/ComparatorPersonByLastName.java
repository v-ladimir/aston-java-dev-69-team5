package com.aston.edu.util.comparators;

import com.aston.edu.model.Person;

import java.util.Comparator;

public class ComparatorPersonByLastName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
