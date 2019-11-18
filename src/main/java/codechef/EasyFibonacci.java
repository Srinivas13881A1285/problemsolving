package codechef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EasyFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        int[] testCases = new int[numTestCases];
        for (int i =0;i<numTestCases;i++) {
            int range = scanner.nextInt();
            List<Integer> fibbonacci = findFibbonacci(range);
            if(fibbonacci.size()%2==0)
                System.out.println(fibbonacci.get(fibbonacci.size()-1));
            else
                System.out.println(fibbonacci.get(fibbonacci.size()-2));
        }
    }

    private static List<Integer> findFibbonacci(int range) {
        int f1 = 0,f2 = 1;
        List<Integer> fibList = new ArrayList<>();
        if(range ==0)
            return fibList;
        if(range == 1){
            fibList.add(f1);
            return fibList;
        }
        fibList.add(f1);
        fibList.add(f2);
        for(int i = 0; i<range-2;i++){
            int f = f1+f2;
            fibList.add(f%10);
            f1 = f2;
            f2 = f;
        }
        return fibList;
    }


}
