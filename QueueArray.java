class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = 0;
        this.rear = -1;
        this.currentSize = 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue Overflow: Cannot enqueue " + value);
            return;
        }
        rear = (rear + 1) % maxSize; // Circular increment
        queueArray[rear] = value;
        currentSize++;
        System.out.println(value + " enqueued into queue");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow: Cannot dequeue from an empty queue");
            return -1; // Return -1 or throw an exception for underflow
        }
        int dequeuedValue = queueArray[front];
        front = (front + 1) % maxSize; // Circular increment
        currentSize--;
        return dequeuedValue; // Return the dequeued value
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1; // Return -1 or throw an exception for empty queue
        }
        return queueArray[front]; // Return the front element
    }

    public boolean isEmpty() {
        return currentSize == 0; // Queue is empty if currentSize is 0
    }

    public boolean isFull() {
        return currentSize == maxSize; // Queue is full if currentSize equals maxSize
    }

    public int size() {
        return currentSize; // Return the number of elements in the queue
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Elements in queue: ");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(queueArray[(front + i) % maxSize] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.print();

        System.out.println("1. Dequeued element: " + queue.dequeue());
        System.out.println("2. Front element is: " + queue.peek());
        queue.print();

        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60); // This should show an overflow message
        queue.print();

        System.out.println("3. Size of queue: " + queue.size());
    }
}