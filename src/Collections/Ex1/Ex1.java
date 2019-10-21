package Collections.Ex1;

import java.util.Scanner;

public class Ex1 {

    private static int sumOn(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    private static int sumO1(int n) {
        return (n * (n + 1) / 2);
    }

    public static void main(String[] args) {
        int n = 0;
        Scanner sc;
        do {
            System.out.println("Nhap n: ");
            sc = new Scanner(System.in);
            n = sc.nextInt();
        } while (n <= 0);

        System.out.println("Tong voi do phuc tap O(n): " + sumOn(n));
        System.out.println("Tong voi do phuc tap O(1): " + sumO1(n));
    }
}
