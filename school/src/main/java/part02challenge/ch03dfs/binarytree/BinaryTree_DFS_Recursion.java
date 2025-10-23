package part02challenge.ch03dfs.binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 실제로 DFS 알고리즘 풀이할때, 거의 재귀로 구현하게 될 것이기때문에 훨씬 중요
public class BinaryTree_DFS_Recursion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        reader.close();

        // 트리 자료 구조를 쉽게 만들기 위해 먼저 배열에 넣어놓기
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nodes.add(new Node(i));
        }

        // 트리 만들기
        Node root = nodes.get(0);

        for (int current = 0; current <= (N - 1) / 2; current++) { // 왼쪽 자식이 있을 때까지만
            int left = current * 2 + 1;
            int right = current * 2 + 2;

            if (left < N) nodes.get(current).left = nodes.get(left);
            if (right < N) nodes.get(current).right = nodes.get(right);
        }

        // 탐색 결과
        ArrayList<Integer> result = new ArrayList<>();

        preOrder(root, result);
        System.out.println(N + " 전위운행 결과: " + result);
    }

    public static void preOrder(Node node, List<Integer> result) {
        if (node == null) return;

        result.add(node.value);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }

    public static void inOrder(Node node, List<Integer> result) {
        if (node == null) return;

        preOrder(node.left, result);
        result.add(node.value);
        preOrder(node.right, result);
    }

    public static void postOrder(Node node, List<Integer> result) {
        if (node == null) return;
        preOrder(node.left, result);
        preOrder(node.right, result);
        result.add(node.value);
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
