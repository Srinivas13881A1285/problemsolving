import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SellingProducts {
    public static void main(String[] args) {
        List<Integer> ids = Arrays.asList(1, 1, 1, 1);
        int m = 2;
        System.out.println(minNumIds(ids,m));
    }

    public static int minNumIds(List<Integer> ids, int m) {
        Map<Integer, Long> collect = ids.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        ArrayList<Long> values = new ArrayList<>(collect.values());
        Collections.sort(values);
        long numOfDelValues = 0;
        for(int i = 0; i< values.size();i++){
            long value = values.get(i);
            if(m >= value){
                m= (int) (m  - value);
                numOfDelValues++;
            }
        }
        return (int) (collect.size()-numOfDelValues);
    }

    private static Long deleteFromM(Long value,int deletion){
        long remainValue = 0;

        if(deletion > value){
             remainValue = deletion - value;
        }

        return remainValue;
    }


}
