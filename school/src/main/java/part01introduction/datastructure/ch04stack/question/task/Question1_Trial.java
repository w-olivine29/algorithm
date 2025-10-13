package part01introduction.datastructure.ch04stack.question.task;

import java.io.*;
import java.util.*;

/*
중위표현식 -> 후위표현식으로 변환하는 코드 만들기

ex) (3+4)*6/12+7*10 -> 3 4 + 6 * 12 / 7 10 * +
*/

// 첫 풀이시도 (연산자는 사칙연산, 소괄호가 들어오는 상황만 고려하였음)
public class Question1_Trial {
    // 스택 (연산자)
    // 출력 버퍼

    // 피연산자는 바로 출력버퍼에 넣기
    // 연산자의 경우 스택 Top 에 있는 연산자와 우선순위 비교
    // Top 에 있는 연산자가 더 높을 경우 pop() , 현재 연산자를 push
    // Top 에 있는 연산자가 만약 닫는 괄호면, 스택에 남아있는 연산자를 차례대로 pop 해서 출력버퍼에 넣고, 현재 연산자를 push
    // 현재 연산자가 더 높을 경우 push()


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Character> stack = new ArrayDeque<>();


        Map<Character, Integer> priority = Map.of(
                '+', 0,
                '-', 0,
                '*', 1,
                '/', 1,
                '(', 2,
                ')', 2
        );

        String input = br.readLine();

        for (char current : input.toCharArray()) {
            if (Character.isDigit(current)) {
                bw.write(current);

            } else { // 연산자
                if (stack.isEmpty()) {
                    stack.push(current);
                } else {
                    char topOperator = stack.peek();

                    // Top에 있는 연산자가 우선순위가 더 높으면
                    if (priority.get(topOperator) >= priority.get(current)) {

                        if (topOperator == ')') {
                            while (!stack.isEmpty()) {
                                char pop = stack.pop();
                                if (pop != '(' && pop != ')') { // 괄호는 출력에 제외
                                    bw.write(pop);
                                }
                            }
                        } else {
                            char pop = stack.pop();
                            if (pop != '(' && pop != ')') { // 괄호는 출력에 제외
                                bw.write(pop);
                            }
                        }

                        stack.push(current);

                    } else {
                        stack.push(current);
                    }
                }
            }
        }

        while(!stack.isEmpty()){
            bw.write(stack.pop());
        }


        br.close();
        bw.close();
    }

}

