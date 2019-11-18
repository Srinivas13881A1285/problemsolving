import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombofPhone {

    Map<String,String> phone = new HashMap<String,String>(){{
        put("2","abc");
        put("3","def");
        put("4","ghi");
        put("5","jkl");
        put("6","mno");
        put("7","pqrs");
        put("8","tuv");
        put("9","wxyz");
    }};

    List<String> output = new ArrayList<>();

    public static void main(String[] args) {

    }

    public static void backTrack(String combination,String next_digits){

    }
}
