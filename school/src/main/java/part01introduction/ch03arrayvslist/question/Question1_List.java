package part01introduction.ch03arrayvslist.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;


/* 배열, 배열리스트, 연결리스트 모두 구현해보기

연속적으로 저장할 숫자를 첫 줄에 입력받고, 다음 줄에 숫자 2개 입력받기
숫자는 순서대로 넣고자 하는 인덱스와 값
결과는 전체 리스트 출력하기

ex)

10 20 30 (저장하고자 하는 값)
1 15 (인덱스 값 & )

출력
=> 10 15 20 30
*/

public class Question1_List {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄: 원본 정수 목록 입력 받기
        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        List<Integer> list = new ArrayList<>();
        //List<Integer> list = new LinkedList<>();


        while(tokens.hasMoreTokens()){
            list.add(Integer.parseInt(tokens.nextToken()));
        }

        // 두 번째 줄: 삽입할 값과 인덱스 입력
        String[] insertInput = reader.readLine().split(" ");
        list.add(Integer.parseInt(insertInput[0]), Integer.parseInt(insertInput[1]));

        System.out.println(list);
    }
}
