package part01introduction.ch03arrayvslist.question;

import java.io.*;
import java.util.*;


/* 배열, 배열리스트, 연결리스트 모두 구현해보기

연속적으로 저장할 숫자를 첫 줄에 입력받고, 다음 줄에 숫자 2개 입력받기
숫자는 순서대로 넣고자 하는 인덱스와 값
결과는 전체 리스트 출력하기

ex)

10 20 30 (저장하고자 하는 값)
1 15 (인덱스 값 & )

출력
=> 10 15 20 30
*/

public class Question1_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄: 원본 배열 입력 받기
        StringTokenizer tokens = new StringTokenizer(reader.readLine(), " ");

        int[] arr = new int[tokens.countTokens()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
        }


        // 두 번째 줄: 삽입할 값과 인덱스 입력
        String[] insertInput = reader.readLine().split(" ");
        int insertIndex = Integer.parseInt(insertInput[0]);
        int insertValue = Integer.parseInt(insertInput[1]);

        // 새로운 배열 생성 (크기 증가)
        int[] newArr = new int[arr.length + 1];

        // 기존 배열에서 삽입 위치 전까지 복사
        for (int i = 0; i < insertIndex; i++) {
            newArr[i] = arr[i];
        }

        // 삽입할 값 추가
        newArr[insertIndex] = insertValue;

        // 기존 배열에서 삽입 위치 이후 복사
        for (int i = insertIndex; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        System.out.println(Arrays.toString(newArr)); // [10, 15, 20, 30]
    }
}
