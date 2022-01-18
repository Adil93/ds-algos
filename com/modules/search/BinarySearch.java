package search;

public class BinarySearch {
    public static void main(String args[]) {
        int[] arr = new int[] { -1, 1, 2, 4, 7, 8, 9 };

        BinarySearch search = new BinarySearch();
        int elem = 7;
        int searchElemPosition = search.binarySearch(arr, 0, arr.length - 1, elem);
        System.out.println("elem : " + elem + " searchElemPosition :" + searchElemPosition);
    }

    public int binarySearch(int[] arr, int low, int high, int elem) {
        if (low <= high) {
            int mid = low + ((high - low) / 2);
            if (arr[mid] == elem)
                return mid;
            if (arr[mid] > elem)
                return binarySearch(arr, low, mid - 1, elem);
            if (arr[mid] < elem)
                return binarySearch(arr, mid + 1, high, elem);
        }
        return -1;
    }
}
