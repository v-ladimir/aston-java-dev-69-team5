package customClasses;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Animal implements Comparable<Animal>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Comparator<Animal> comparator = Comparator
            .comparing(Animal::getSpecies)
            .thenComparing(Animal::getEyeColor)
            .thenComparing(Animal::hasFur);

    private final String species;
    private final String eyeColor;
    private final boolean hasFur;

    private Animal(Builder builder) {
        this.species = builder.species;
        this.eyeColor = builder.eyeColor;
        this.hasFur = builder.hasFur;
    }

    public static class Builder {
        private String species;
        private String eyeColor;
        private boolean hasFur;
        private boolean isHasFurSet;

        public Builder setSpecies(String species) {
            if (species == null || species.isBlank()) {
                throw new IllegalArgumentException("Species cannot be null or empty");
            }
            this.species = species;
            return this;
        }

        public Builder setEyeColor(String eyeColor) {
            if (eyeColor == null || eyeColor.isBlank()) {
                throw new IllegalArgumentException("Eye color cannot be null or empty");
            }
            this.eyeColor = eyeColor;
            return this;
        }

        public Builder setHasFur(boolean hasFur) {
            this.hasFur = hasFur;
            this.isHasFurSet = true;
            return this;
        }

        private void validate() {
            if (this.species == null) {
                throw new IllegalStateException("Species not set");
            }
            if (this.eyeColor == null) {
                throw new IllegalStateException("Eye color not set");
            }
            if (!this.isHasFurSet) {
                throw new IllegalStateException("Presence of fur not set");
            }
        }

        private void setDefaultState() {
            species = null;
            eyeColor = null;
            isHasFurSet = false;
        }

        public Animal build() {
            validate();
            Animal generatedAnimal = new Animal(this);
            setDefaultState();
            return generatedAnimal;
        }
    }

    public String getSpecies() {
        return species;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public boolean hasFur() {
        return hasFur;
    }

    public static Comparator<Animal> getComparator() {
        return comparator;
    }

    @Override
    public int compareTo(Animal o) {
        int compareResult = this.species.compareTo(o.species);
        if (compareResult != 0) {
            return compareResult;
        }
        compareResult = this.eyeColor.compareTo(o.eyeColor);
        if (compareResult != 0) {
            return compareResult;
        }
        compareResult = Boolean.compare(this.hasFur, o.hasFur);
        return compareResult;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Animal animal = (Animal) o;
        return hasFur == animal.hasFur
                && Objects.equals(species, animal.species) && Objects.equals(eyeColor, animal.eyeColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, eyeColor, hasFur);
    }

    @Override
    public String toString() {
        return "species - " + this.species + ", eye color - " + this.eyeColor + ", has fur - " + this.hasFur;
    }
}
