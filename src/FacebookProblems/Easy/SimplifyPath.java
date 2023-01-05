package FacebookProblems.Easy;

import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class SimplifyPath {
    // Given an absolute path for a file (Unix-style), simplify it. Note that absolute path always begin with ‘/’ ( root directory ), a dot in path represent current directory and double dot represents parent directory.
    //
    //Examples:
    //
    //"/a/./"   --> means stay at the current directory 'a'
    //"/a/b/.." --> means jump to the parent directory
    //              from 'b' to 'a'
    //"////"    --> consecutive multiple '/' are a  valid
    //              path, they are equivalent to single "/".
    //
    //Input : /home/
    //Output : /home
    //
    //Input : /a/./b/../../c/
    //Output : /c
    //
    //Input : /a/..
    //Output:/
    //
    //Input : /a/../
    //Output : /
    //
    //Input : /../../../../../a
    //Output : /a
    //
    //Input : /a/./b/./c/./d/
    //Output : /a/b/c/d
    //
    //Input : /a/../.././../../.
    //Output:/
    //
    //Input : /a//b//c//////d
    //Output : /a/b/c/d
    public static void main(String[] args) {
        String input = "/a/./b/./c/../d/";  // /a/b/d
        String res = ProcessInput(input);

    }

    private static String ProcessInput(String input) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        String[] portion = input.split("/");

        for(int i = 0; i < portion.length; i++) {
            if(!stack.isEmpty() && portion[i].equals("..")) stack.pop();
            else if(!portion[i].equals("") && !portion[i].equals(".") && !portion[i].equals("..")) stack.push(portion[i]);
        }

        if(stack.isEmpty()) return "/";
        Stack<String> temp = new Stack<>();
        while(!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        while(!temp.isEmpty()) {
            result.append("/" + temp.pop());
        }
        return result.toString();
    }




}
