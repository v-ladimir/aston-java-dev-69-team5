package sort;

import java.util.Comparator;
import java.util.List;

public class TimSortTemp<T extends Comparable<T>> {
    public List<T> sort(List<T> list, Comparator<T> comparator) {
        list.sort(comparator);
        return list;
    }
}
