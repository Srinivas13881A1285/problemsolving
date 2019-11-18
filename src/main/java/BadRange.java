import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BadRange {
    public static void main(String[] args) {

        List<Integer> badNumbers = Arrays.asList(4,5);
        Collections.sort(badNumbers);
        int i = longestRange(badNumbers, 3, 48);
        System.out.println("i = " + i);
    }

    public static int longestRange(List<Integer> badNumbers, int l, int r) {
        int startElemInArr = 0;
        int endElemInArr = 0;
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < badNumbers.size(); i++) {
            if (l < badNumbers.get(i)) {
                startElemInArr = badNumbers.get(i);
                startIndex = i;
                break;
            }
        }
        for (int i = badNumbers.size() - 1; i >= 0; i--) {
            if (r > badNumbers.get(i)) {
                endElemInArr = badNumbers.get(i);
                endIndex = i;
                break;
            }
        }
//        System.out.println("startElemInArr = " + startElemInArr);
//        System.out.println("endElemInArr = " + endElemInArr);
        int maxRange = 0;
        maxRange = badNumbers.get(startIndex) - l + 1;
        for (int i = startIndex; i < endIndex; i++) {
            int diff = badNumbers.get(i + 1) - badNumbers.get(i);
            System.out.println("diff = " + diff);
            maxRange = Math.max(diff, maxRange);
        }
        maxRange = Math.max(r - badNumbers.get(endIndex) + 1, maxRange);
        return maxRange - 1;
    }
}
