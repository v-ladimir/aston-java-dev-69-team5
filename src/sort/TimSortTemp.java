package sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TimSortTemp<T extends Comparable<T>> {

    public List<T> sort(List<T> list) {
        Collections.sort(list);
        return list;
    }

    public List<T> sort(List<T> list, Comparator<T> comparator) {
        Collections.sort(list, comparator);
        return list;
    }
}
