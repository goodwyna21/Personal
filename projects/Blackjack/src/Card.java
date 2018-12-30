public class Card {
    private int val;
    private char rank;
    private int suit; //0 = spade, 1 = diamond, 2 = heart, 3 = club
    
    public Card(char r, int s, char[] ranks){
        rank = r;
        suit = s;
        val = new String(ranks).indexOf(r) + 1;
        val = (val!=1)?((val>10)?10:val):11;
    }
    
    public int getVal(){
        return val;
    }
    
    public void setVal(int n){
        val = n;
    }
    
    public char getRank(){
        return rank;
    }
    
    public int getSuit(){
        return suit;
    }
    
    public String toString(){
        String[] suits = {"\u2660", "\u2666", "\u2665", "\u2663"};
        return rank + suits[suit];
    }
}
