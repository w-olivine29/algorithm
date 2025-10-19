package part01introduction.ch10greedy;

import java.io.*;
import java.util.*;

/* 배낭 문제

배낭에 순도가 높은 금덩이 넣어가기
첫 줄에는 금덩이 개수와 배낭이 담을 수 있는 최대 무게가 주어진다.
두번 째 줄 부터는 금덩이 무게와 가치가 주어진다.

최대 무게만큼 금덩이를 최대한 담으려 한다.
이때 금덩이를 조합해서 만들 수 있는 최대 가치를 구하기
금덩이는 자를 수 있다.

입력 예시)
3 50
10 60
20 100
30 120

판단)
    - 금덩이는 자를 수 있으므로, "단가(가치/무게)"가 가장 높은 금부터 담는 것이 항상 유리.
      (지금의 선택이 이후 선택에 불리한 제약을 주지 않음 → 탐욕적 선택 속성 성립)

    - 한 금덩이를 일부 담고 남은 무게에 대해 같은 방식으로 반복 가능.
      즉, 큰 문제의 최적해가 작은 문제(남은 무게)의 최적해로 구성됨.
      (최적 부분 구조 성립)

결론)
    → 금덩이를 단가(가치/무게) 내림차순 정렬 후,
      배낭이 꽉 찰 때까지 순서대로 담는다.
      남는 무게가 있다면 마지막 금덩이는 일부만 담기.

예)
    (10,60) 단가=6
    (20,100) 단가=5
    (30,120) 단가=4
    순서: 10→20→(30 일부)
    결과: 240.0
*/

public class Backpack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N, backpack;
        List<Gold> golds = new ArrayList<>();

        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        backpack = Integer.parseInt(input[1]);

        for (int i = 0; i < N; i++) {
            String[] goldData = reader.readLine().split(" ");
            golds.add(new Gold(Integer.parseInt(goldData[0]), Integer.parseInt(goldData[1])));
        }
        golds.sort(null);
        System.out.println("golds = " + golds);

        int totalValue = 0;
        int remainWeight = backpack;
        for (Gold gold : golds) {

            // 금덩이 한 개의 무게가 배낭에 못 들어갈 경우 쪼개야함
            if (remainWeight / gold.weight == 0) {
                
                // 결과는 같음
                //totalValue += (gold.value * remainWeight) / gold.weight;
                //totalValue += (int)((gold.value / (double) gold.weight) * remainWeight);
                totalValue += (gold.value * remainWeight) / gold.weight;
                
                
                remainWeight -= remainWeight; // 사실 이 코드는 필요없음 (어차피 해당 조건에서 루프 종료)
                break;

            } else { // 온전하게 한 개 넣을 수 있는 경우
                totalValue += gold.value;
                remainWeight -= gold.weight;
            }
        }
        System.out.println("totalValue: " + totalValue);

        reader.close();
    }

    static class Gold implements Comparable<Gold> {
        int weight;
        int value;

        public Gold(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        // 단가(가치 / 무게) 기준 내림차순
        @Override
        public int compareTo(Gold another) {
            double thisCost = this.value / (double) this.weight;
            double anotherCost = another.value / (double) another.weight;

            return Double.compare(anotherCost, thisCost);
        }

        @Override
        public String toString() {
            return String.format("{무게: %d, 가치: %d, 단가: %.2f}", weight, value, (double) value / weight);
        }
    }
}
