package part01introduction.ch02list.implementation;

import java.util.*;
import java.util.function.Consumer;

public class MyArrayList<T> {

    private static final int DEFAULT_SIZE = 10;
    private T[] data;

    private int size; //실제 데이터가 저장된 개수


    @SuppressWarnings("unchecked cast")
    MyArrayList() {
        data = (T[]) new Object[DEFAULT_SIZE];
    }

    @SuppressWarnings("unchecked cast")
    MyArrayList(int size) {
        data = (T[]) new Object[size];
    }

    public int size() {
        return size;
    }

    public void add(T value) {

        // 배열이 포화상태면 확장된 배열로 새로 할당
        if (size >= data.length) {
            reSizeArray();
        }

        data[size++] = value;
    }

    public void add(int idx, T value) {
        validateIndex(idx);

        // 배열이 포화상태면 확장된 배열로 새로 할당
        if (size >= data.length) {
            reSizeArray();
        }
        shiftRight(idx);
        data[idx] = value;
        size++;
    }

    public T get(int idx) {
        validateIndex(idx);
        return data[idx];
    }

    public T remove() {
        T removeData = data[size - 1];
        data[size - 1] = null;
        size--;

        return removeData;
    }

    public T remove(int idx) {
        validateIndex(idx);
        T removeData = data[idx];
        shiftLeft(idx);

        size--;
        return removeData;
    }


    private void shiftLeft(int targetIdx) {
        for (int i = targetIdx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
    }

    private void shiftRight(int targetIdx) {
        for (int i = size - 1; i >= targetIdx; i--) {
            data[i + 1] = data[i];
        }
    }


    private void validateIndex(int idx) {
        if (idx < 0 || idx >= size) {
            throw new ArrayIndexOutOfBoundsException("유효하지 않은 인덱스:" + idx);
        }
    }


    private void reSizeArray() {
        data = Arrays.copyOf(data, data.length * 2);
        System.out.println("배열 확장: " + data.length / 2 + " -> " + data.length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);

            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayList<Integer> intList1 = new MyArrayList<>(3);
        System.out.println(intList1);


        intList1.add(1);
        intList1.add(2);
        intList1.add(3);
        System.out.println(intList1);

        intList1.remove(0);
        System.out.println(intList1);

        intList1.add(1);
        System.out.println(intList1);

        intList1.add(1, 1);
        System.out.println(intList1);

        intList1.add(intList1.size() - 1, 1);
        System.out.println(intList1);

        catchException(noting -> intList1.add(intList1.size(), 1));
        System.out.println(intList1);
    }

    // 실습 편의성을 위해 만든 메서드
    private static <T> void catchException(Consumer<T> consumer) {
        try {
            consumer.accept(null);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}

