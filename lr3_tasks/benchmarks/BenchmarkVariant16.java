package benchmarks;

import java.util.*;

public class BenchmarkVariant16 {

    private static final int VARIANT = 16;
    private static final int ELEMENTS = VARIANT * 1_000_000;
    private static final long LOOKUP_OPERATIONS = VARIANT * 1_000_000L;

    private static volatile int blackHoleInt;
    private static volatile Integer blackHoleInteger;

    public static void main(String[] args) {
        System.out.println("Вариант: " + VARIANT);
        System.out.println("Количество элементов в коллекции: " + ELEMENTS);
        System.out.println("Количество операций поиска элемента: " + LOOKUP_OPERATIONS);
        System.out.println();

        System.out.println("=== Добавление в начало ===");
        System.out.println("ArrayList: " + measureAddBeginArrayList() + " мс");
        System.out.println("LinkedHashMap: " + measureAddBeginLinkedHashMap() + " мс");
        System.out.println("SortedSet: " + measureAddBeginSortedSet() + " мс");
        System.out.println();

        System.out.println("=== Добавление в середину ===");
        System.out.println("ArrayList: " + measureAddMiddleArrayList() + " мс");
        System.out.println("LinkedHashMap: " + measureAddMiddleLinkedHashMap() + " мс");
        System.out.println("SortedSet: " + measureAddMiddleSortedSet() + " мс");
        System.out.println();

        System.out.println("=== Добавление в конец ===");
        System.out.println("ArrayList: " + measureAddEndArrayList() + " мс");
        System.out.println("LinkedHashMap: " + measureAddEndLinkedHashMap() + " мс");
        System.out.println("SortedSet: " + measureAddEndSortedSet() + " мс");
        System.out.println();

        System.out.println("=== Удаление в начале ===");
        System.out.println("ArrayList: " + measureRemoveBeginArrayList() + " мс");
        System.out.println("LinkedHashMap: " + measureRemoveBeginLinkedHashMap() + " мс");
        System.out.println("SortedSet: " + measureRemoveBeginSortedSet() + " мс");
        System.out.println();

        System.out.println("=== Удаление в середине ===");
        System.out.println("ArrayList: " + measureRemoveMiddleArrayList() + " мс");
        System.out.println("LinkedHashMap: " + measureRemoveMiddleLinkedHashMap() + " мс");
        System.out.println("SortedSet: " + measureRemoveMiddleSortedSet() + " мс");
        System.out.println();

        System.out.println("=== Удаление в конце ===");
        System.out.println("ArrayList: " + measureRemoveEndArrayList() + " мс");
        System.out.println("LinkedHashMap: " + measureRemoveEndLinkedHashMap() + " мс");
        System.out.println("SortedSet: " + measureRemoveEndSortedSet() + " мс");
        System.out.println();

        System.out.println("=== Поиск элемента (нативные операции) ===");
        System.out.println("ArrayList (get(index)): " + measureGetByIndexArrayList() + " мс");
        System.out.println("LinkedHashMap (get(key)): " + measureGetByKeyLinkedHashMap() + " мс");
        System.out.println("SortedSet (contains(value)): " + measureContainsSortedSet() + " мс");
    }

