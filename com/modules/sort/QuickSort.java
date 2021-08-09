package sort;

import utils.ArrayUtils;

/*
Worst case and Average Time complexity : O(nlogn)
Space Complexity: O(1)

*/

public class QuickSort {
    public static void main(String args[]) {
        int[] arr = new int[] { 1, 2, 9, -1, 7, 8, 4 };

        QuickSort sort = new QuickSort();
        sort.quickSort(arr, 0, arr.length - 1);
        ArrayUtils.printArray(arr);
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int tempHigh = high - 1;

        while (low <= tempHigh) {
            if (arr[low] < pivot) {
                low++;
            } else if (arr[tempHigh] > pivot) {
                tempHigh--;
            } else {
                ArrayUtils.swap(arr, low, tempHigh);
                low++;
                tempHigh--;
            }
        }
        ArrayUtils.swap(arr, low, high);
        return low;
    }
}
