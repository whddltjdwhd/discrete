package team7;

public class Queue {
    private final int[] queue;
    private final int size;
    private int front, rear;

    public Queue(int size) {
        queue = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void enqueue(int value) {
        if (rear == size - 1)
            System.out.println("error");
        else
            queue[++rear] = value;
    }

    public int dequeue() {
        if (isEmpty())
            return -1;
        else
            return queue[++front];
    }

    public int peek() {
        if (isEmpty())
            return -1;
        else
            return queue[front + 1];
    }
}
