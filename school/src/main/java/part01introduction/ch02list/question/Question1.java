package part01introduction.ch02list.question;

import java.io.*;
import java.util.*;

/*
사용자가 입력한 명령어에 따라 리스트에 값을 추가/삭제
명령어는 I(데이터를 마지막에 입력, 양수만 가능), D(마지막 값 삭제), E(종료)

결과는 종류 이후에 가장 마지막 값, 모든 값, 사이즈 출력 (비어있다면 -1 출력)
단 D는 I의 횟수보다 더 많이 입력될 수 없음

ex) 명령어 + " " + 양수 형태로 입력
    I 5
    D
    I 10
    E
*/
public class Question1 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        //List<Integer> list = new LinkedList<>();

        while (true) {
            String[] input = reader.readLine().split(" ");

            if ("E".equals(input[0])) {
                break;
            }

            if ("I".equals(input[0])) {
                list.add(Integer.parseInt(input[1]));

            } else if ("D".equals(input[0])) {
                if (!list.isEmpty()) {
                    list.remove(list.size() - 1);
                }
            }
        }

        if (list.isEmpty()) {
            System.out.println(-1);

        } else {
            StringBuilder sb = new StringBuilder();

            // 가장 마지막 값
            sb.append("가장 마지막 값: ").append(list.get(list.size() - 1)).append("\n");

            // 모든 값 ([요소, 요소] 형태로 한번에 출력 x)
            sb.append("모든 값: ");
            for (int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");


            // 사이즈
            sb.append("사이즈: ").append(list.size()).append("\n");

            System.out.println(sb);
        }

    }

}
