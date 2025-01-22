import java.util.Arrays;

public class SortedArrayOperations {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9};

        int searchElement = 5;
        int searchResult = binarySearch(sortedArray, searchElement);
        System.out.println("Element " + searchElement + (searchResult != -1 ? " found at index: " + searchResult : " not found."));

        int insertElement = 6;
        sortedArray = insert(sortedArray, insertElement);
        System.out.println("Array after insertion: " + Arrays.toString(sortedArray));

        int deleteElement = 3;
        sortedArray = delete(sortedArray, deleteElement);
        System.out.println("Array after deletion: " + Arrays.toString(sortedArray));
    }

    public static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int[] insert(int[] array, int key) {
        int[] newArray = new int[array.length + 1];
        int i = 0;
        while (i < array.length && array[i] < key) {
            newArray[i] = array[i];
            i++;
        }
        newArray[i] = key;
        while (i < array.length) {
            newArray[i + 1] = array[i];
            i++;
        }
        return newArray;
    }

    public static int[] delete(int[] array, int key) {
        int index = binarySearch(array, key);
        if (index == -1) {
            System.out.println("Element " + key + " not found for deletion.");
            return array;
        }

        int[] newArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }
}