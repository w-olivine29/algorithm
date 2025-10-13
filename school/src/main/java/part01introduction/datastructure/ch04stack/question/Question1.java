package part01introduction.datastructure.ch04stack.question;

import java.io.*;
import java.util.*;

/* 사용자에게 단어 입력받고, 단어의 순서를 뒤집는 프로그램 만들기*/
public class Question1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // ab c -> c ba

        Deque<Character> stack = new ArrayDeque<>();

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }

        br.close();
        bw.close();
    }
}
