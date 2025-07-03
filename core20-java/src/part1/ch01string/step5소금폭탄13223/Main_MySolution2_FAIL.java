package part1.ch01string.step5소금폭탄13223;

import java.util.Scanner;

// 예제는 통과인데 채점결과 실패
// 문제 이해 부족으로 같은 시간 처리 누락하였음
public class Main_MySolution2_FAIL {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String currentTimeStr = scanner.nextLine();
        String targetTimeStr = scanner.nextLine();

        System.out.println(getTime(currentTimeStr, targetTimeStr));

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
        String[] timeArr = new String[3];

        // 시간 구하기 &  total seconds - 구한 시간 만큼의 second
        int hour = resultSeconds / (60 * 60);
        timeArr[0] = String.format("%02d", hour);
        resultSeconds -= hour * (60 * 60);

        // 분 구하기 &  total seconds - 구한 분 만큼의 second
        int minute = resultSeconds / 60;
        timeArr[1] = String.format("%02d", minute);
        resultSeconds -= minute * 60;

        // 초 구하기 (남은 초)
        timeArr[2] = String.format("%02d", resultSeconds);

        return String.join(":", timeArr);
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
