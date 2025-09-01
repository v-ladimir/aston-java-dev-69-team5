package application;

import customClasses.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static List<?> collection = new ArrayList<>();
    private static String collectionType = "Не выбрана";
//    private static Random random = new Random();

    public static void main(String[] args) {
        showMainMenu();
    }

    private static void showMainMenu() {
        while (true) {
            System.out.println("\n=== ГЛАВНОЕ МЕНЮ ===");
            System.out.println("Текущий тип коллекции: " + collectionType);
            System.out.println("1. Выбор типа класса");
            System.out.println("2. Ввод/заполнение данных");
            System.out.println("3. Вывод коллекции");
            System.out.println("4. Сортировка");
            System.out.println("5. Поиск");
            System.out.println("6. Выход");
            System.out.print("Выберите пункт: ");

            int choice = readIntInput(1, 6);

            switch (choice) {
                case 1 -> selectCollectionType();
                case 2 -> showInputMenu();
                case 3 -> showCollection();
                case 4 -> showSortMenu();
                case 5 -> showSearchMenu();
                case 6 -> {
                    System.out.println("До свидания!");
                    return;
                }
            }
        }
    }

    // 1. Выбор типа класса (без изменений)
    private static void selectCollectionType() {
        System.out.println("\n=== ВЫБОР ТИПА КОЛЛЕКЦИИ ===");
        System.out.println("1. Животное");
        System.out.println("2. Бочка");
        System.out.println("3. Человек");
        System.out.print("Выберите тип: ");

        int choice = readIntInput(1, 3);

        switch (choice) {
            case 1 -> {
                collection = new ArrayList<Animal>();
                collectionType = "Животное";
            }
            case 2 -> {
                collection = new ArrayList<Barrel>();
                collectionType = "Бочка";
            }
            case 3 -> {
                collection = new ArrayList<Person>();
                collectionType = "Человек";
            }
        }
        System.out.println("Тип коллекции установлен: " + collectionType);
    }

    // 2. Меню ввода данных
    private static void showInputMenu() {
        if (collectionType.equals("Не выбрана")) {
            System.out.println("Сначала выберите тип коллекции!");
            return;
        }

        System.out.println("\n=== ВВОД ДАННЫХ ===");
        System.out.println("1. Вручную");
        System.out.println("2. Из файла");
        System.out.println("3. Случайные значения");
        System.out.print("Выберите способ: ");

        int choice = readIntInput(1, 3);

        switch (choice) {
            case 1 -> System.out.println("Вызов метода ручного наполнения коллекции"); //manualInput();
            case 2 -> System.out.println("Вызов метода наполнения коллекции из файла"); //fileInput();
            case 3 -> System.out.println("Вызов метода наполнения коллекции случайными значениями"); //randomInput();
        }
    }

//    private static void manualInput() {
//        collection.clear();
//        System.out.println("Введите данные (пустая строка для завершения):");
//
//        while (true) {
//            try {
//                switch (collectionType) {
//                    case "Животное" -> {
//                        System.out.print("Вид животного: ");
//                        String species = scanner.nextLine();
//                        if (species.isEmpty()) return;
//
//                        System.out.print("Цвет глаз: ");
//                        String eyeColor = scanner.nextLine();
//
//                        System.out.print("Есть шерсть (да/нет): ");
//                        boolean hasFur = scanner.nextLine().equalsIgnoreCase("да");
//
//                        ((List<Animal>) collection).add(new Animal(species, eyeColor, hasFur));
//                    }
//                    case "Бочка" -> {
//                        System.out.print("Объем бочки: ");
//                        double volume = Double.parseDouble(scanner.nextLine());
//
//                        System.out.print("Хранимый материал: ");
//                        String storedMaterial = scanner.nextLine();
//
//                        System.out.print("Материал бочки: ");
//                        String barrelMaterial = scanner.nextLine();
//
//                        ((List<Barrel>) collection).add(new Barrel(volume, storedMaterial, barrelMaterial));
//                    }
//                    case "Человек" -> {
//                        System.out.print("Пол: ");
//                        String gender = scanner.nextLine();
//                        if (gender.isEmpty()) return;
//
//                        System.out.print("Возраст: ");
//                        int age = Integer.parseInt(scanner.nextLine());
//
//                        System.out.print("Фамилия: ");
//                        String lastName = scanner.nextLine();
//
//                        ((List<Person>) collection).add(new Person(gender, age, lastName));
//                    }
//                }
//                System.out.println("Элемент добавлен. Всего: " + collection.size());
//                System.out.print("Добавить еще? (Enter - да, 'нет' - завершить): ");
//                if (scanner.nextLine().equalsIgnoreCase("нет")) break;
//
//            } catch (Exception e) {
//                System.out.println("Ошибка ввода: " + e.getMessage());
//            }
//        }
//    }

