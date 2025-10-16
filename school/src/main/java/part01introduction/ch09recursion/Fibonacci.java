package part01introduction.ch09recursion;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println("fibonacciLoop(10) = " + fibonacciLoop(10));
        System.out.println("fibonacciRecursive(10) = " + fibonacciRecursive(10));
    }

    // 해당 방식은 내부에서 중복되는 로직을 수행하게 됨 (개선: 메모이제이션 활용 필요)
    private static int fibonacciRecursive(int num) {
        if (num <= 1) return num;

        return fibonacciRecursive(num - 1) + fibonacciRecursive(num - 2);
    }


    private static int fibonacciLoop(int num) {

        if (num <= 1) return num;

        int prev = 0, current = 1;
        for (int i = 2; i <= num; i++) {
            int next = prev + current;
            prev = current;
            current = next;
        }
        return current;
    }

}
