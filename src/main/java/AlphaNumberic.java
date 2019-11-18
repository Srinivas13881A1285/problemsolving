import java.util.Arrays;

public class AlphaNumberic {
    public static void main(String[] args) {
        String input = "He is a very good boy,isn't he?";
        String[] tokens = input.split("[^\\p{Alpha}]+");
        System.out.println(Arrays.toString(tokens));
    }
}
