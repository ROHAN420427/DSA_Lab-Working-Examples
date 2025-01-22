public class MissingNumberFinder {
    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 3, 5};
        try {
            int missingNumber = findMissingNumber(numbers);
            System.out.println("The missing number is: " + missingNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int findMissingNumber(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }

        int n = array.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : array) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}