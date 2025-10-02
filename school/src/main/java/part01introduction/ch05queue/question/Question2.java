package part01introduction.ch05queue.question;

import java.io.*;
import java.util.*;


/*
사용자에게 N M 값을 입력받는다.
1부터 N 까지의 값

한라운드를 지날 때마다 값을 10배 증가, M 이하의 값만 출력
각 라운드의 숫자, 개수, 값 출력하기

ex)
    6 100

// 라운드수(해당 라운드에 들어온 개수): 요소...
    -> 1(6): 1 2 3 4 5 6
    -> 2(6) 10 20 30 40 50 60
    -> 3(1):100
*/
public class Question2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) queue.offer(i);


        int round = 0;
        while (!queue.isEmpty()) {

            // 맨 앞에 있는 수가 조건 불일치 시 -> 뒤에 있는 요소들도 모두 불일치
            if (queue.peek() > M) break;

            int maxNum = queue.size(); // 라운드마다의 시작하는 최대 개수
            writer.write(++round + "(" + maxNum + "): ");

            for (int i = 0; i < maxNum; i++) {
                Integer value = queue.poll();
                if (value != null) {
                    writer.write(String.valueOf(value));
                    if (i < maxNum - 1) writer.write(" ");

                    // 조건에 맞지 않는 값이면 다시 추가 X
                    int newValue = value * 10;
                    if(newValue < M) queue.offer(newValue);
                }
            }
            writer.write("\n");

        }


        reader.close();
        writer.close();
    }
}
