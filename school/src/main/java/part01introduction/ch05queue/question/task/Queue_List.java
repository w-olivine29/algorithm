package part01introduction.ch05queue.question.task;

/*
배열이 아닌 리스트로 큐 구현하기
*/

import java.util.LinkedList;

public class Queue_List<E> {

    private LinkedList<E> list;

    public Queue_List() {
        list = new LinkedList<>();
    }

    public void offer(E value) {
        list.addLast(value);
    }

    public E poll() {
        if (list.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return list.removeFirst();
    }

    public E peek() {
        if (list.isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public static void main(String[] args) {
        Queue_List<Integer> queue = new Queue_List<>();


        System.out.println("=== offer ===");
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);


        System.out.println("peek: " + queue.peek()); // 10


        System.out.println("=== poll ===");
        System.out.println(queue.poll()); // 10
        System.out.println(queue.poll()); // 20


        System.out.println("peek: " + queue.peek()); // 30

        System.out.println(queue.poll()); // 30

        System.out.println("isEmpty: " + queue.isEmpty()); // true
        System.out.println("poll: " + queue.poll()); // Queue is empty -> null
        System.out.println("peek: " + queue.peek()); // Queue is empty -> null
    }

}


