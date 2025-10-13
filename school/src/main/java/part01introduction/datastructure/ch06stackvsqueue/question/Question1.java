package part01introduction.datastructure.ch06stackvsqueue.question;

import java.io.*;
import java.util.*;

/*
정수 목록을 입력받고 ex) 5 6 1 3 2 4  (공백으로 구분)
스택 2개를 이용하여 오름차순 정렬하기

- 정렬용 스택
- 출력 & 임시저장공간용 스택

- 요소가 top 보다 크면 바로 push
- 요소가 top 보다 작으면 top의 요소과 비교 시작
    - 요소보다 큰 top은 출력스택에 push 해놓기 (임시)
        이 과정을 요소보다 작은 top를 만날때까지 반복
    - 요소보다 작은 top를 만나면 요소를 push
    - 출력 스택에 임시로 push 해놨던 요소들을 차례대로 pop 해서 정렬용 스택에 push

- 모든 요소의 정렬이 끝났다면 차례대로 pop 해서 출력스택에 push
- 출력스택에서 차례대로 pop
*/
public class Question1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> sortStack = new ArrayDeque<>();
        Deque<Integer> outputStack = new ArrayDeque<>();

        StringTokenizer tokens = new StringTokenizer(reader.readLine());
        sortStack.push(Integer.parseInt(tokens.nextToken()));


        // 해당 반복문의 한번의 루프마다 재정렬이 이루어짐
        while (tokens.hasMoreTokens()) {
            int num = Integer.parseInt(tokens.nextToken());

            // 정렬스택에는  bottom <- 작은 수     큰 수 -> Top 순으로 들어가야한다
            while (!sortStack.isEmpty()) {
                if (num >= sortStack.peek()) {
                    sortStack.push(num);
                    break;

                } else { // 자신 보다 작은 요소를 만날 때까지 반복
                    outputStack.push(sortStack.pop());
                    if (sortStack.isEmpty()) {
                        sortStack.push(num);
                        break;
                    }
                }
            }

            // 정렬 순위에서 밀려서 임시로 저장해놨던 숫자들을 순서대로 꺼내서 다시 넣어준다.
            while (!outputStack.isEmpty()) {
                sortStack.push(outputStack.pop());
            }
        }


        System.out.println("정렬스택 확인: " + sortStack);

        // 정렬 완료 후 출력 순으로 반전하기 위해 출력스택에 차례대로 넣기
        while (!sortStack.isEmpty()) {
            outputStack.push(sortStack.pop());
        }
        System.out.println("출력스택 확인: " + outputStack);

        StringBuilder sb = new StringBuilder();
        // 출력
        while (!outputStack.isEmpty()) {
            sb.append(outputStack.pop());

            if (outputStack.peek() != null){
                sb.append(" ");
            }
        }

        reader.close();
        System.out.println(sb);
    }
}
