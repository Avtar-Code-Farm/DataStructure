package Patterns.Subsets;

import java.util.ArrayList;
import java.util.List;

public class StringPermutationsChangingCase {
    public static void main(String[] args) {
        String str = "ab7c";
        List<String> ans = new ArrayList<>();

        String output = "";
        int index = 0;
        StringPermutationsChangingCase_fun(ans, str, output,index);
        System.out.println(ans.size());

    }

    private static void StringPermutationsChangingCase_fun(List<String> ans, String str, String output, int index) {
        if(output.length() == str.length()) ans.add(output);
        else {
            char ch = str.charAt(index);
            if(!Character.isAlphabetic(ch)) {
                output = output + ch;
                StringPermutationsChangingCase_fun(ans, str, output, index + 1);
            } else {
                // do permutation without changing the case of the later

                StringPermutationsChangingCase_fun(ans, str, output + ch, index + 1);

                // do permutation with changing the case of the later
                ch = Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
                output = output + ch;
                StringPermutationsChangingCase_fun(ans, str, output, index + 1);
            }
        }
    }
}
