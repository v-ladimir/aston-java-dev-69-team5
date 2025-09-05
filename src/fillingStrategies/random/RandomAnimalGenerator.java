package fillingStrategies.random;

import creators.ObjectCreator;
import customClasses.Animal;
import java.util.Random;

public class RandomAnimalGenerator implements ObjectCreator<Animal> {
    private final Random random = new Random();
    private String[] speciesArray = {"Кошка", "Собака", "Лев", "Тигр", "Слон", "Обезьяна",
            "Жираф", "Зебра", "Медведь", "Волк", "Лиса", "Олень", "Кролик", "Лошадь", "Кенгуру"};
    private String[] eyeColorArray = {"Голубой", "Коричневый", "Зеленый", "Серый", "Янтарный", "Красный", "Черный"};

    @Override
    public Animal createObject() {
        String species = getRandomSpecies();
        String eyeColor = getRandomEyeColor();
        boolean hasFur = getRandomHasFur();

        return new Animal.Builder()
                .setSpecies(species)
                .setEyeColor(eyeColor)
                .setHasFur(hasFur)
                .build();
    }

    private String getRandomSpecies() {
        int indexRandomSpecies = random.nextInt(speciesArray.length);
        return speciesArray[indexRandomSpecies];
    }

    private String getRandomEyeColor() {
        int indexRandomEyeColor = random.nextInt(eyeColorArray.length);
        return eyeColorArray[indexRandomEyeColor];
    }

    private boolean getRandomHasFur() {
        return random.nextBoolean();
    }
}
