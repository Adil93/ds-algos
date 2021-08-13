package sort;

import utils.ArrayUtils;

public class InsertionSort {
    public static void main(String args[]) {
        InsertionSort sort = new InsertionSort();
        int[] arr = new int[] { 1, 2, 9, -1, 7, 8, 4 };
        sort.insertionSort(arr);
        ArrayUtils.printArray(arr);
    }

    public void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
