package part01introduction.ch10greedy;

import java.io.*;
import java.util.*;

/* 회의실 배정

한 회의실에 희망하는 정보의 개수,
시작, 종료 시간을 모두 받는다.
이 중 수용할 수 있느 최대 예약 건 출력하기


여러 회의 중 겹치지 않게 가장 많이 배정하기.

판단)
    - 한 회의를 선택하면, 그 회의가 끝난 시점 이후의 회의들만 고려 가능.
    - 즉, "현재 선택"이 이후 선택에 불리한 제약을 주지 않는다.
      (탐욕적 선택 속성)

    - 큰 문제(전체 일정)의 최적해는,
      남은 구간(그 회의 이후)의 최적해로 이어붙일 수 있다.
      (최적 부분 구조)

탐욕적 선택 근거)
    - 끝나는 시간이 가장 빠른 회의를 고르면,
      이후 가능한 회의 수가 줄지 않는다.
      (늦게 끝나는 회의를 선택한 최적해가 있다면,
       그 회의를 빨리 끝나는 회의로 교체해도 해의 크기가 줄지 않음)

결론)
    → "끝나는 시간 기준으로 오름차순 정렬" 후
       가능한 회의를 순서대로 선택하면 전역 최적해 보장.

예)
    입력:
        (1,4), (3,5), (0,6), (5,7), (8,11), (12,16)
    선택:
        (1,4) → (5,7) → (8,11) → (12,16)
    결과: 총 4개
ex)
*/

public class MeetingRoom {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 코드 작성
        int n = Integer.parseInt(reader.readLine());
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            meetings.add(new Meeting(Integer.parseInt(input[0]), Integer.parseInt(input[1])));

            System.out.println(meetings.get(i));
        }

        meetings.sort(null); //Collections.sort(meetings); 와 동일한 결과
        System.out.println(meetings);

        int count = 0;
        int lastEndTime = 0;
        for (Meeting meeting : meetings) {
            if(meeting.start >= lastEndTime){
                count++;
                lastEndTime = meeting.end;
            }
        }

        reader.close();
        System.out.println("count = " + count);
    }
    
    public static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        
        // end 기준으로 오름차순 정렬
        @Override
        public int compareTo(Meeting another) {

            if(this.end == another.end){
                return this.start - another.start;
            }
            return this.end - another.end;
        }

        @Override
        public String toString() {
            return String.format("[%d - %d]", start, end);
        }
    }
}
