package alphabetinsubstring;

public class Alphabetinsubstring {

    public static void main(String[] args) {
        String str = "abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn";
        SmallestSubstring subStr = new SmallestSubstring();
        
        String thesubstr = subStr.smallestSubstringContainingTheAlphabet(str);
        
        System.out.println(thesubstr);
    }
}
