package part01introduction.ch02list.question.task;

import java.util.Objects;
import java.util.function.Consumer;


// 과제1. 이중 연결 리스트 구현 & 간단한 데이터 입력 / 삭제 구현
// 과제2. 단일/ 이중 연결 리스트의 장단점 설명
public class MyDoublyLinkedList<T> {

    private static class Node<T> {
        private T data;

        private Node<T> prev;
        private Node<T> next;

        public Node(T data) {
            this.data = data;

            this.prev = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", prev=" + prev +
                    ", next=" + next +
                    '}';
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size; // 실제 데이터가 저장된 개수


    public int size() {
        return size;
    }

    //맨 뒤에 추가
    public void add(T value) {
        add(size, value);
    }

    //특정 위치에 삽입
    public void add(int idx, T value) {
        validateIndexForAdd(idx);

        // 맨 앞 삽입
        if (idx == 0) {
            Node<T> newNode = new Node<>(value);
            newNode.next = head;
            head = newNode;

            //맨 뒤 삽입
        } else if (idx == size) {
            Node<T> currentNode = head;

            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            Node<T> newNode = new Node<>(value);
            currentNode.next = newNode;
            newNode.prev = currentNode;

            tail = newNode;

            // 중간 삽입
        } else {
            Node<T> currentNode = head;

            // idx: 데이터 삽입 위치
            // (idx - 1) 위치까지 이동 → 삽입할 노드의 "앞" 노드 찾기
            for (int i = 0; i < idx - 1; i++) {
                currentNode = currentNode.next;
            }

            Node<T> prevNode = currentNode;
            Node<T> newNode = new Node<>(value);
            Node<T> nextNode = currentNode.next;

            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = nextNode;
            nextNode.prev = newNode;
        }
        size++;
    }

    //조회
    public T get(int idx) {
        validateIndexForGetOrRemove(idx);

        // head에 가까우면 head 부터 시작
        if ((size / 2) > idx) {
            Node<T> currentNode = head;
            for (int i = 0; i < idx; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.data;

            // tail 에 가까우면 tail부터 시작
        } else {
            Node<T> currentNode = tail;
            for (int i = size - 1; i > idx; i--) {
                currentNode = currentNode.prev;
            }
            return currentNode.data;
        }
    }

    //마지막 원소 삭제
    public T remove() {
        return remove(size - 1);
    }

    //특정 위치 삭제
    public T remove(int idx) {
        validateIndexForGetOrRemove(idx);

        if (idx == 0) { // 맨 앞 삭제
            Node<T> removeNode = head;
            head = head.next;
            size--;
            return removeNode.data;
        }

        Node<T> currentNode = head;
        for (int i = 0; i < idx - 1; i++) {
            currentNode = currentNode.next;
        }
        Node<T> removeNode = currentNode.next;
        currentNode.next = removeNode.next; //마지막노드를 삭제하는 경우 -> currentNode.next = null
        size--;

        if (idx == size - 1) tail = currentNode; //마지막노드를 삭제하는 경우 tail를 그 앞 노드로 수정
        return removeNode.data;
    }

    //조회/삭제용 검증 (0 <= idx < size)
    private void validateIndexForGetOrRemove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스: " + idx);
        }
    }

    //삽입용 검증 (0 <= idx <= size)
    private void validateIndexForAdd(int idx) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException("유효하지 않은 인덱스: " + idx);
        }
    }

    //리스트 내용을 문자열로 출력
    @Override
    public String toString() {
        if (size == 0) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Node<T> currentNode = head;

        while (currentNode != null) {
            sb.append(currentNode.data);

            if (currentNode.next != null) sb.append(", ");
            currentNode = currentNode.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // 양방향으로 잘 연결돼있는지 확인
    public String getChainStructure() {
        if (size == 0) return "[]";

        StringBuilder sb = new StringBuilder("[");
        Node<T> currentNode = head;


        while (currentNode != null) {

            Node<T> prev = currentNode.prev;
            Node<T> next = currentNode.next;

            if (!Objects.equals(currentNode, head)) sb.append(" - ");

            sb.append(String.format("[(prev: %s) - (current: %s) - (next: %s)]",
                    (prev != null) ? prev.data : null,
                    currentNode.data,
                    (next != null) ? next.data : null
            ));
            currentNode = currentNode.next;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        MyDoublyLinkedList<Integer> intList = new MyDoublyLinkedList<>();
        System.out.println(intList);

        System.out.println("== add(1) ==");
        intList.add(1);
        System.out.println(intList);

        System.out.println("== add(2) ==");
        intList.add(2);
        System.out.println(intList);

        System.out.println("== add(0,0) ==");
        intList.add(0, 0);
        System.out.println(intList);

        System.out.println("== add(1,99) ==");
        intList.add(1, 99);
        System.out.println(intList);

        System.out.println("== remove(2) ==");
        intList.remove(2);
        System.out.println(intList);

        System.out.println("== remove() (마지막) ==");
        intList.remove();
        System.out.println(intList);

        catchException(noting -> intList.get(10));

        System.out.println("== remove() (마지막) ==");
        intList.remove();
        System.out.println(intList);


        // 연결 구조 확인
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        System.out.println(intList);

        System.out.println(intList.getChainStructure());
    }

    // 실습 편의성을 위해 만든 메서드
    private static <T> void catchException(Consumer<T> consumer) {
        try {
            consumer.accept(null);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}