//    private static void fileInput() {
//        System.out.print("Введите имя файла: ");
//        String filename = scanner.nextLine();
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            collection.clear();
//            String line;
//            int lineCount = 0;
//
//            while ((line = reader.readLine()) != null) {
//                lineCount++;
//                line = line.trim();
//                if (!line.isEmpty()) {
//                    try {
//                        String[] parts = line.split(",");
//                        switch (collectionType) {
//                            case "Животное" -> {
//                                if (parts.length == 3) {
//                                    boolean hasFur = parts[2].trim().equalsIgnoreCase("true");
//                                    ((List<Animal>) collection).add(
//                                            new Animal(parts[0].trim(), parts[1].trim(), hasFur)
//                                    );
//                                }
//                            }
//                            case "Бочка" -> {
//                                if (parts.length == 3) {
//                                    double volume = Double.parseDouble(parts[0].trim());
//                                    ((List<Barrel>) collection).add(
//                                            new Barrel(volume, parts[1].trim(), parts[2].trim())
//                                    );
//                                }
//                            }
//                            case "Человек" -> {
//                                if (parts.length == 3) {
//                                    int age = Integer.parseInt(parts[1].trim());
//                                    ((List<Person>) collection).add(
//                                            new Person(parts[0].trim(), age, parts[2].trim())
//                                    );
//                                }
//                            }
//                        }
//                    } catch (Exception e) {
//                        System.out.println("Ошибка в строке " + lineCount + ": " + e.getMessage());
//                    }
//                }
//            }
//            System.out.println("Загружено элементов: " + collection.size());
//        } catch (IOException e) {
//            System.out.println("Ошибка чтения файла: " + e.getMessage());
//        }
//    }

