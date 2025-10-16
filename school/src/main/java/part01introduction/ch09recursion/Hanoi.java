package part01introduction.ch09recursion;

public class Hanoi {

    public static void main(String[] args) {
        hanoi(3, 'A', 'C', 'B');
    }

    private static void hanoi(int n, char from, char to, char temp) {
        if (n == 1) {
            System.out.printf("원반 1을 %c에서 %c(으)로 이동%n", from, to);
            return;
        }
        hanoi(n - 1, from, temp, to);
        System.out.printf("원반 %d을 %c에서 %c(으)로 이동%n", n, from, to);
        hanoi(n - 1, temp, to, from);
    }
}




