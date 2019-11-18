import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SumofFirstNPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter range :");
        int range = scanner
                .nextInt();
        int count = 0;
        int num = 2;
        boolean isPrime = true;
        int total = 0;

        while (count < range) {
            if (isPrime(num)) {
                count++;
                total = total + num;
            }
            num++;
        }
        System.out.println("total = " + total);


        int answer = primeNumbersSum(range);
        System.out.println("answer = " + answer);
    }


    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static int primeNumbersSum(int n) {
        return IntStream.iterate(2, SumofFirstNPrime::incrementByOne).
                filter(SumofFirstNPrime::isPrime).
                limit(n).
                sum();

    }

    public static int incrementByOne(int num){
        return num+1;
    }
}


