package part02challenge.ch01graph;

import java.util.*;

// 구현 그래프.jpg 참고
public class AdjacencyMatrix {
    public static void main(String[] args) {
        // 무한 정의 (연결이 안된 것에 사용)
        // 문제에서 제시하는 상한치보다 큰 값이어야함 (너무 큰 수인 경우 무한끼리 더할 때 오버플로우 발생)
        final int INF = 987654321;

        // 노드가 8개인 상황
        // A노드 (첫번째 행) 을 1번 요소로 잡는 경우, 0번 요소에 null 로 초기화
        // 0번 부터 시작해도 되지만, 1번부터 시작하는걸로 풀이해야 편리한 경우가 많음 (다만 열 개수랑 달라지니까 이 점 유의)
        // 노드 수(행 개수)는 고정되어 변경되지 않으므로, 외부 리스트는 불변으로 유지해도 무방
        List<List<Integer>> graph = new ArrayList<>(List.of(
                null,
                //                            | A | B | C | D | E | F | G | H |
                new ArrayList<>(Arrays.asList(INF, 1, INF, 1, INF, INF, INF, INF)), //A
                new ArrayList<>(Arrays.asList(INF, INF, 1, INF, 1, INF, INF, INF)), //B
                new ArrayList<>(Arrays.asList(INF, 1, INF, INF, INF, INF, INF, INF)), //C
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, 1, INF, 1, INF)), //D
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, 1, INF, INF)), //E
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, INF, INF, INF)), //F
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, INF, INF, 1)), //G
                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, INF, INF, INF)) //H
        ));

        System.out.println(getAdjacencyMatrix(graph, INF));
    }

    private static String getAdjacencyMatrix(List<List<Integer>> graph, int INF) {
        StringBuilder sb = new StringBuilder();

        for (List<Integer> row : graph) {
            if (row == null) continue;

            for (int j = 0; j < row.size(); j++) {
                int vertex = row.get(j);
                sb.append((vertex == INF) ? "INF" : String.format(" %d ", vertex));
                if (j < row.size() - 1) sb.append(", ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
