import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Number of prime numbers: ");
        int num = scn.nextInt();
        int count = 0;
        int n = 2;
        while (count < num) {
            if (isPrime(n)) {
                System.out.print(n + " ");
                count++;
            }
            n++;
        }
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
