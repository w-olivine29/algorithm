package part1.ch01string.step5소금폭탄13223;

import java.util.*;

// 예제는 통과인데 채점결과 실패
// 문제 이해 부족으로 같은 시간 처리 누락하였음
public class Main_MySolution1_FAIL {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String currentTimeStr = scanner.nextLine();
        String targetTimeStr = scanner.nextLine();

        System.out.println(getSettingTime(currentTimeStr, targetTimeStr));
    }

    private static String getSettingTime(String currentTimeStr, String targetTimeStr) {

        int[] currentTime = toIntArr(currentTimeStr);
        int[] targetTime = toIntArr(targetTimeStr);
        String[] settingTime = new String[currentTime.length];

        // 초, 분 계산
        for (int i = currentTime.length - 1; i > 0; i--) {
            int time = targetTime[i] - currentTime[i];

            if (time < 0) {
                targetTime[i - 1]--;
                time += 60;
            }

            settingTime[i] = String.format("%02d",time);
        }

        // 시간 조정
        int hour = (targetTime[0] - currentTime[0]);
        if (hour < 0) {
            hour += 24;
        }
        settingTime[0] = String.format("%02d",hour);

        return String.join(":", settingTime);
    }

    private static int[] toIntArr(String time) {
        int[] result = new int[3];

        int idx = 0;
        for (String str : time.split(":")) {
            result[idx++] = Integer.parseInt(str);
        }
        return result;
    }
}
