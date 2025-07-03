package part1.ch01string.step1대소문자바꾸기2744;

import java.util.Scanner;

public class Main_MySolution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        System.out.println(invertCase(string));

    }

    // 아스키코드 활용
    public static String invertCase(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            String target = String.valueOf(c);
            if (c >= 97) {
                sb.append(target.toUpperCase());
            }else {
                sb.append(target.toLowerCase());
            }
        }
        return sb.toString();
    }
}
