package part02challenge.ch02tree;

import java.util.*;

public class BinaryTree_List {
    public static void main(String[] args) {
        ArrayList<Integer> tree = new ArrayList<>(Arrays.asList(
                5, 4, 10, 15, 1, 20, 8, null, null, 3, 9, null, null, null, 12
        ));

        // 타깃의 자식이 리스트의 범위를 넘어가지 않도록 하기
        for (int target = 0; target * 2 + 2 < tree.size(); target++) {

            // target의 자식노드 인덱스 구하기
            int left = target * 2 + 1;
            int right = target * 2 + 2;
            
            System.out.println(tree.get(target));
            System.out.println(tree.get(left));
            System.out.println(tree.get(right));
        }
    }
}
