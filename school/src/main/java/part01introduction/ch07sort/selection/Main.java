package part01introduction.ch07sort.selection;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 숫자를 공백기준으로 입력 받기
        int[] arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println("정렬 전: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("정렬 후: " + Arrays.toString(arr));
        reader.close();
    }

    // 오름차순 기준
    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {

            // pass 마다 해당 범위 내 가장 작은 값 찾기
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIdx] > arr[j]) minIdx = j;
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
            System.out.printf("%d pass result: %s\n\n", (i + 1), Arrays.toString(arr));
        }
    }
}
