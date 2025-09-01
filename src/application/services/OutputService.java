package application.services;

// Сервис для вывода содержимого коллекции
public class OutputService {
    private final CollectionService collectionService;

    public OutputService(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    public void showCollection() {
        if (collectionService.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }

        System.out.println("\n=== КОЛЛЕКЦИЯ (" + collectionService.getCollectionType() + ") ===");
        for (int i = 0; i < collectionService.getSize(); i++) {
            System.out.println((i + 1) + ". " + collectionService.getCollection().get(i));
        }
        System.out.println("Всего элементов: " + collectionService.getSize());
    }
}
