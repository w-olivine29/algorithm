package part02challenge.ch02tree;

import java.util.*;

public class BinaryTree_Node {
    public static void main(String[] args) {
        Node root = new Node(5);

        root.left = new Node(1);
        root.right = new Node(2);

        root.left.left = new Node(15);
        root.left.right = new Node(1);

        root.right.left = new Node(20);
        root.right.right = new Node(8);

        root.left.right.left = new Node(3);
        root.left.right.right = new Node(9);

        root.right.right.right = new Node(12);

        // 너비 우선 순회
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int order = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node left = current.left;
            Node right = current.right;


            System.out.printf("[%d] current: %3d, left: %3d, right: %3d\n",
                    order++,
                    current.value,
                    (left != null ? left.value : null),
                    (right != null ? right.value : null)
            );

            if (left != null) queue.offer(current.left);
            if (right != null) queue.offer(current.right);
        }
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

}
