package part01introduction.ch05queue.question.task;

import java.util.ArrayDeque;
import java.util.Deque;

/*
스택 2개로 큐 구현하기
     스택과 큐는 입출력 방향이 반대되는 자료구조
     스택의 출력 순서는 큐의 입력 순서와 일치함
      입력 스택 & 출력 스택 으로 분리
     -> 입력 스택: 새로 들어오는 데이터를 저장
     -> 출력 스택: 입력 스택의 데이터를 옮겨 담아, 큐의 출력 순서를 보장
     결국 출력 스택의 pop 순서 == 큐의 poll 순서
        
    입력 스택 -> 출력 스택으로 옮기는 시점
        peek 나 poll 호출 시 데이터가 있는데, 출력 Stack 에는 없는 경우

*/
public class MyQueue_DoubleStack<E> {

    private static final int DEFAULT_QUANTITY = 10;
    private final Deque<E> inputStack;
    private final Deque<E> outputStack;

    private final int queueQuantity;
    private int size; //실제 저장 데이터 개수


    public MyQueue_DoubleStack(int queueQuantity) {
        this.inputStack = new ArrayDeque<>();
        this.outputStack = new ArrayDeque<>();
        this.queueQuantity = queueQuantity;
    }

    public MyQueue_DoubleStack() {
        this(DEFAULT_QUANTITY);
    }

    public void offer(E e) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        inputStack.push(e);
        size++;
    }

    public E poll() {
        if (outputStack.isEmpty()) {
            moveToOutput();
        }
        E poll = outputStack.isEmpty() ? null : outputStack.pop();
        if (poll != null) size--;
        return poll;
    }

    public E peek() {
        if (outputStack.isEmpty()) {
            moveToOutput();
        }
        return outputStack.isEmpty() ? null : outputStack.peek();
    }

    public boolean isFull() {
        return size == queueQuantity;
    }

    public boolean isEmpty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    public int size() {
        return size;
    }


    private void moveToOutput() {
        while (!inputStack.isEmpty()) {
            outputStack.push(inputStack.poll());
        }
    }


    // 실습 출력 확인용
    @Override
    public String toString() {
        return String.format("입력 스택: %s, 출력 스택: %s", inputStack, outputStack);
    }

    public static void main(String[] args) {
        MyQueue_DoubleStack<Integer> queue = new MyQueue_DoubleStack<>(5);

        queue.offer(1);
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println(queue); //입력 스택: [], 출력 스택: [1]

        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
        System.out.println(queue); //입력 스택: [1, 1, 1, 1], 출력 스택: [1]

        queue.poll();
        System.out.println(queue); //입력 스택: [1, 1, 1, 1], 출력 스택: []

        queue.offer(1);
        queue.offer(1); // Queue is full

        queue.poll();
        System.out.println(queue); //입력 스택: [], 출력 스택: [1, 1, 1, 1]

        queue.poll();
        System.out.println(queue); //입력 스택: [], 출력 스택: [1, 1, 1]

        queue.poll();
        System.out.println(queue); //입력 스택: [], 출력 스택: [1, 1]

        queue.poll();
        System.out.println(queue); //입력 스택: [], 출력 스택: [1]

        queue.poll(); //null
        System.out.println(queue); //입력 스택: [], 출력 스택: []

        System.out.println("queue.isEmpty() = " + queue.isEmpty()); //true;

        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
        System.out.println(queue); //입력 스택: [1, 1, 1], 출력 스택: []
        System.out.println("queue.isEmpty() = " + queue.isEmpty()); //false;
    }
}
