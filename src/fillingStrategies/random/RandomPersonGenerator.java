package fillingStrategies.random;

import creators.ObjectCreator;
import customClasses.Person;

import java.util.Random;

public class RandomPersonGenerator implements ObjectCreator<Person> {
    private final Random random = new Random();
    private String[][] lastNameArray = {
            {"Ivanov", "Ivanova"},
            {"Petrov", "Petrova"},
            {"Sidorov", "Sidorova"},
            {"Onopko", "Onopko"},
            {"Grusha", "Grusha"},
            {"Golub", "Golub"},
            {"Markov", "Markova"},
            {"Nalegach", "Nalegach"},
            {"Ostapov", "Ostapova"},
            {"Saddulaev", "Saddulaeva"},
            {"Gribov", "Gribova"}
    };

    @Override
    public Person createObject() {
        int age = getRandomAge();
        Person.Gender gender = getRandomGender();
        String lastName = getRandomLastName(gender);

        return new Person.Builder()
                .setAge(age)
                .setGender(gender)
                .setLastName(lastName)
                .build();
    }

    private int getRandomAge() {
        int maxGeneratedAge = 100;
        return random.nextInt(maxGeneratedAge);
    }

    private Person.Gender getRandomGender() {
        return random.nextBoolean() ? Person.Gender.MALE : Person.Gender.FEMALE;
    }

    private String getRandomLastName(Person.Gender gender) {
        int indexLastName = random.nextInt(lastNameArray.length);
        return (gender == Person.Gender.MALE) ? lastNameArray[indexLastName][0] : lastNameArray[indexLastName][1];
    }
}
