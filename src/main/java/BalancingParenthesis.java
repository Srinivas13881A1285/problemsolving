import java.util.Stack;

public class BalancingParenthesis {
    public static void main(String[] args) {
        System.out.println(isBalanced("()"));
        System.out.println(isBalanced("()()()("));
    }

    public static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(')
                stack.push(ch);
            else {
                if (stack.isEmpty())
                    return false;

                char ch2 = stack.pop();
                if (ch == ')' && ch2 != '(' || ch == '}' && ch2 != '{' || ch == ']' && ch2 != '[')
                    return false;
            }
        }

        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
