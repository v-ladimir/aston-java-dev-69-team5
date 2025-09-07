package sort;

import java.util.Comparator;
import java.util.List;

public class TimSort<T extends Comparable<T>> {
    private static final int MIN_MERGE = 64;
    private List<T> list;
    private Comparator<T> comparator;
    private Object[] temp;

    public List<T> sort(List<T> list, Comparator<T> comparator) {
        this.list = list;
        this.comparator = comparator;
        int n = list.size();

        if (n < 2) {
            return list;
        }

        if (n < MIN_MERGE) {
            insertionSort(0, n - 1);
            return list;
        }

        this.temp = new Object[n];
        int minRun = minRunLength(n);

        int start = 0;
        while (start < n) {
            int end = findRun(start);
            int runLength = end - start + 1;

            if (runLength < minRun) {
                int endExtended = Math.min(start + minRun - 1, n - 1);
                insertionSort(start, endExtended);
                runLength = endExtended - start + 1;
            }

            if (start > 0) {
                merge(0, start - 1, start + runLength - 1);
            }

            start += runLength;
        }

        return list;
    }

    private int findRun(int start) {
        int n = list.size();
        if (start == n - 1) {
            return start;
        }

        int end = start;
        boolean ascending = comparator.compare(list.get(end), list.get(end + 1)) <= 0;

        if (ascending) {
            while (end < n - 1 && comparator.compare(list.get(end), list.get(end + 1)) <= 0) {
                end++;
            }
        } else {
            while (end < n - 1 && comparator.compare(list.get(end), list.get(end + 1)) > 0) {
                end++;
            }
            reverseRun(start, end);
        }

        return end;
    }

    private void reverseRun(int start, int end) {
        while (start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    private void insertionSort(int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            T key = list.get(i);
            int j = i - 1;

            while (j >= left && comparator.compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    private void merge(int left, int mid, int right) {
        int leftLength = mid - left + 1;
        int rightLength = right - mid;

        for (int i = 0; i < leftLength; i++) {
            temp[i] = list.get(left + i);
        }
        for (int i = 0; i < rightLength; i++) {
            temp[leftLength + i] = list.get(mid + 1 + i);
        }

        int i = 0, j = leftLength, k = left;
        while (i < leftLength && j < leftLength + rightLength) {
            T leftItem = (T) temp[i];
            T rightItem = (T) temp[j];

            if (comparator.compare(leftItem, rightItem) <= 0) {
                list.set(k, leftItem);
                i++;
            } else {
                list.set(k, rightItem);
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            list.set(k, (T) temp[i]);
            i++;
            k++;
        }
        while (j < leftLength + rightLength) {
            list.set(k, (T) temp[j]);
            j++;
            k++;
        }
    }

    private int minRunLength(int n) {
        int r = 0;
        while (n >= MIN_MERGE) {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }
}
