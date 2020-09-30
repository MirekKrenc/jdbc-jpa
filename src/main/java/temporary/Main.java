package temporary;

import static java.lang.System.out;

public class Main {

    static int largest = 0 ;
    static int index = 0;

    public static void main(String[] args) {

        String s = "AAAAAAAAAAAAAAAAA";
        int i = 10;
        int j = 11;

        findPalindrome(s);
    }

    static void findPalindrome(String s) {

        for (int i=0; i<s.length(); i++) {
            findmirror(s, i, i);
            findmirror(s, i, i+1);
        }
        out.println(s.substring(index, index + largest));

    }

    private static void findmirror(String s, int start, int end) {

        while(start>=0 && end<s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (largest < end - start -1) {
            largest = end - start - 1;
            index = start + 1;
        }
    }

}