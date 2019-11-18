import java.util.stream.IntStream;

public class MagicVowels {
    public static void main(String[] args) {
        System.out.println(longSequence2("uaueoioaua"));
        System.out.println(longSequence2("aeiou"));
        System.out.println(longSequence2("aeio"));
        System.out.println(longSequence2("aeiaaioooaauuaeiou"));
        System.out.println(longSequence2("aeeiou"));
        System.out.println(longSequence2("aeaioua"));
    }

    public static int longSequence(String s) {
        int[] arr = new int[5];
        char prevChar = ' ';
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar > prevChar) {
                if (currChar == 'a')
                    arr[0]++;
                if (currChar == 'e')
                    arr[1]++;
                if (currChar == 'i')
                    arr[2]++;
                if (currChar == 'o')
                    arr[3]++;
                if (currChar == 'u')
                    arr[4]++;
                prevChar = currChar;
            }

        }

        return IntStream.of(arr).anyMatch(e -> e == 0) == true ? 0 : IntStream.of(arr).sum();
    }

    public static int longSequence2(String s){
        int[] arr = new int[5];
        for(int i=0;i<s.length();i++) {
            char currChar = s.charAt(i);
            if (currChar == 'a' && arr[1] == 0)
                arr[0]++;
            if (currChar == 'e' && arr[0] > 0 && arr[2] == 0)
                arr[1]++;
            if (currChar == 'i' && arr[1] > 0 && arr[3] == 0)
                arr[2]++;
            if (currChar == 'o' && arr[2] > 0 && arr[4] == 0)
                arr[3]++;
            if (currChar == 'u' && arr[3] > 0)
                arr[4]++;
        }
        return IntStream.of(arr).anyMatch(e -> e == 0) == true ? 0 : IntStream.of(arr).sum();
    }
}
