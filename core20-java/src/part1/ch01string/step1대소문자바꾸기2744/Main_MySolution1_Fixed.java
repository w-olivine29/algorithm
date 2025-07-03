package part1.ch01string.step1대소문자바꾸기2744;

import java.util.Scanner;

public class Main_MySolution1_Fixed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        System.out.println(invertCase(string));

    }

    // 아스키코드 숫자를 직접 사용하면 직관적이지 못하고, 암기를 해야하는 단점이 있다.
    // char 는 연산 시 자동으로 아스키코드 숫자로 변환돼서 연산가능한 점을 기억하자
    public static String invertCase(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {

            // 숫자가 아닌 직접 char 로 비교하면 된다.
            if (c >= 'a') {
                sb.append((char)('A' + c - 'a')); // 소문자 -> 대문자
            }else {
                sb.append('a' + c - 'A'); // 대문자 -> 소문자
            }
        }
        return sb.toString();
    }
}
