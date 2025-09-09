package fillingStrategies.file.parsers;

import customClasses.Person;

public class PersonParser implements Parser<Person> {
    @Override
    public Person getObjectFromString(String string) {
        String[] dataArray = string.split(",");
        String lastName = dataArray[0].split("-")[1].trim();
        int age = Integer.parseInt(dataArray[1].split("-")[1].trim());
        Person.Gender gender = Person.Gender.fromDisplayName(dataArray[2].split("-")[1].trim());
        return new Person.Builder()
                .setLastName(lastName)
                .setAge(age)
                .setGender(gender)
                .build();
    }
}
