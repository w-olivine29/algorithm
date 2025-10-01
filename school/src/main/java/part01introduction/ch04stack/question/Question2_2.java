package part01introduction.ch04stack.question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


/*
()로 이루어진 문자열 입력받고
'(' 와 ')'이 붙어있다면 한 쌍
입력받은 문자열이 온전한 쌍으로만 이루어져있다면 True 아니면 False 출력

ex)
(()((()))()(((())))) -> True
(()()( -> False
()()))() -> False
*/
public class Question2_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

/*      요소를 넣을 때,  Top에 요소가 같은지 다른지 여부 확인
            -> 같으면 한쌍 x -> push o
            -> 다르면 한쌍 o -> pop o , push x
            
        입력으로 들어온 요소를 다 소모하고나서 스택이 비어있는지 여부 확인
            -> 비어있으면 True
            -> 요소가 남아있으면 False
*/
        String input = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();


        stack.push(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);

            // 여는 괄호일 경우 무조건 push
            if(c == '('){
                stack.push(c);

            }else{
                // 닫는 괄호인데 스택이 비어있다면 해당 괄호는 끝까지 진행해도 짝을 찾을 수 없음
                if(stack.isEmpty()){
                    stack.push(c);
                    break;
                }else if(stack.peekLast() == ')'){
                    stack.push(c);
                }else if(stack.peekLast() == '('){
                    stack.pop();
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        br.close();
    }
}
