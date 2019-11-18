import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WorkSchedule {
    static List<Integer> characters = new ArrayList<>();
    static List<List<Integer>> allCombinations = new ArrayList<>();

    public static void main(String[] args) {
        int workHours = 24;
        int dayHours = 4;
        String pattern = "08??840";
//        List<String> allPatterns = findSchedule(workHours, dayHours, pattern);
//        System.out.println("allPatterns = " + allPatterns);

        workHours=56;
        dayHours=8;
        pattern="???8???";
        
        List<String> allPatterns = findSchedule(workHours,dayHours,pattern);
        System.out.println("allPatterns = " + allPatterns);
    }

    public static List<String> findSchedule(int workHours, int dayHours, String pattern) {
        int numOfHoursWorked = calNumOfHoursWorked(pattern, workHours);
        int remainHours = workHours - numOfHoursWorked;
        int numOfDaysToFill = calNumOfDaysToFill(pattern);
        return logic(remainHours, numOfDaysToFill, pattern, dayHours);
    }


    static void CombinationRepetitionUtil(int chosen[], int arr[],
                                          int index, int r, int start, int end) {
        // Since index has become r, current combination is
        // ready to be printed, print
        if (index == r) {
            for (int i = 0; i < r; i++) {
                characters.add(arr[chosen[i]]);
            }
            allCombinations.add(characters);
            characters.clear();
            return;
        }

        // One by one choose all elements (without considering
        // the fact whether element is already chosen or not)
        // and recur
        for (int i = start; i <= end; i++) {
            chosen[index] = i;
            CombinationRepetitionUtil(chosen, arr, index + 1,
                    r, i, end);
        }
        return;
    }

    // The main function that prints all combinations of size r
// in arr[] of size n with repitions. This function mainly
// uses CombinationRepetitionUtil()
    static void CombinationRepetition(int[] arr, int n, int r) {
        // Allocate memory
        int chosen[] = new int[r + 1];

        // Call the recursice function
        CombinationRepetitionUtil(chosen, arr, 0, r, 0, n - 1);
    }

    // Driver program to test above functions




    private static List<String> logic(int numOfHoursToPlan, int numOfDaysToFill, String pattern, int dayHours) {
        int sum = numOfHoursToPlan;
        int currLen = numOfDaysToFill;
        String collect = IntStream.rangeClosed(0, dayHours).boxed().map(String::valueOf).collect(Collectors.joining());
        //List<String> allCombinations = genAllCombinations(collect);


        int arr[]= new int[collect.length()];

        IntStream.rangeClosed(0,dayHours).toArray();
        int r = numOfDaysToFill;
        int n = arr.length;
        CombinationRepetition(arr, n, r);
        allCombinations.stream().forEach(System.out::println);
        List<String> collect1 = allCombinations.stream()
                .map(characters1 -> characters1.stream().map(Object::toString).collect(Collectors.joining())).collect(Collectors.toList());
        List<String> subStringsSatisfyingSum = subStringsSatisfySum(collect1, numOfHoursToPlan, numOfDaysToFill);
        System.out.println("subStringsSatisfyingSum = " + subStringsSatisfyingSum);
        List<String> outputPatterns = new ArrayList<>();
        for(String subString:subStringsSatisfyingSum){
            int j = 0;
            StringBuilder patternBuilder = new StringBuilder(pattern);
            for(int i =0;i<pattern.length();i++){
                if(pattern.charAt(i)=='?'){
                    patternBuilder.setCharAt(i,subString.charAt(j++));
                }
            }
            outputPatterns.add(patternBuilder.toString());
        }
       return outputPatterns;
    }

    private static List<String> subStringsSatisfySum(List<String> subStrings, int remainHours, int numOfDaysToFill) {
        List<String> collect = subStrings.stream()
                .filter(subString -> subString.length() == numOfDaysToFill)
                                            .filter(
                                                    subString -> sumEqualsReamingHours(subString,remainHours)
                                                )
              .peek(System.out::println)
                .map(Object::toString).
                        collect(Collectors.toList());
        return collect;
    }

    private static boolean sumEqualsReamingHours(String subString, int remainHours) {
        int sum = Arrays.stream(subString.split(""))
                .mapToInt(Integer::valueOf)
                .sum();
        System.out.println("sum = " + sum);
        return sum == remainHours;
    }

    private static List<String> genAllCombinations(String inputstring) {
        StringBuilder output = new StringBuilder();
        List<String> allCombos = new ArrayList<>();
        combine(0,inputstring,output,allCombos);
        return allCombos;
    }

    private static void combine(int start,String inputstring,StringBuilder output,List<String> allCombinations) {
        for (int i = start; i < inputstring.length(); ++i) {
            output.append(inputstring.charAt(i));
            allCombinations.add(output.toString());
            if (i < inputstring.length())
                combine(i + 1,inputstring,output,allCombinations);
            output.setLength(output.length() - 1);
        }
    }

    private static int calNumOfDaysToFill(String pattern) {
        long count = Arrays.stream(pattern.split("")).filter(ch -> ch.equals("?")).count();
        return (int) count;
    }

    private static int calNumOfHoursWorked(String pattern, int workHours) {
        int sum = Arrays.stream(pattern.split("")).filter(ch -> !ch.equals("?")).mapToInt(Integer::valueOf).sum();
        return sum;
    }
}
