package hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SequenceEquation {
    public static void main(String[] args)
    {
        int[] input = {2,3,1};
        int[] result = permutationEquation(input);
        System.out.println(Arrays.toString(result));
    }

    static int[] permutationEquation(int[] p) {
        int range = p.length;
        int[] answer = new int[range];
        List<Integer> numbers =  Arrays.stream(p).boxed().collect(Collectors.toList());
        for(int i = 1;i<=range;i++){
            int firsTime = numbers.indexOf(i)+1;
            int secondTime = numbers.indexOf(firsTime)+1;
            answer[i-1] = secondTime;
        }
        return answer;
    }
}
