import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryCoupons {
    public static void main(String[] args) {
        System.out.println(maxWinners(3));
    }

    public static int maxWinners(int n){
        Map<Integer,Long> collect = IntStream.rangeClosed(1, n).boxed()
                                            .collect(
                                                        Collectors.groupingBy(
                                                                                LotteryCoupons::sumOfCoupon,
                                                                Collectors.counting()));

        collect.entrySet().forEach(System.out::println);
        ArrayList<Long> arrayList = new ArrayList<>(collect.values());
        int frequency = Collections.frequency(arrayList, Collections.max(arrayList));
        return frequency;
    }

    private static Integer sumOfCoupon(int num) {
        int sum  = 0;
        while(num > 0){
            int digit = num%10;
            sum+=digit;
            num/=10;
        }
        return sum;
    }
}
