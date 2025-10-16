package part01introduction.ch09recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedArr = {1, 3, 5, 7, 9, 11, 13};
        int target = 11;

        int resultIndex1 = binarySearchLoop(sortedArr, target);
        System.out.println("resultIndex1 = " + resultIndex1);

        int resultIndex2 = binarySearchRecursive(sortedArr, target, 0, sortedArr.length - 1);
        System.out.println("resultIndex2 = " + resultIndex2);
    }

    private static int binarySearchRecursive(int[] sortedArr, int target, int left, int right) {
        // 탈출 조건식1
        if (left > right) return -1;

        int mid = (left + right) / 2;

        // 탈출 조건식2
        if (sortedArr[mid] == target) return mid;

        if (sortedArr[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
        return binarySearchRecursive(sortedArr, target, left, right);
    }

    private static int binarySearchLoop(int[] sortedArr, int target) {
        int left = 0, right = sortedArr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (sortedArr[mid] == target) {
                return mid;
            }

            if (sortedArr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
