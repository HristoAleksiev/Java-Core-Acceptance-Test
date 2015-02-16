package alphabetinsubstring;

public class Alphabetinsubstring {

    public static void main(String[] args) {
        String str = "zzzazzzzzzzbcdefghijklmnopqrstuvwxyzzzzzzazzzza";
        SmallestSubstring subStr = new SmallestSubstring();
        
        
        String thesubstr = subStr.smallestSubstringContainingTheAlphabet(str);
//        subStr.printSubstring(subStr.shortestSubstring);
        
//        for (List<Element> element : subStr.substringVariants) {
//            subStr.printSubstring(element);
//        }
        
        System.out.println(thesubstr);
    }
}
