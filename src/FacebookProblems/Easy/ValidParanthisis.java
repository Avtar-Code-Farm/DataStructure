package FacebookProblems.Easy;

//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//
//
//Example 1:
//
//Input: s = "()"
//Output: true
//Example 2:
//
//Input: s = "()[]{}"
//Output: true
//Example 3:
//
//Input: s = "(]"
//Output: false

import java.util.Stack;

public class ValidParanthisis {
    public static void main(String[] args) {
        boolean isValid = false;
        isValid = isValidBracket("(){}[]");
        isValid = isValidBracket("(}[]");
        isValid = isValidBracket("([)]");
    }

    private static boolean isValidBracket(String s) {
        if(s.length() % 2 != 0 ) return false;

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '[' || ch == '{') stack.push(ch);
            else {
                if(ch == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
                else if(ch == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();
                else if(ch == '}' && !stack.isEmpty() && stack.peek() == '{') stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
