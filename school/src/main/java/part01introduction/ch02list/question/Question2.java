package part01introduction.ch02list.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
문제1 에서 I의 형식 바꾸기 (I 다음에는 값과 위치 넣기)
위치가 입력되지 않거나 사이즈보다 큰 값이면, 가장 뒤에 값 넣기
*/
public class Question2 {
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

                if(input.length == 3){ //input: I 인덱스 값
                    list.add(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                }else if(input.length == 2){
                    list.add(Integer.parseInt(input[1]));
                }

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
