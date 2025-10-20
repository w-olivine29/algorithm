package part02challenge.ch01graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// 구현그래프(가중치).jpg 참고
public class AdjacencyList_Weighted {

    // 가중치가 있는 경우 따로 클래스를 만들기 (Pair, Node, Vertax 자유 선택)
    static class Node {
        int v; // 현재 번호
        int w; // 가중치

        public Node(int value, int weight) {
            v = value;
            w = weight;
        }

        @Override
        public String toString() {
            return String.format("{v=%d, w=%d}", v, w);
        }
    }

    public static void main(String[] args) {
        // 노드 번호: 0=A, 1=B, 2=C, 3=D, 4=E, 5=F, 6=G, 7=H
        // 현재 구현 예시는 ArrayList 로 구현해도 무방
        LinkedList<LinkedList<Node>> graph = new LinkedList<>(List.of(
                new LinkedList<>(Arrays.asList(new Node(1, 3), new Node(3, 4))),
                new LinkedList<>(Arrays.asList(new Node(2, 1), new Node(4, 2))),
                new LinkedList<>(Arrays.asList(new Node(1, 7))),
                new LinkedList<>(Arrays.asList(new Node(4, 8), new Node(6, 5))),
                new LinkedList<>(Arrays.asList(new Node(5, 9))),
                new LinkedList<>(Arrays.asList()),
                new LinkedList<>(Arrays.asList(new Node(7, 6))),
                new LinkedList<>(Arrays.asList())
        ));

        System.out.println(getAdjacencyList(graph));
    }


    private static String getAdjacencyList(LinkedList<LinkedList<Node>> graph) {
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
