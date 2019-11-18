import java.util.OptionalInt;
import java.util.stream.IntStream;

public class TheHurdleRace {
    public static void main(String[] args) {

    }

    public static int hurdleRace(int k, int[] heights) {
        int maxHeight = 0;
        int doses = 0;
        OptionalInt optionalMaxHeight = IntStream.of(heights).max();
        if (optionalMaxHeight.isPresent()) {
            maxHeight = optionalMaxHeight.getAsInt();
        }
        if (maxHeight > k && maxHeight != 0)
            doses = maxHeight - k;

        return doses;





    }
}
