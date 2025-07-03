package part1.ch01string.step5소금폭탄13223;

import java.util.Scanner;


// 풀이1,2 의 접근법 자체는 틀리지 않았으나, 문제를 잘못 이해한 부분이 있었음
public class Main_MySolution2_Fixed {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String currentTimeStr = scanner.nextLine();
        String targetTimeStr = scanner.nextLine();

        if (currentTimeStr.equals(targetTimeStr)) {
            System.out.println("24:00:00");
        } else {
            System.out.println(getTime(currentTimeStr, targetTimeStr));
        }
    }

    static String getTime(String currentTimeStr, String targetTimeStr) {

        String[] currentArr = currentTimeStr.split(":");
        String[] targetArr = targetTimeStr.split(":");

        if (Integer.parseInt(currentArr[0]) > Integer.parseInt(targetArr[0])) {
            targetArr[0] = String.valueOf(Integer.parseInt(targetArr[0]) + 24);
        }

        // 시간 차이 (초단위)
        int resultSeconds = getTotalSeconds(targetArr) - getTotalSeconds(currentArr);

        return getTimeStr(resultSeconds);
    }

    static String getTimeStr(int resultSeconds) {
        int[] timeArr = new int[3];

        // 시간 구하기 &  total seconds - 구한 시간 만큼의 second
        timeArr[0] = resultSeconds / (60 * 60);
        resultSeconds -= timeArr[0] * (60 * 60);

        // 분 구하기 &  total seconds - 구한 분 만큼의 second
        timeArr[1] = resultSeconds / 60;
        resultSeconds -= timeArr[1] * 60;

        // 초 구하기 (남은 초)
        timeArr[2] = resultSeconds;

        return String.format("%02d:%02d:%02d", timeArr[0], timeArr[1], timeArr[2]);
    }


    // 현재시각과 소금 투하 시각을 초단위로 바꾼 뒤 시간차이를 구하는 용도
    static int getTotalSeconds(String[] timeArr) {

        int totalSeconds = 0;

        totalSeconds += Integer.parseInt(timeArr[0]) * 60 * 60;
        totalSeconds += Integer.parseInt(timeArr[1]) * 60;
        totalSeconds += Integer.parseInt(timeArr[2]);

        return totalSeconds;
    }
}
