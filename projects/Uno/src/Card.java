public class Card {
    private char rank;
    private String color;
    
    public Card(char r, String c){
        rank = r;
        color = c;
    }
    
    public String getColor(){
        return color;
    }
    
    public char getRank(){
        return rank;
    }
}
