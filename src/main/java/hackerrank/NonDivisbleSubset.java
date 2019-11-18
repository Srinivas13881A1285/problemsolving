package hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NonDivisbleSubset {
    public static void main(String[] args) {
        int[] a = {1,7,2,4};
        int k = 4;
        int n = a.length;
        int maxLen = 1;
        int startIndex = 0;
        boolean[][] palindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            palindrome[i][i] = true;
        }


        for(int i = 0;i<n-1;i++){
            if(a[i]+a[i+1]%4!=0){
                palindrome[i][i+1]=true;
            }
        }

        for (int curr_len = 3; curr_len <= n; curr_len++) {
            for (int i = 0; i < n - curr_len + 1; i++) {
                int j = i + curr_len - 1;
                if (palindrome[i][j - 1] && ifNotDivByK(i, j, a, k)) {
                    palindrome[i][j] = true;
                    maxLen = curr_len;
                    startIndex = i;
                    for (int id = startIndex; id < startIndex + maxLen; id++) {
                        System.out.print(a[id]+" ");
                    }
                    System.out.println();
                }
            }
        }

        System.out.println("maxLen = " + maxLen);



    }

    private static boolean ifNotDivByK(int i, int j, int[] a, int k) {
        for (int ind = i; ind < j; ind++) {
            if ((a[ind] + a[j]) % k == 0)
                return false;
        }
        return true;
    }
}
