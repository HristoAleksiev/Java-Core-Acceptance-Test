package alphabetinsubstring;

import java.util.ArrayList;
import java.util.List;

public class SmallestSubstring {
    private final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private List<Character> bufferAlphabet = new ArrayList<>();
    public List<Element> shortestSubstring = new ArrayList<>();
    public List<List<Element>> substringVariants = new ArrayList<>();
    public List<List<Element>> substringVariantsEnhanced = new ArrayList<>();
    
    public String smallestSubstringContainingTheAlphabet(String str){
        List<Element> shortest;
        getAllListsWithAlphabet(str);
        shortest = getShortestList(substringVariants);
        int begining = shortest.get(0).GetPosition();
        int end = shortest.get(shortest.size() - 1).GetPosition() + 1;
        return str.substring(begining, end);
    }
    
    //  Iterates through all posible substrings excluding characters
    //  from the beggining of the string
    private void getAllListsWithAlphabet(String str){
        List<Element> onlyLetters = getOnlyLetters(str);
        fillBufferAlphabet();
        
        while(onlyLetters.size() >= alphabet.length){
            if (containsAlphabet(onlyLetters)) {
                substringVariants.add(getShortestVariant(deepCopy(onlyLetters)));
            }
            onlyLetters.remove(0);
        }
    }
    
    //  For each posible substring from "getAllListsWithAlphabet()" returns
    //  its shortest variant excluding characters from the end of the string
    private List<Element> getShortestVariant(List<Element> pot){
            while(pot.size() >= alphabet.length){
                if (containsAlphabet(pot)) {
                    substringVariantsEnhanced.add(deepCopy(pot));
                }
                pot.remove(pot.size() - 1);
            }
            return getShortestList(substringVariantsEnhanced);
    }
    
    //  Returns a List with the characters of the string; 
    //  only letters from the alphabet
    private List<Element> getOnlyLetters(String str){
        for (int i = 0; i < str.length(); i++) {
            if (isItALetterFromTheAlphabet(str.charAt(i))) {
                shortestSubstring.add(new Element(str.charAt(i), i));
            }
        }
        
        return shortestSubstring;
    }
    
    private boolean isItALetterFromTheAlphabet(char letter){
        for (char element : alphabet) {
            if (letter == element) {
                return true;
            }
        }
        return false;
    }
    
    private boolean containsAlphabet(List<Element> str){
        for (Element element : str) {
            for (int i = 0; i < bufferAlphabet.size(); i++) {
                if (element.GetValue() == bufferAlphabet.get(i)) {
                    bufferAlphabet.remove(i);
                    break;
                }
            }
        }
        boolean isEmpty = bufferAlphabet.isEmpty();
        fillBufferAlphabet();
        return isEmpty;
    }
    
    private void fillBufferAlphabet(){
        bufferAlphabet = new ArrayList<>();
        for (char letter : alphabet) {
            bufferAlphabet.add(letter);
        }
    }
    
    private List<Element> getShortestList(List<List<Element>> listOfLists){
        List<Element> shortest = new ArrayList<>();
        int size = Integer.MAX_VALUE;
        for (List<Element> list : listOfLists) {
                if (list.size() <= size) {
                    shortest = list;
                    size = list.size();
                }
        }
        return shortest;
    }
    
    private List<Element> deepCopy(List<Element> list){
        List<Element> newList = new ArrayList<>();
        for (Element element : list) {
            newList.add(element);
        }
        return newList;
    }
    
    public void printSubstring(List<Element> list){
        for (int i = 0; i < list.size(); i++) {
            if (i != list.size() - 1) {
                System.out.print(list.get(i).GetValue() + ", ");
            }
            else{
                System.out.println(list.get(i).GetValue());
            }
        }
    }
}
