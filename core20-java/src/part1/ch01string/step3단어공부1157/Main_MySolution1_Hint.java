package part1.ch01string.step3단어공부1157;

import java.util.*;


public class Main_MySolution1_Hint {

    static final int ALPHABET_COUNT = 'z' - 'a' + 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        // 알파벳 개수
        int[] alphabetCnt = new int[ALPHABET_COUNT];

        for (int i = 0; i < str.length(); i++) {
            alphabetCnt[Character.toUpperCase(str.charAt(i)) - 'A']++;
        }

        System.out.println(getMaxCntAlphabet(alphabetCnt));
    }


    private static String getMaxCntAlphabet(int[] alphabetCnt) {

        int maxIdx = -1;
        int maxCnt = -1;
        boolean isDuplicate = false; // 최대횟수 중복여부

        for (int i = 0; i < alphabetCnt.length; i++) {
            if (maxCnt < alphabetCnt[i]) {
                isDuplicate = false; // 중복상태에서 최대횟수가 갱신됐다면 다시 false 처리
                maxCnt = alphabetCnt[i];
                maxIdx = i;
            } else if (maxCnt == alphabetCnt[i]) {
                isDuplicate = true;
            }
        }

        return isDuplicate ? "?" : String.valueOf((char) (maxIdx + ALPHABET_COUNT));
    }
}

