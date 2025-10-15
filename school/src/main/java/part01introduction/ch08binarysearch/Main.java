package part01introduction.ch08binarysearch;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] sortedArr = {11, 22, 33, 44, 55, 66, 77, 88};

        System.out.println("myBinarySearch(sortedArr, 77) = " + myBinarySearch(sortedArr, 77));
        System.out.println("myBinarySearch(sortedArr, 100) = " + myBinarySearch(sortedArr, 100));
        System.out.println("myBinarySearch(sortedArr, 33) = " + myBinarySearch(sortedArr, 33));
    }

    private static int myBinarySearch(int[] sortedArr, int targetValue) {
        System.out.printf("\n%s -> %d 탐색\n", Arrays.toString(sortedArr), targetValue);

        int searchCount = 0;
        int left = 0, right = sortedArr.length - 1;

        // left가 역전되기 전까지 반복 (역전이 되었다는 것은 찾고자 하는 값이 없다는 것
        while (left <= right) {
            int mid = (left + right) / 2;

            System.out.printf("[%d 번째 탐색] left: %d, right: %d mid: %d\n", ++searchCount, left, right, mid);

            if (sortedArr[mid] == targetValue) {
                return mid;
            }

            // target이 더 작다면 탐색범위를 왼쪽으로 이동
            if (sortedArr[mid] > targetValue) {
                right = mid - 1;
                // target이 더 크다면 탐색범위를 오른쪽으로 이동
            } else if (sortedArr[mid] < targetValue) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
