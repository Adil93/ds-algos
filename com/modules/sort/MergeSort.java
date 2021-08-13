/*

In both average and worst case:

    Time Complexity : O(nlogn)
    Space Complexity: O(n)

Suitable for linked list sorting

 */
package sort;

import utils.ArrayUtils;

public class MergeSort {
    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        int[] arr = new int[] { 1, 2, 9, -1, 7, 8, 4 };
        sort.mergeSort(arr, 0, arr.length - 1);
        ArrayUtils.printArray(arr);
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int k = 0, i = left, j = mid + 1;
        int[] temp = new int[(right - left) + 1];

        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int p = left, q = 0; p <= right; q++, p++) {
            arr[p] = temp[q];
        }
    }
}