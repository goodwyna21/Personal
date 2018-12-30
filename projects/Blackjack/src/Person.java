abstract public class Person {
    private Hand[] hand;
    
    public String toString(){
        return hand.toString();
    }
    
    public int getNumHands(){
        return hand.length;
    }
    
    public void initHands(Hand[] h){
        hand = h;
    }
    
    public Card getCard(int handIndex, int cardIndex){
        return hand[handIndex].getCard(cardIndex);
    }
    
    public boolean addCard(int handIndex, Card c){
        hand[handIndex].addCard(c);
        return(hand[handIndex].getVal()<=21);
    }
    
    public int getVal(int handIndex){
        return hand[handIndex].getVal();
    }
    
    public String handString(int handIndex){
        return hand[handIndex].toString();
    }
    
    public void clearHand(int handIndex){
        hand[handIndex].clear();
    }
    
    public boolean getSplit(int handIndex){
        return hand[handIndex].getSplit();
    }
    
    public int getNumCards(int handIndex){
        return hand[handIndex].getLength();
    }
    
    public boolean playDealer(Deck deck){
        while(hand[0].getVal() < 17){
            hand[0].addCard(deck.dealCard());
        }
        return hand[0].getVal()<=21;
    }
    
    public boolean getDouble(int handIndex){
        return (hand[handIndex].getLength()==2);
    }
    
    public int getHandVal(int handIndex){
        return hand[handIndex].getVal();
    }
}
