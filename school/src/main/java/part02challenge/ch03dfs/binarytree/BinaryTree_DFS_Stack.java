package part02challenge.ch03dfs.binarytree;

import java.io.*;
import java.util.*;

public class BinaryTree_DFS_Stack {
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

        // 탐색
        ArrayList<Integer> result = new ArrayList<>();

        // 배열이 좀 더 확인하기가 용이해서 스택 대신 사용 (어파치 시간복잡도는 동일)
        // 참고로 스택으로 구현한 DFS 성능이 더 좋지만, 일반적으로 DFS는 스택 기반으로 구현하지 않는다. (재귀)
        ArrayList<Node> stack = new ArrayList<>();
        stack.add(root);

        preOrder(stack, result);
        System.out.println(N + " 전위운행 결과: "+ result);
    }

    private static void preOrder(ArrayList<Node> stack, ArrayList<Integer> result) {
        while (!stack.isEmpty()) {
            Node node = stack.get(stack.size() - 1); // 11버전은 getLast 존재 x
            stack.remove(stack.size() - 1);

            // visit: result.add
            result.add(node.value);

            // 후입선출이기때문에 오른쪽 먼저 넣기
            if(node.right != null){
                stack.add(node.right);
            }
            if(node.left != null){
                stack.add(node.left);
            }
        }
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
