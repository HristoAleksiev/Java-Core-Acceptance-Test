package alphabetinsubstring;

public class Element {
    private char value;
    private int position;
    
    public int GetPosition(){
        return this.position;
    }
    
    public char GetValue(){
        return this.value;
    }
    
    public Element(char letter, int position){
        this.value = letter;
        this.position = position;
    }
}
