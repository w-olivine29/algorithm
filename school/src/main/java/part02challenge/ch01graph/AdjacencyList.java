package part02challenge.ch01graph;

import java.util.*;

// 구현 그래프.jpg 참고
public class AdjacencyList {
    public static void main(String[] args) {

        // 노드 번호: 0=A, 1=B, 2=C, 3=D, 4=E, 5=F, 6=G, 7=H
        // 현재 구현 예시는 ArrayList 로 구현해도 무방
        LinkedList<LinkedList<Integer>> graph = new LinkedList<>(List.of(
                new LinkedList<>(Arrays.asList(1, 3)),
                new LinkedList<>(Arrays.asList(2, 4)),
                new LinkedList<>(Arrays.asList(1)),
                new LinkedList<>(Arrays.asList(4, 6)),
                new LinkedList<>(Arrays.asList(5)),
                new LinkedList<>(Arrays.asList()),
                new LinkedList<>(Arrays.asList(7)),
                new LinkedList<>(Arrays.asList())
        ));

        System.out.println(getAdjacencyList(graph));
    }

    private static String getAdjacencyList(LinkedList<LinkedList<Integer>> graph) {
        StringBuilder sb = new StringBuilder();

        for (int start = 0; start < graph.size(); start++) {
            sb.append(start)
                    .append(" - ")
                    .append(graph.get(start))
                    .append("\n");
        }

        return sb.toString();
    }
}
