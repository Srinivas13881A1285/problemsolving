import java.util.Arrays;

public class RemoveDuplicateElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,2,3};
        int n = arr.length;

        for (int i = 0; i <n  ; i++) {
            for(int j = i+1;j<n;){
                if(arr[i] == arr[j]){
                    for(int k = j;k<n-1;k++){
                        arr[k] = arr[k+1];
                    }
                    n--;
                }else
                    j++;
            }
        }

        for(int i = 0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
