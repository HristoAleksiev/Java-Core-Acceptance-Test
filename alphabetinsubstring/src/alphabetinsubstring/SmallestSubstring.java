package alphabetinsubstring;

import java.util.ArrayList;
import java.util.List;

public class SmallestSubstring {
    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private List<Character> bufferAlphabet = new ArrayList<>();
    public List<Element> shortestSubstring = new ArrayList<>();
    public List<List<Element>> substringVariants = new ArrayList<>();
    public List<List<Element>> substringVariantsEnhanced = new ArrayList<>();
    
    private void fillBufferAlphabet(){
        bufferAlphabet = new ArrayList<>();
        for (char letter : alphabet) {
            bufferAlphabet.add(letter);
        }
    }
    
    private boolean containsAlphabet(List<Element> str){
        for (Element element : str) {
            for (int i = 0; i < bufferAlphabet.size(); i++) {
                if (element.GetValue() == bufferAlphabet.get(i)) {
                    bufferAlphabet.remove(i);
                }
            }
        }
        boolean isEmpty = bufferAlphabet.isEmpty();
        fillBufferAlphabet();
        
        return isEmpty;
    }
    
    private List<Element> getOnlyLetters(String str){
        for (int i = 0; i < str.length(); i++) {
            if (isItALetterFromTheAlphabet(str.charAt(i))) {
                shortestSubstring.add(new Element(str.charAt(i), i));
            }
        }
        
        return shortestSubstring;
    }
    
    private void getAllListsWithAlphabet(String str){
        List<Element> onlyLetters = getOnlyLetters(str);
        fillBufferAlphabet();
        
        while(onlyLetters.size() >= alphabet.length){
            if (containsAlphabet(onlyLetters)) {
                substringVariants.add(deepCopy(onlyLetters));
            }
            onlyLetters.remove(0);
        }
    }
    
    private void enhanceSort(){
        for (int i = 0; i < substringVariants.size(); i++) {
            List<Element> list = substringVariants.get(i);
            while(list.size() >= alphabet.length){
                if (containsAlphabet(list)) {
                    substringVariantsEnhanced.add(deepCopy(list));
                }
                list.remove(list.size() - 1);
            }
        }
        substringVariants = substringVariantsEnhanced;
    }
    
    private List<Element> getShortestList(){
        List<Element> shortest = new ArrayList();
        int size = Integer.MAX_VALUE;
        
        for (List<Element> list : substringVariants) {
            for (List<Element> toCompare : substringVariants) {
                
//                printSubstring(list);
//                printSubstring(toCompare);
                
                if (list.size() <= size) {
                    shortest = list;
                    size = list.size();
                }
            }
        }
        return shortest;
    }
    
    public String smallestSubstringContainingTheAlphabet(String str){
        List<Element> shortest = new ArrayList();
        getAllListsWithAlphabet(str);
        enhanceSort();
        
        shortest = getShortestList();
        
        int begining = shortest.get(0).GetPosition();
        int end = shortest.get(shortest.size() - 1).GetPosition() + 1;
        
        return str.substring(begining, end);
    }
    
    private boolean isItALetterFromTheAlphabet(char letter){
        for (char element : alphabet) {
            if (letter == element) {
                return true;
            }
        }
        return false;
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
