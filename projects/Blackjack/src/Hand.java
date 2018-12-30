
import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand; 
    
    public Hand(){
        hand = new ArrayList<Card>();
    }
    
    public void addCard(Card c){
        hand.add(c);
    }
    
    public Card getCard(int cardIndex){
        return hand.get(cardIndex);
    }
    
    public void clear(){
        while(hand.size()>0){
            hand.remove(0);
        }
    }
    
    public int getLength(){
        return hand.size();
    }
    
    public int getVal(){
        handleAces();
        int tot = 0;
        for(int i = 0; i<hand.size(); i++){
            tot += hand.get(i).getVal();
        }
        return tot;
    }
    
    private int calcTotal(){
        int tot = 0;
        for(int i = 0; i<hand.size(); i++){
            tot += hand.get(i).getVal();
        }
        return tot;
    }
    
    public void handleAces(){
        for(int i = 0; i < hand.size(); i++){
            if(calcTotal()>21){
                if(hand.get(i).getRank() == 'A'){
                    hand.get(i).setVal(1);
                }
            }
        }
    }
    
    public String toString(){
        String str = "";
        for(int i = 0; i<hand.size(); i++){
            str = str + hand.get(i).toString() + " ";
        }
        return (!hand.isEmpty())?str:"Empty hand";
    }
    
    public boolean getSplit(){
        return(hand.size()==2 && hand.get(0).getRank() == hand.get(1).getRank());
    }
}