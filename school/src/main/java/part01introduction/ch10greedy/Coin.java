package part01introduction.ch10greedy;

/* 동전 거스름돈

특정 금액을 입력받았을 때, 동전으로 거슬러준다.
동전의 종류는 500, 100, 50, 10원이며, 개수에는 제한이 없다.
이때 "가장 적은 개수의 동전"으로 거슬러주는 방법을 구한다.

판단)
    예) 950원일 경우
        950 / 500 -> 1개
        450 / 100 -> 4개
        50 / 50 -> 1개
        총 6개

탐욕적 선택이 가능한 이유:
    - 항상 큰 단위의 동전이 작은 단위의 정확한 배수로 구성되어 있다.
      (500 = 5×100, 100 = 2×50, 50 = 5×10)
      → 따라서, 큰 단위를 먼저 선택해도 이후의 선택에 불리한 제약을 주지 않는다.
        즉, 현재의 선택이 미래의 선택에 영향을 주지 않음.

    - 또한, 큰 문제의 최적해는 작은 문제의 최적해로 구성된다.
      예를 들어 950원을 거슬러줄 때,
        950원의 최적해 = 500원 1개 + 450원의 최적해
        450원의 최적해 = 100원 4개 + 50원의 최적해
        50원의 최적해 = 50원 1개 + 0원의 최적해
      → 작은 문제의 해법이 그대로 큰 문제의 해법에 포함되는 구조이며,
        중간에 '다르게 풀어야 하는 구간'이 전혀 없다.

직관적 해석:
    “한 번 풀어본 작은 금액 문제의 해법을,
     그대로 이어붙여 큰 금액 문제를 해결할 수 있다.”
    즉, 문제의 크기만 달라질 뿐, 푸는 방식은 변하지 않는다.

예시)
    입력: 950
    출력: 6


배수 구조형 문제는 구조가 매우 단순하기 때문에 탐욕적 선택 속성이 바로 보이는 편
-> 결국 입문형 문제
*/

import java.io.*;


public class Coin {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        int[] coins = {500, 100, 50, 10};

        int count = 0;
        for (int coin : coins) {
            count += input / coin;
            input %= coin;
        }

        System.out.println(count);
        reader.close();
    }
}
