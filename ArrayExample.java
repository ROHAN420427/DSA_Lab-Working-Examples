public class ArrayExample {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        //adding
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;
        //editing
        numbers[2] = 35;
        //deleting 
        numbers[1] = 0;
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}