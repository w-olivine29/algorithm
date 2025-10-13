package part01introduction.datastructure.ch01array.question;

import java.io.*;
import java.util.*;

/*
사용자가 원하는 개수를 입력받고, 연달오는 개수만큼의 값으로 초기화
합/ 평균/ 최소/ 최댓값 순서대로 출력하기
*/
public class Question3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        int[] arr = new int[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        double average = 0.0;

        for (int num : arr) {
            sum += num;
            min = Integer.min(min, num);
            max = Integer.max(max, num);
        }
        average = sum / (double) count;

        // 조건문/반복문 밖 단발성 문자열 결합의 경우 + 연산을 해도 내부적으로 알아서 가변스트링 사용하기때문에 굳이 직접 가변스트링 정의해서 사용할 필요는 없음
        // 하지만 조건문/반복문 내에서의 반복 결합의 경우는 외부에 직접 가변스트링 정의해서 사용 (내부적으로 계속 가변스트링을 새로 만들어내기 때문에 성능문제가 생기기때문)
        String sb = sum + "\n" +
                String.format("%.2f", average) + "\n" +
                min + "\n" +
                max + "\n";

        System.out.println(sb);
    }
}
