package part1.ch01string.step4문서검색1543;

import java.util.*;

public class Main_MySolution1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String targetStr = scanner.nextLine();

        System.out.println(getTargetCount(str, targetStr));

    }

    private static int getTargetCount(String str, String targetStr) {
        int count = 0;
        for (int i = 0; i < str.length(); ) {
            int idx = str.indexOf(targetStr, i);

            if (idx == -1) {
                return count;
            }

            count++;
            i = idx + targetStr.length();
        }
        return count;
    }
}
