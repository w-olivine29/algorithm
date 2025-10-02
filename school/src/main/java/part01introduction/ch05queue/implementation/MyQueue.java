package part01introduction.ch05queue.implementation;

public class MyQueue<E> {

    private static final int DEFAULT_SIZE = 10;
    private E[] arr;
    private int front, rear, size; // front, rear: 인덱스 포인터 역할

    @SuppressWarnings("unchecked cast")
    public MyQueue() {
        arr = (E[]) new Object[DEFAULT_SIZE];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(E e) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        arr[rear] = e;
        rear = (rear + 1) % arr.length;
        size++;
    }

    public E dequeue() {

        if (isEmpty()) {
            System.out.println("Queue isEmpty");
            return null;
        }

        E remove = arr[front];
        arr[front] = null;

        front = (front + 1) % arr.length;
        size--;
        return remove;
    }

    public E peek() {
        if (isEmpty()) {
            System.out.println("Queue isEmpty");
            return null;
        }
        return arr[front];
    }


    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == arr.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("front: ").append(front)
                .append(", rear: ").append(rear)
                .append(", size: ").append(size).append(" ");

        if (size == 0) return sb.append("[]").toString();

        sb.append("[");
        
        // 원형큐로 구현했기때문에 front가 rear 보다 뒤에 있을 수 있다는 점을 고려야함
        // front 부터 size 만큼 반복해서 출력
        // 인덱스의 경우 단순히 (front + i) 를 하면 배열범위를 넘어가고 순환이 불가하기 때문에 나머지 연산 필요
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % arr.length;
            sb.append(arr[idx]);

            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");


        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println("=== queue ===");
        MyQueue<Integer> queue = new MyQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println("after enqueue " + i + " -> queue: " + queue);
        }
        System.out.println();


        System.out.println("== dequeue,peek 시작 ==");
        for (int i = 0; i < 10; i++) {
            System.out.println("queue: " + queue);
            System.out.println("before dequeue peek: " + queue.peek());
            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("after dequeue peek: " + queue.peek());
            System.out.println();
        }

        System.out.println();
        System.out.println("queue: " + queue); //queue: front: 10, rear: 9, size: 0 []


        System.out.println("\n\n");

        for (int i = 0; i < 10; i++) {
            queue.enqueue(10 + i);
        }
        System.out.println("queue: " + queue); //queue: front: 10, rear: 19, size: 10 [10, 10, 11, 12, 13, 14, 15, 16, 17, 18]


        System.out.println("dequeue & enqueue");
        for (int i = 0; i < 10; i++) {

            System.out.println("dequeue: " + queue.dequeue());
            System.out.println("enqueue: " + (100 + i));
            queue.enqueue(100 + i);

            System.out.println("queue: " + queue);
            System.out.println();
        }
    }
}
