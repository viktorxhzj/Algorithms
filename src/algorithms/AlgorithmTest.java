package algorithms;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmTest {

    @org.junit.jupiter.api.Test
    void quickSort() {
        for (int i = 0; i < 100; i++) {
            int[] arr = new int[10];
            for (int j = 0; j < 10; j++) arr[j] = (int) (Math.random() * 10);
            int[] arr2 = Arrays.copyOf(arr, 10);
            Arrays.sort(arr2);
            QuickSort.quickSort(arr, 0, 9);
            for (int j = 0; j < 10; j++) assertEquals(arr[j], arr2[j]);
        }
    }

    @org.junit.jupiter.api.Test
    void kmp() {}

    @org.junit.jupiter.api.Test
    void kruskal() {}

    @org.junit.jupiter.api.Test
    void dijkstra() {}
}