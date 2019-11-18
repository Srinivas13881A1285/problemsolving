import java.util.stream.LongStream;

public class Factorsof3and5 {
    public static void main(String[] args) {
        System.out.println(getIdealNums(1, 15));
    }

    public static long getIdealNums(long l, long r) {
        long count = LongStream.rangeClosed(l, r).
                filter(Factorsof3and5::checkIfFactor3).peek(System.out::println).count();
        System.out.println("count = " + count);
        return count;

    }

    private static boolean checkIfFactor(long l) {
        while (l % 3 == 0)
            l = l / 3;

        if (l == 0 || l == 1)
            return true;

        while (l % 5 == 0)
            l = l / 5;

        if (l == 0 || l == 1)
            return true;

        return false;
    }

    public static boolean checkIfFactor2(long l) {
        if ((l % 3 == 0 && l % 5 == 0 && l % 2 != 0) || (l % 3 == 0 && l % 2 != 0) || (l % 5 == 0 && l % 2 != 0) || (l == 1))
            return true;
        return false;
    }


    public static boolean checkIfFactor3(long l) {

        if (l == 1)
            return true;

        int[] primeNumbers = {2,7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,97};


        for (int i = 0; i <primeNumbers.length; i++) {

            if(primeNumbers[i] > l/2)
                break;
                if (l % primeNumbers[i] == 0)
                    return false;
        }

        if ((l % 3 == 0 && l % 5 == 0) || (l % 3 == 0) || (l % 5 == 0))
            return true;

        return false;
    }


}
