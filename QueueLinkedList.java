class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    private Node front; // Points to the front of the queue
    private Node rear;  // Points to the rear of the queue
    private int currentSize; // Current size of the queue

    public Queue() {
        this.front = null;
        this.rear = null;
        this.currentSize = 0;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = newNode; // If the queue is empty, both front and rear point to the new node
            rear = newNode;
        } else {
            rear.next = newNode; // Link the new node at the end of the queue
            rear = newNode; // Update the rear to the new node
        }
        currentSize++;
        System.out.println(value + " enqueued into queue");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow: Cannot dequeue from an empty queue");
            return -1; // Return -1 or throw an exception for underflow
        }
        int dequeuedValue = front.data; // Get the value from the front node
        front = front.next; // Move the front pointer to the next node
        currentSize--;
        if (front == null) { // If the queue becomes empty, set rear to null
            rear = null;
        }
        return dequeuedValue; // Return the dequeued value
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return -1; // Return -1 or throw an exception for empty queue
        }
        return front.data; // Return the value of the front node
    }

    public boolean isEmpty() {
        return currentSize == 0; // Queue is empty if currentSize is 0
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
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.enqueue(70);
        queue.enqueue(90);
        queue.enqueue(100);
        queue.print();

        System.out.println("1. Dequeued element: " + queue.dequeue());
        System.out.println("2. Front element is: " + queue.peek());
        queue.print();

        queue.enqueue(40);
        queue.enqueue(50);
        queue.print();

        System.out.println("3. Size of queue: " + queue.size());
    }
}