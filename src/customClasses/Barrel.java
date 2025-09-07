package customClasses;

import java.util.Comparator;
import java.util.Objects;

public class Barrel implements Comparable<Barrel> {
    private static final Comparator<Barrel> comparator = Comparator
            .comparing(Barrel::getVolume)
            .thenComparing(Barrel::getStoredMaterial)
            .thenComparing(Barrel::getBarrelMaterial);

    private final double volume;
    private final String storedMaterial;
    private final BarrelMaterial barrelMaterial;

    public enum BarrelMaterial {
        WOOD("Дерево"),
        STEEL("Сталь"),
        PLASTIC("Пластик");

        private final String displayName;

        BarrelMaterial(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }

        public static BarrelMaterial fromDisplayName(String displayName) {
            for (BarrelMaterial material : BarrelMaterial.values()) {
                if (material.displayName.equalsIgnoreCase(displayName)) {
                    return material;
                }
            }
            throw new IllegalArgumentException("Unknown barrel material");
        }
    }

    private Barrel(Builder builder) {
        this.volume = builder.volume;
        this.storedMaterial = builder.storedMaterial;
        this.barrelMaterial = builder.barrelMaterial;
    }

    public static class Builder {
        private double volume = -1;
        private String storedMaterial;
        private BarrelMaterial barrelMaterial;

        public Builder setVolume(double volume) {
            final int minVolume = 0;
            final int maxVolume = 1000;
            if (volume <= minVolume || volume > maxVolume) {
                throw new IllegalArgumentException("Volume must be between %d and %d".formatted(minVolume, maxVolume));
            }
            this.volume = volume;
            return this;
        }

        public Builder setStoredMaterial(String storedMaterial) {
            if (storedMaterial == null || storedMaterial.isBlank()) {
                throw new IllegalArgumentException("Stored material cannot be null or empty");
            }
            this.storedMaterial = storedMaterial;
            return this;
        }

        public Builder setBarrelMaterial(BarrelMaterial barrelMaterial) {
            if (barrelMaterial == null) {
                throw new IllegalArgumentException("Barrel material cannot be null");
            }
            this.barrelMaterial = barrelMaterial;
            return this;
        }

        private void validate() {
            if (this.volume == -1) {
                throw new IllegalStateException("Volume not set");
            }
            if (this.storedMaterial == null) {
                throw new IllegalStateException("Stored material not set");
            }
            if (this.barrelMaterial == null) {
                throw new IllegalStateException("Barrel material not set");
            }
        }

        private void setDefaultState() {
            volume = -1;
            storedMaterial = null;
            barrelMaterial = null;
        }

        public Barrel build() {
            validate();
            Barrel generatedBarrel = new Barrel(this);
            setDefaultState();
            return generatedBarrel;
        }
    }

    public double getVolume() {
        return volume;
    }

    public String getStoredMaterial() {
        return storedMaterial;
    }

    public BarrelMaterial getBarrelMaterial() {
        return barrelMaterial;
    }

    public static Comparator<Barrel> getComparator() {
        return comparator;
    }

    @Override
    public int compareTo(Barrel o) {
        if (o == null) {
            return 1;
        }
        int compareResult = Double.compare(this.volume, o.volume);
        if (compareResult != 0) {
            return compareResult;
        }
        compareResult = this.storedMaterial.compareTo(o.storedMaterial);
        if (compareResult != 0) {
            return compareResult;
        }
        compareResult = this.barrelMaterial.compareTo(o.barrelMaterial);
        return compareResult;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Barrel barrel = (Barrel) o;
        return Double.compare(volume, barrel.volume) == 0
                && Objects.equals(storedMaterial, barrel.storedMaterial) && barrelMaterial == barrel.barrelMaterial;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, storedMaterial, barrelMaterial);
    }

    @Override
    public String toString() {
        return "Объем бочки - " + volume + ", тип содержимого - " + storedMaterial + ", материал бочки - " + barrelMaterial.displayName;
    }
}