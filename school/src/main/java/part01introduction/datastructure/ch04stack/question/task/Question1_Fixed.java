package part01introduction.datastructure.ch04stack.question.task;

import java.io.*;
import java.util.*;

public class Question1_Fixed {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> stack = new ArrayDeque<>();

        // 연산자 우선순위 맵 (괄호 제외)
        Map<Character, Integer> priority = Map.of(
                '+', 0,
                '-', 0,
                '*', 1,
                '/', 1
        );

        String input = br.readLine();

        for (char current : input.toCharArray()) {
            if (Character.isDigit(current)) {
                // 피연산자는 바로 출력
                bw.write(current + " ");

            } else if (current == '(') {
                stack.push(current);

            } else if (current == ')') {
                // 여는 괄호까지 pop
                while (!stack.isEmpty() && stack.peek() != '(') {
                    bw.write(stack.pop() + " ");
                }
                stack.pop(); // '(' 제거

            } else { // 연산자 (+, -, *, /)
                while (!stack.isEmpty() && stack.peek() != '('
                        && priority.get(stack.peek()) >= priority.get(current)) {
                    bw.write(stack.pop() + " ");
                }
                stack.push(current);
            }
        }

        // 남은 연산자 모두 출력
        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }

        br.close();
        bw.close();
    }
}

