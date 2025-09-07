package application.services;

import fillingStrategies.ListConstructor;
import fillingStrategies.ObjectCreatorProvider;
import fillingStrategies.ObjectCreator;
import fillingStrategies.manual.ConsoleUtil;

import java.util.List;
import java.util.Scanner;

// Сервис для работы с вводом данных
public class InputService {
    private final CollectionService collectionService;
    private final Scanner scanner;
    private ObjectCreator objectCreator;
    private String fillingType = "Не выбран";

    public InputService(CollectionService collectionService, Scanner scanner) {
        this.collectionService = collectionService;
        this.scanner = scanner;
    }

    public String getFillingType() {
        return fillingType;
    }

    public void setFillingType(String fillingType) {
        this.fillingType = fillingType;
    }

    private void setObjectCreator() {
        String keyMapForChoiceCreator = collectionService.getCollectionType() + "+" + fillingType;
        ObjectCreatorProvider creatorProvider = new ObjectCreatorProvider();
        objectCreator = creatorProvider.getCreator(keyMapForChoiceCreator);
    }

    public void initCollection() {
        setObjectCreator();
        if (objectCreator == null) {
            throw new IllegalStateException("Не удалось инициализировать объект для создания экземпляров коллекции");
        }

        collectionService.clearCollection();

        System.out.print("Введите количество элементов для создания коллекции: ");
        int count = ConsoleUtil.userIntInput(1, 1000);
        List<?> list;

        if (fillingType.equals("Random") && count > 100) {
            list = new ListConstructor<>(objectCreator).getListMultyThread(count);
        } else {
            list = new ListConstructor<>(objectCreator).getListSingleThread(count);
        }

        collectionService.setCollection(list);
        System.out.println("Коллекция заполнена: " + collectionService.getSize() + " элементов");
    }
}
