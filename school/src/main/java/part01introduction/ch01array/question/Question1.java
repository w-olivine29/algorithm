package part01introduction.ch01array.question;

import java.util.*;
import java.io.*;

/*
사용자에게 데이터 크기를 입력받고, 값을 0~10 내로 랜덤하게 초기화하기
마지막엔 특정 숫자를 입력받아, 해당 숫자의 개수 출력하기
*/
public class Question1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();

        // 1. 사용자에게 배열의 크기 입력받기
        int[] arr = new int[Integer.parseInt(reader.readLine())];

        // 2. 0~10 사이의 랜덤 값 초기화
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10 + 1); // 10내 라는 의미가 직관적으로 보이기 위해서 11이 아닌 10+1 로 넣었음
        }

        // 3. 사용자에게 특정 숫자 입력받기
        int targetNum = Integer.parseInt(reader.readLine());
        int count = 0;

        // 4. 개수를 세어 출력한다.
        for (int j : arr) {
            if (j == targetNum) count++;
        }
        System.out.println(Arrays.toString(arr)); //확인용
        System.out.println(count);
    }
}
