import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RemoveDuplicateWords {

    public static void main(String[] args) {
        String regex = "(\\b\\w+\\b)(\\s+\\1\\b)+";
        String input = "srinivas srinivas test remove remove";

        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()){
            input = input.replaceAll(matcher.group(),matcher.group(1));
        }

        System.out.println(input);
    }
}
