package part01introduction.datastructure.ch01array.question;

import java.io.*;
import java.util.*;

public class Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 기준점: 어떤 상황에서 배열을 확장해야하는가?
        // -> 배열의 index 위치가 초과되었을 때 확장필요
        int[] arr = new int[1];
        int idx = 0;

        String input = "";
        while (!Objects.equals((input = reader.readLine()), "exit")) {
            int value = Integer.parseInt(input);

            // 배열의 인덱스의 범위가 초과된 경우 확장 (길이가 확장된 새로운 배열 만들고, 기존 배열 값 차례대로 할당)
            if (idx == arr.length) {
                
                // 메인로직에서 벗어난 부분은 따로 함수화
                arr = expandArray(arr);
            }
            arr[idx++] = value;
            System.out.println(Arrays.toString(arr));
        }
        // 배열을 확장해야하는 상황이 빈번하게 일어난다면 배열은 적합하지 않은 자료구조
    }



    //arr = Arrays.copyOf(arr, arr.length + 1); 과 동일한 기능
    public static int[] expandArray(int[] originalArr) {
        int[] newArr = new int[originalArr.length + 1];
        for (int i = 0; i < originalArr.length; i++)
            newArr[i] = originalArr[i];
        return newArr;
    }
}
