import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DistinctPairs {
    public static void main(String[] args) {
        System.out.println(distinctPairs(Arrays.asList(1,2,3,6,7,8,9,1),10));
        System.out.println(distinctPairs(Arrays.asList(1,3,46,1,3,9),47));
    }

    public static int distinctPairs(List<Integer> a, long k) {
        int[] arr = a.stream().mapToInt(Integer::intValue)
                .sorted().toArray();

        int i = 0;
        int j = arr.length-1;
        int distinctPairsCount = 0;
        while(i < j){
            if(arr[i]+arr[j]==k){
                distinctPairsCount++;
                i=findNextIndex(arr,i);
                j=findPreviousIndex(arr,j);
            }else if(arr[i]+arr[j]<k){
                i=findNextIndex(arr,i);
            }
            else
            {
                j=findPreviousIndex(arr,j);
            }
        }
        return distinctPairsCount;
    }

    private static int findPreviousIndex(int[] arr, int j) {
        while(arr[j]==arr[j-1])
            j--;
        j--;
        return j;
    }

    private static int findNextIndex(int[] arr, int i) {
        while(arr[i]==arr[i+1])
            i++;
        i++;
        return i;
    }
}
