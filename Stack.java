public class Stack{
    private int arr[];
    private int size;
    private int index = 0;

    public Stack(int size){
        this.size = size;
        arr = new int[size];
    }
    // pushing an element on a stack
    public void push(int element){
        if(isFull())
   {
    System.out.println("Stack is full");
   }
   arr[index] = element;
   index++;
   }
   // popping an element from a stack
   public int pop(){
    if(isEmpty()){
        System.out.println("Stack is empty");
        }
        return arr[--index];
        }
        // Checking whether stack is empty
        public boolean isEmpty(){
            if( index == 0 ){
                return true;
            }
            return false;
        }
        // Checking whetherstack isfull
        public boolean isFull(){
            if(index == size){
                return true;
            }
            return false;
        }
        //Getting Size of the Stack
        public int size(){
            return index;
        }
        public class Stack1 {
        
            public static void main(String[] args) {
                Stack s = new Stack(5);
                s.push(10);
                s.push(20);
                s.push(40);
                s.push(50);
                s.push(80);

                System.out.println("1. Size of stack after push operation: " + s.size());
                System.out.println("2. Pop elements from stack: ");
                while (!s.isEmpty()) {
                    System.out.printf("%d ", s.pop()); 
                }
                System.out.println("\n3. Size of stack after pop operation: " + s.size());
            }
        }
}