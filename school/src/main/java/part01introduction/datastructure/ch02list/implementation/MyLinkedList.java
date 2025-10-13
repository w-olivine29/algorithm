package part01introduction.datastructure.ch02list.implementation;

import java.util.function.Consumer;


// 단방향 연결리스트 구현
public class MyLinkedList<T> {

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    private Node<T> head;
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

        if (idx == 0) { // 맨 앞 삽입
            Node<T> newNode = new Node<>(value);
            newNode.next = head;
            head = newNode;
        } else {        // 중간 ~ 끝 삽입
            Node<T> currentNode = head;

            // idx: 데이터 삽입 위치
            // (idx - 1) 위치까지 이동 → 삽입할 노드의 "앞" 노드 찾기
            for (int i = 0; i < idx - 1; i++) {
                currentNode = currentNode.next;
            }
            Node<T> newNode = new Node<>(value);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        size++;
    }

    //조회
    public T get(int idx) {
        validateIndexForGetOrRemove(idx);

        Node<T> currentNode = head;
        for (int i = 0; i < idx; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
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
        currentNode.next = removeNode.next;

        size--;
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


    public static void main(String[] args) {
        MyLinkedList<Integer> intList = new MyLinkedList<>();
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

