public class ReverseArray {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Original Array:");
        printArray(numbers);

        int[] reversedArray = reverseArray(numbers);

        System.out.println("Reversed Array:");
        printArray(reversedArray);
    }
    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        int j = 0;

        for (int i = array.length - 1; i >= 0; i--) {
            reversed[j] = array[i];
            j++;
        }

        return reversed;
    }
    public static void printArray(int[] array) {
        for (int number : array) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}