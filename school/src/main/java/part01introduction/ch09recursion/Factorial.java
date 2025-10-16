package part01introduction.ch09recursion;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("factorialLoop(10) = " + factorialLoop(10));
        System.out.println("factorialRecursive(10) = " + factorialRecursive(10));
    }

    private static int factorialRecursive(int num) {
        if(num == 0) return 1;

        return num * factorialRecursive(num - 1);
    }

    private static int factorialLoop(int num) {
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
