package part01introduction.ch01array.question;

import java.io.*;

/*
10개의 입력을 받아 총합과 최소값 출력하기
*/
public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열이 굳이 필요하지 않다고 생각해서 해당방식으로 구현
        int sum = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            int num = Integer.parseInt(reader.readLine());
            sum += num;

            if (min > num) {
                min = num;
            }
        }

        writer.write(String.valueOf(sum));
        writer.newLine();
        writer.write(String.valueOf(min));

        System.out.println("== 출력 ==");
        reader.close();
        writer.close();
    }
}
