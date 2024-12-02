package team7;

public class Stack {
    private final int[] stack;
    private final int size;
    private int sp;

    public Stack(int size) {
        stack = new int[size];
        this.size = size;
        sp = -1;
    }

    public boolean isEmpty() {
        return sp == -1;
    }

    public void push(int value) {
        if (sp == size - 1)
            System.out.println("stack overflow error");
        else
            stack[++sp] = value;
    }

    public int pop() {
        if (isEmpty())
            return -1;
        else
            return stack[sp--];
    }

    public int peek() {
        if (isEmpty())
            return -1;
        else
            return stack[sp];
    }
}
