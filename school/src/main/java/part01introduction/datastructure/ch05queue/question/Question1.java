package part01introduction.datastructure.ch05queue.question;

import java.io.*;
import java.util.*;

/*
N 명의 인원이 둥글게 앉아있으며, 1번부터 N번의 숫자가 주어져있다.
1번부터 퇴실, 다음은 M번 떨어진 인원이 순서대로 퇴실
이 때, 떨어진 자리는 자리가 아닌 "인원으로 판단"할 때 퇴실하는 인원의 번호를 순서대로 출력

ex)
    N: 10
    M: 3

    결과)
        1 4 7 10 5 9 6 3 8 2

    M보다 적은 인원이 남았을 때는 그냥 그대로 퇴실?
    아니면 남은 인원으로 M번 돌리기?
*/
public class Question1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        int num = 0;
        while (!queue.isEmpty()) {
            if (num % M == 0) {
                writer.write(queue.poll() + " ");
            } else {
                queue.offer(queue.poll());
            }
            num++;
        }

        reader.close();
        writer.close();

    }
}
