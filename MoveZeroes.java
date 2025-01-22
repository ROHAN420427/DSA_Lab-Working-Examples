public class MoveZeroes {
    public static void main(String[] args) {
        int[] numbers = {0, 1, 0, 3, 12}; 
        moveZeroes(numbers);
        System.out.print("Array after moving zeroes: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
    public static void moveZeroes(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }
        int lastNonZeroIndex = 0; 
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[lastNonZeroIndex] = array[i];
                lastNonZeroIndex++; 
            }
        }
        for (int i = lastNonZeroIndex; i < array.length; i++) {
            array[i] = 0; 
        }
    }
}