package part01introduction.ch01array;

// 자바의 import는 클래스가 속한 패키지 기준으로 가져온다.
import java.util.*; // util 패키지 바로 아래에 속하는 클래스들 전체 import (util 의 하위패키지까지 가져오지 않음)
import java.util.stream.*; // Stream API 는 util 패키지 하위의 stream 패키지에 있음

public class Intro {
    public static void main(String[] args) {

        // 1. 사이즈를 명확하게 지정하여 초기화하는 방식
        int[] intArr1 = new int[3]; // int (4byte) * 3 -> 12byte의 연속된 힙 메모리 공간 할당
        System.out.println(Arrays.toString(intArr1)); //[0, 0, 0] 빈 값이 아닌 데이터마다의 기본값으로 할당

        // TODO 주석 수정
        // 메모리 공간에 올라온 데이터들은 항상 말끔한 상태가 아님, 쓰레기 값들이 남아있을 수 있음


        // 2. 선언과 초기값 설정 바로 하기
        int[] intArr2 = {1, 2, 3}; // 직접 넣은 값의 개수를 인식하여 배열의 사이즈 결정
        System.out.println(Arrays.toString(intArr2));

        // 3. 반복문을 사용한 초기화 (크기 지정 이후 낱개로 값 배정)
        int[] intArr3 = new int[3];
        for (int idx = 0; idx < intArr3.length; idx++) {
            intArr3[idx] = (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(intArr3));

        //4. 배열을 특정한 값으로 일괄 초기화 - Arrays.fill(배열, 값)
        int[] intArr5 = new int[3];
        Arrays.fill(intArr5, 7);
        System.out.println(Arrays.toString(intArr5)); //[7, 7, 7]

        //5. Stream 을 활용한 초기화
        int[] streamArr = IntStream.rangeClosed(1, 5)
                .toArray();

        System.out.println(Arrays.toString(streamArr)); //[1, 2, 3, 4, 5]
    }
}
