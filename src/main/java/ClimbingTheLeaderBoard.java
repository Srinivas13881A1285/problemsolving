import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class ClimbingTheLeaderBoard {
    public static void main(String[] arg){
        int[] scores = {100,100,50,40,20,10};
        int[] alice = {50,65,77,90,102};
        climbingLeaderBoard(scores,alice);
    }

    public static int[] climbingLeaderBoard(int[] scores,int[] alice){
        int[] aliceRanks = new int[alice.length];
        int[] ints = Arrays.stream(scores).distinct().toArray();


        boolean b = Arrays.stream(scores).anyMatch(num -> num == 100);
        System.out.println("b = " + b);
        System.out.println(Arrays.toString(ints));


        String s = Arrays.toString(ints);

        List<Integer> numbers = Arrays.asList(1,2);
        String s1 = numbers.toString();
        System.out.println("s1 = " + s1);


        ExecutorService executorService = Executors.newSingleThreadExecutor();


        Runnable task = ()->{
            System.out.println("Thread executed!!");
        };

        executorService.submit(task);
        System.out.println(executorService.isShutdown());
        executorService.shutdown();
        executorService.isShutdown();

        System.out.println(executorService.isShutdown());



//        Set<Integer> distinctScores = new LinkedHashSet<>();
//       // HashSet<Integer> input  = Arrays.stream(scores).map(Integer::valueOf).collect(Collectors.toSet());
//        for (int j=0;j<alice.length;j++) {
//            int score = alice[j];
//            int rank = 1;
//            int i=0;
//            while (i < scores.length) {
//                if (scores[i] <= score) break;
//                i++;
//                rank++;
//            }
//            aliceRanks[j] = rank;
//        }
        return aliceRanks;
    }
}
