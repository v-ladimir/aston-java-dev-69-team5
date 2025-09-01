package application.services;

import sort.TimSortTemp;

public class SortService {
    private final CollectionService collectionService;
    private final OutputService outputService;

    public SortService(CollectionService collectionService, OutputService outputService) {
        this.collectionService = collectionService;
        this.outputService = outputService;
    }

    public void sortCollection() {
        if (collectionService.isEmpty()) {
            System.out.println("Коллекция пуста!");
            return;
        }

        TimSortTemp timSortTemp = new TimSortTemp();
        timSortTemp.sort(collectionService.getCollection());
        System.out.println("Коллекция отсортирована");
        outputService.showCollection();
    }
}
