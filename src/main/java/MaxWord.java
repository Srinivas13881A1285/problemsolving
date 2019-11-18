import java.util.*;
import java.util.stream.Stream;

public class MaxWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String sentences[] = input.split("\n|\\.(?!\\d)|(?<!\\d)\\.");
        Arrays.stream(sentences).forEach(System.out::println);
        Stream.of(sentences).peek(System.out::println).findFirst();
        Arrays.stream("srinivas".split("i")).forEach(System.out::println);


        Stream.of("srinivas".split("")).forEach(System.out::println);


        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int sum = numbers.stream().mapToInt(e -> e).sum();
        System.out.println("sum = " + sum);
        OptionalDouble average = numbers.stream().mapToInt(e -> e).average();
        System.out.println("average = " + average);

        IntSummaryStatistics intSummaryStatistics = numbers.stream().mapToInt(e -> e).summaryStatistics();
        intSummaryStatistics.getAverage();
        intSummaryStatistics.getCount();
        intSummaryStatistics.getMax();
        intSummaryStatistics.getMin();
        intSummaryStatistics.getSum();
    }
}
