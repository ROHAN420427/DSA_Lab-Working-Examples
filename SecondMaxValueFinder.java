public class SecondMaxValueFinder {
    public static void main(String[] args) {
        int[] numbers = {5, 3, 8, 1, 4, 8, 2};
        try {
            int secondMaxValue = findSecondMaximum(numbers);
            System.out.println("The second maximum value in the array is: " + secondMaxValue);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public static int findSecondMaximum(int[] array) {
        if (array == null || array.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements");
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int num : array) {
            if (num > max) {
                secondMax = max; 
                max = num; 
            } else if (num > secondMax && num < max) {
                secondMax = num;
            }
        }
        if (secondMax == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("There is no second maximum value in the array");
        }
        return secondMax; 
    }
}