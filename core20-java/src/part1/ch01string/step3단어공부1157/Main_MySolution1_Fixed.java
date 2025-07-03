package part1.ch01string.step3단어공부1157;

import java.util.Scanner;


public class Main_MySolution1_Fixed {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 값을 아예 대문자로 통일해서 받아옴
        String str = scanner.next().toUpperCase();

        // 알파벳 개수
        int[] alphabetCnt = new int['z' - 'a' + 1];

        for (int i = 0; i < str.length(); i++) {
            alphabetCnt[str.charAt(i) - 'A']++;
        }

        System.out.println(getMaxCntAlphabet(alphabetCnt));
    }



    private static String getMaxCntAlphabet(int[] alphabetCnt) {

        String maxCntAlphabet = "?";
        int maxCnt = -1;

        for (int i = 0; i < alphabetCnt.length; i++) {
            if (maxCnt < alphabetCnt[i]) {
                maxCnt = alphabetCnt[i];
                maxCntAlphabet = String.valueOf((char) ('A' + i));

            } else if (maxCnt == alphabetCnt[i]) {
                maxCntAlphabet = "?";
            }
        }

        return maxCntAlphabet;
    }
}

