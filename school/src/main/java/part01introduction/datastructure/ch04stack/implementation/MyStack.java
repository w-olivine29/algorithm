package part01introduction.datastructure.ch04stack.implementation;

public class MyStack<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;

    private E[] data;
    private int top; // 최상의 원소 데이터의 인덱스 값
//    private int size; // 스택에 들어있는 요소 개수


    public MyStack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked cast")
    public MyStack(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
        top = -1; // 스택 초기 상태
    }

    public void push(E e) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        data[++top] = e;
    }

    public E pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return data[top--];
    }

    public E peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return data[top];
    }


    private boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(data[i]);

            if (i != top) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {

        MyStack<Integer> stack = new MyStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.printStack();

        System.out.println("stack.pop() = " + stack.pop()); //3
        stack.printStack(); //1,2

        System.out.println("stack.pop() = " + stack.pop()); //2
        stack.printStack(); //1

        System.out.println("stack.pop() = " + stack.pop()); //1
        stack.printStack(); //empty

        System.out.println("stack.peek() = " + stack.peek()); // null

        stack.push(3);
        System.out.println("stack.peek() = " + stack.peek()); // 3


        stack.push(3);
        stack.printStack(); //3,3

        stack.push(3);
        stack.printStack(); //3,3,3

        stack.push(3); //Stack is full
        stack.printStack(); //3,3,3
    }
}
