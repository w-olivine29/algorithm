package part1.ch01string.step4문서검색1543;

import java.util.Scanner;

//Solution1은 MySolution1에서 while 문으로 변경한 내용이어서 생략

// indexOf() 가 아닌 replace 방식
public class Main_Solution2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String targetStr = scanner.nextLine();

        System.out.println(getTargetCount(str, targetStr));

    }

    
    private static int getTargetCount(String str, String targetStr) {

        //단어에 해당하는 문자열을 제거 (단어의 배수만큼 제거될 것임)
        String replacedStr = str.replace(targetStr, "");
        int removedLength = str.length() - replacedStr.length();

        // 지워진 길이 / 단어 길이 => 단어 등장 횟수
        return removedLength/targetStr.length();
    }
}
