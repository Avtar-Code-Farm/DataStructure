package Patterns.TwoPointer;

public class ComparingStringsContainingBackspaces {

    public static void main(String[] args) {
        boolean res;

        res = ComparingStringsContainingBackspaces_FUN("xp#", "xyz##");
        res = ComparingStringsContainingBackspaces_FUN("xy#z", "xyz#");
        res = ComparingStringsContainingBackspaces_FUN("xywrrmp", "xywrrmu#p");
        res = ComparingStringsContainingBackspaces_FUN("xy#z", "xzz#");
    }

    private static boolean ComparingStringsContainingBackspaces_FUN(String str1, String str2) {

        int ind1 = str1.length()-1;
        int ind2 = str2.length()-1;

        while(ind1 >= 0 || ind2 >= 0) {

            // the purpose of this call is to get the valid index after processing backspace in the given string
            ind1 = getValidIndexForComparision(str1, ind1);
            ind2 = getValidIndexForComparision(str2, ind2);

            // if both the strings are already processed
            if(ind1 < 0 && ind2 < 0 ) return true;

            // if one of them is not
            if(ind1 < 0 || ind2 < 0 ) return false;

            // if character is not matching => "ac" != "ab"
            if(str1.charAt(ind1) != str2.charAt(ind2))
                return false;

            ind1--; // reducing index to check rest of the string.
            ind2--;
        }

        return true;
    }

    private static int getValidIndexForComparision(String str, int index) {
        int skip_count = 0;

        while(index >= 0) {
            if(str.charAt(index) == '#') {
                skip_count++;
                index--;
            }
            else if(skip_count > 0) // it means we got string with # now we need to use the backspace
            {
                skip_count--; // decrement the skip since we used the backspace for the current index character
                index--;
            }
            else // Either no skip/backspace or we have already used it hence return back;
            {
                break;
            }
        }
        return index;
    }
}