    private static double measureAddBeginArrayList() {
        ArrayList<Integer> list = createArrayList(ELEMENTS);
        long start = System.nanoTime();
        list.add(0, -1);
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureAddBeginLinkedHashMap() {
        LinkedHashMap<Integer, Integer> map = createLinkedHashMap(ELEMENTS);
        long start = System.nanoTime();
        LinkedHashMap<Integer, Integer> result = new LinkedHashMap<>(map.size() + 1);
        result.put(-1, -1);
        result.putAll(map);
        blackHoleInt = result.size();
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureAddBeginSortedSet() {
        SortedSet<Integer> set = createSortedSet(ELEMENTS);
        long start = System.nanoTime();
        set.add(-1);
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureAddMiddleArrayList() {
        ArrayList<Integer> list = createArrayList(ELEMENTS);
        int middleIndex = list.size() / 2;
        long start = System.nanoTime();
        list.add(middleIndex, -2);
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureAddMiddleLinkedHashMap() {
        LinkedHashMap<Integer, Integer> map = createLinkedHashMap(ELEMENTS);
        int middle = map.size() / 2;
        long start = System.nanoTime();
        LinkedHashMap<Integer, Integer> middleMap = new LinkedHashMap<>(map.size() + 1);
        int i = 0;
        for (Integer key : map.keySet()) {
            if (i == middle) {
                middleMap.put(-2, -2);
            }
            middleMap.put(key, map.get(key));
            i++;
        }
        blackHoleInt = middleMap.size();
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureAddMiddleSortedSet() {
        SortedSet<Integer> set = createSortedSet(ELEMENTS);
        Integer middleValue = getSetValueByIndex(set, set.size() / 2);
        if (middleValue != null) {
            set.remove(middleValue);
        }
        long start = System.nanoTime();
        if (middleValue != null) {
            set.add(middleValue);
        }
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureAddEndArrayList() {
        ArrayList<Integer> list = createArrayList(ELEMENTS);
        long start = System.nanoTime();
        list.add(-3);
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureAddEndLinkedHashMap() {
        LinkedHashMap<Integer, Integer> map = createLinkedHashMap(ELEMENTS);
        long start = System.nanoTime();
        map.put(ELEMENTS + 1, -3);
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureAddEndSortedSet() {
        SortedSet<Integer> set = createSortedSet(ELEMENTS);
        long start = System.nanoTime();
        set.add(ELEMENTS + 1);
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureRemoveBeginArrayList() {
        ArrayList<Integer> list = createArrayList(ELEMENTS);
        long start = System.nanoTime();
        blackHoleInt = list.remove(0);
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureRemoveBeginLinkedHashMap() {
        LinkedHashMap<Integer, Integer> map = createLinkedHashMap(ELEMENTS);
        long start = System.nanoTime();
        Integer firstKey = map.keySet().iterator().next();
        blackHoleInteger = map.remove(firstKey);
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureRemoveBeginSortedSet() {
        SortedSet<Integer> set = createSortedSet(ELEMENTS);
        long start = System.nanoTime();
        blackHoleInt = set.remove(set.first()) ? 1 : 0;
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureRemoveMiddleArrayList() {
        ArrayList<Integer> list = createArrayList(ELEMENTS);
        int middleIndex = list.size() / 2;
        long start = System.nanoTime();
        blackHoleInt = list.remove(middleIndex);
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureRemoveMiddleLinkedHashMap() {
        LinkedHashMap<Integer, Integer> map = createLinkedHashMap(ELEMENTS);
        long start = System.nanoTime();
        Integer middleKey = getMiddleMapKey(map);
        if (middleKey != null) {
            blackHoleInteger = map.remove(middleKey);
        }
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureRemoveMiddleSortedSet() {
        SortedSet<Integer> set = createSortedSet(ELEMENTS);
        Integer middleValue = getSetValueByIndex(set, set.size() / 2);
        long start = System.nanoTime();
        if (middleValue != null) {
            blackHoleInt = set.remove(middleValue) ? 1 : 0;
        }
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureRemoveEndArrayList() {
        ArrayList<Integer> list = createArrayList(ELEMENTS);
        long start = System.nanoTime();
        blackHoleInt = list.remove(list.size() - 1);
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureRemoveEndLinkedHashMap() {
        LinkedHashMap<Integer, Integer> map = createLinkedHashMap(ELEMENTS);
        long start = System.nanoTime();
        Integer lastKey = getLastMapKey(map);
        if (lastKey != null) {
            blackHoleInteger = map.remove(lastKey);
        }
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureRemoveEndSortedSet() {
        SortedSet<Integer> set = createSortedSet(ELEMENTS);
        long start = System.nanoTime();
        blackHoleInt = set.remove(set.last()) ? 1 : 0;
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureGetByIndexArrayList() {
        ArrayList<Integer> list = createArrayList(ELEMENTS);
        int index = list.size() / 2;
        long start = System.nanoTime();
        for (long i = 0; i < LOOKUP_OPERATIONS; i++) {
            blackHoleInt = list.get(index);
        }
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureGetByKeyLinkedHashMap() {
        LinkedHashMap<Integer, Integer> map = createLinkedHashMap(ELEMENTS);
        int key = map.size() / 2;
        long start = System.nanoTime();
        for (long op = 0; op < LOOKUP_OPERATIONS; op++) {
            Integer value = map.get(key);
            if (value != null) {
                blackHoleInt = value;
            }
        }
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static double measureContainsSortedSet() {
        SortedSet<Integer> set = createSortedSet(ELEMENTS);
        int value = set.size() / 2;
        long start = System.nanoTime();
        for (long op = 0; op < LOOKUP_OPERATIONS; op++) {
            blackHoleInt = set.contains(value) ? 1 : 0;
        }
        long end = System.nanoTime();
        return nanosToMillis(end - start);
    }

    private static ArrayList<Integer> createArrayList(int size) {
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    private static LinkedHashMap<Integer, Integer> createLinkedHashMap(int size) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(size);
        for (int i = 0; i < size; i++) {
            map.put(i, i);
        }
        return map;
    }

    private static SortedSet<Integer> createSortedSet(int size) {
        SortedSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < size; i++) {
            set.add(i);
        }
        return set;
    }

    private static Integer getMiddleMapKey(LinkedHashMap<Integer, Integer> map) {
        int middle = map.size() / 2;
        int i = 0;
        for (Integer key : map.keySet()) {
            if (i == middle) {
                return key;
            }
            i++;
        }
        return null;
    }

    private static Integer getLastMapKey(LinkedHashMap<Integer, Integer> map) {
        Integer last = null;
        for (Integer key : map.keySet()) {
            last = key;
        }
        return last;
    }

    private static Integer getSetValueByIndex(SortedSet<Integer> set, int index) {
        int i = 0;
        for (Integer value : set) {
            if (i == index) {
                return value;
            }
            i++;
        }
        return null;
    }

    private static double nanosToMillis(long nanos) {
        return nanos / 1_000_000.0;
    }
}
