package part01introduction.ch07sort.bubble;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 숫자를 공백기준으로 입력 받기
        int[] arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println("정렬 전: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("정렬 후: " + Arrays.toString(arr));
        reader.close();

    }

    // 오름차순 (기본)
    private static void bubbleSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) { // 버블정렬의 최대비교횟수는 요소개수 - 1 (마지막에 남은 한 개의 요소는 비교대상이 없기때문)

            boolean isSwap = false;

            //자신의 바로 뒤 요소와 비교하기때문에 범위는 -1, pass마다 정렬된 개수는 제외하기때문에 -i
            //실수했던 점 :  arr.length - (i - 1) 로 잡았었다 -> 이러면  i가 0일 때 arr.length + 1 이 돼버림
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwap = true;
                }
                System.out.printf("%d-%d pass result: %s\n", (i + 1), (j + 1), Arrays.toString(arr));
            }
            System.out.printf("%d pass result: %s\n\n", (i + 1), Arrays.toString(arr));
            if (!isSwap) return; // 해당 pass에서 swap 한번도 일어나지 않았다면 정렬이 완료됐다는 의미
        }
    }
}
