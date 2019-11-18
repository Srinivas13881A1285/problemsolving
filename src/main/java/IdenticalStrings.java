import java.util.Arrays;
import java.util.List;

/**
 * TODO: Javadoc
 */
public final class IdenticalStrings {
    public static void main(String[] args) {

        List<String> listOne = Arrays.asList("A","B","C");
        List<String> listTwo = Arrays.asList("X","B","C");


       listOne.stream().filter(num -> listTwo.contains(num)).forEach(System.out::println);
        boolean b = listOne.stream().anyMatch(listTwo::contains);
        System.out.println("b = " + b);


    }

    private static boolean checkIfExists(String str,List<String> listTwo){
        return listTwo.contains(str);
    }
}