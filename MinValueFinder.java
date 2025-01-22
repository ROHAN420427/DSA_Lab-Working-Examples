public class MinValueFinder {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 4, 2}; 
        int minValue = findMinimum(numbers);
        System.out.println("The minimum value in the array is: " + minValue);
    }
    public static int findMinimum(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array must not be empty");
        }
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i]; 
            }
        }
        return min; 
    }
}