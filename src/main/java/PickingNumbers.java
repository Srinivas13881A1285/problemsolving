import java.security.SecureRandom;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PickingNumbers {
    public static void main(String[] args) {
        int i = pickingNumbers(Arrays.asList(4, 4, 4));
        System.out.println("i = " + i);
        SecureRandom secureRandom = new SecureRandom();

        System.out.println("RAndom numbers between 1 and 5");
        Map<Integer, Long> map = secureRandom.ints(100, 1, 6)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        map.entrySet().forEach(System.out::println);
    }

    public static int pickingNumbers(List<Integer> a) {


        TreeMap<Integer, Long> map = a.stream()
                .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));

        int max = 0;

        ArrayList<Integer> arrayList = new ArrayList<>(map.keySet());

//        arrayList.forEach(System.out::print);


        if (arrayList.size() == 1) {
            int key = arrayList.get(0);
            Long aLong = map.get(key);
            return Math.toIntExact(aLong);
        }

        for (int i = 0; i < arrayList.size() - 1; i++) {
            int currKey = arrayList.get(i);
            int nextKey = arrayList.get(i + 1);
            max = (int) Math.max(max, map.get(currKey));
            if (nextKey - currKey == 1) {
                int sum = (int) (map.get(currKey) + map.get(nextKey));
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}