//    private static void randomInput() {
//        System.out.print("Сколько элементов сгенерировать? ");
//        int count = readIntInput(1, 1000);
//
//        collection.clear();
//
//        for (int i = 0; i < count; i++) {
//            switch (collectionType) {
//                case "Животное" -> ((List<Animal>) collection).add(Animal.createRandom());
//                case "Бочка" -> ((List<Barrel>) collection).add(Barrel.createRandom());
//                case "Человек" -> ((List<Person>) collection).add(Person.createRandom());
//            }
//        }
//        System.out.println("Сгенерировано элементов: " + collection.size());
//    }

    // 3. Вывод коллекции
    private static void showCollection() {
//        if (collection.isEmpty()) {
//            System.out.println("Коллекция пуста!");
//            return;
//        }

        System.out.println("\n=== КОЛЛЕКЦИЯ (" + collectionType + ") ===");
        System.out.println("Выводятся элементы коллекции/либо вызывается метод вывода коллекции");
//        for (int i = 0; i < collection.size(); i++) {
//            System.out.println((i + 1) + ". " + collection.get(i));
//        }
//        System.out.println("Всего элементов: " + collection.size());
    }

    // 4. ОТДЕЛЬНОЕ МЕНЮ СОРТИРОВКИ
    private static void showSortMenu() {
//        if (collection.isEmpty()) {
//            System.out.println("Коллекция пуста!");
//            return;
//        }

        System.out.println("\n=== МЕНЮ СОРТИРОВКИ ===");

        switch (collectionType) {
            case "Животное" -> {
                System.out.println("1. По виду (А-Я)");
                System.out.println("2. По виду (Я-А)");
                System.out.println("3. По цвету глаз (А-Я)");
                System.out.println("4. По цвету глаз (Я-А)");
                System.out.print("Выберите критерий сортировки: ");
                int crit = readIntInput(1, 4);

                System.out.println("Вызывается метод сортировки");

//                List<Animal> animalList = (List<Animal>) collection;
//                switch (crit) {
//                    case 1 -> animalList.sort(Comparator.comparing(Animal::getSpecies));
//                    case 2 -> animalList.sort(Comparator.comparing(Animal::getSpecies).reversed());
//                    case 3 -> animalList.sort(Comparator.comparing(Animal::getEyeColor));
//                    case 4 -> animalList.sort(Comparator.comparing(Animal::getEyeColor).reversed());
//                }
            }
            case "Бочка" -> {
                System.out.println("1. По объему (↗)");
                System.out.println("2. По объему (↘)");
                System.out.println("3. По хранимому материалу (А-Я)");
                System.out.println("4. По хранимому материалу (Я-А)");
                System.out.print("Выберите критерий сортировки: ");
                int crit = readIntInput(1, 4);

                System.out.println("Вызывается метод сортировки");

//                List<Barrel> barrelList = (List<Barrel>) collection;
//                switch (crit) {
//                    case 1 -> barrelList.sort(Comparator.comparing(Barrel::getVolume));
//                    case 2 -> barrelList.sort(Comparator.comparing(Barrel::getVolume).reversed());
//                    case 3 -> barrelList.sort(Comparator.comparing(Barrel::getStoredMaterial));
//                    case 4 -> barrelList.sort(Comparator.comparing(Barrel::getStoredMaterial).reversed());
//                }
            }
            case "Человек" -> {
                System.out.println("1. По возрасту (↗)");
                System.out.println("2. По возрасту (↘)");
                System.out.println("3. По фамилии (А-Я)");
                System.out.println("4. По фамилии (Я-А)");
                System.out.print("Выберите критерий сортировки: ");
                int crit = readIntInput(1, 4);

                System.out.println("Вызывается метод сортировки");

//                List<Person> personList = (List<Person>) collection;
//                switch (crit) {
//                    case 1 -> personList.sort(Comparator.comparing(Person::getAge));
//                    case 2 -> personList.sort(Comparator.comparing(Person::getAge).reversed());
//                    case 3 -> personList.sort(Comparator.comparing(Person::getLastName));
//                    case 4 -> personList.sort(Comparator.comparing(Person::getLastName).reversed());
//                }
            }
        }
        System.out.println("Коллекция отсортирована");
        showCollection();
    }

    // 5. ОТДЕЛЬНОЕ МЕНЮ ПОИСКА
    private static void showSearchMenu() {
//        if (collection.isEmpty()) {
//            System.out.println("Коллекция пуста!");
//            return;
//        }

        System.out.println("\n=== МЕНЮ ПОИСКА ===");
        System.out.print("Введите ключ для поиска: ");
        String searchKey = scanner.nextLine().toLowerCase();

        System.out.println("\n=== РЕЗУЛЬТАТЫ ПОИСКА ===");
        System.out.println("Вызывается метод поиска значения");
        boolean found = false;

//        collection.get(BinarySearch.binarySearch(searchKey));

//        switch (collectionType) {
//            case "Животное" -> {
//                Animal animal
//                for (Animal animal : (List<Animal>) collection) {
//                    if (animal.getSpecies().toLowerCase().contains(searchKey) ||
//                            animal.getEyeColor().toLowerCase().contains(searchKey) ||
//                            (animal.hasFur() && "шерсть да".contains(searchKey)) ||
//                            (!animal.hasFur() && "шерсть нет".contains(searchKey))) {
//                        System.out.println("🔍 " + animal);
//                        found = true;
//                    }
//                }
//            }
//            case "Бочка" -> {
//                for (Barrel barrel : (List<Barrel>) collection) {
//                    if (barrel.getStoredMaterial().toLowerCase().contains(searchKey) ||
//                            barrel.getBarrelMaterial().toLowerCase().contains(searchKey) ||
//                            String.valueOf(barrel.getVolume()).contains(searchKey)) {
//                        System.out.println("🔍 " + barrel);
//                        found = true;
//                    }
//                }
//            }
//            case "Человек" -> {
//                for (Person person : (List<Person>) collection) {
//                    if (person.getLastName().toLowerCase().contains(searchKey) ||
//                            person.getGender().toLowerCase().contains(searchKey) ||
//                            String.valueOf(person.getAge()).contains(searchKey)) {
//                        System.out.println("🔍 " + person);
//                        found = true;
//                    }
//                }
//            }
//        }

        if (!found) {
            System.out.println("Ничего не найдено");
        } else {
            System.out.println("Поиск завершен");
        }
    }

    // Вспомогательный методы (ввод пункта меню)
    private static int readIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.print("Введите число от " + min + " до " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Ошибка! Введите целое число: ");
            }
        }
    }
}
