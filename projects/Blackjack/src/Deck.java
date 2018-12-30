
import java.util.Random;

public class Deck {
    private Card[] deck;
    private int cardPointer;
    
    public Deck(int n){
        deck = new Card[52 * n];
        cardPointer = 0;
        char[] ranks = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int s = 0; s < 4; s++){
                for(char r : ranks){
                    deck[cnt] = new Card(r, s, ranks);
                    cnt++;
                }
            }
        }
    }
    
    public void printDeck(){
        for(int i = 0; i < deck.length; i++){
            System.out.println(deck[i]);
        }
    }
    
    public Card dealCard(){
        Card ret = deck[cardPointer];
        cardPointer++;
        return ret;
    }
    
    public void handleShuffle(){
        if(deck.length == 52){
            shuffle();
        } else if(cardPointer > (3 * deck.length / 4)){
            shuffle();
        }
    }
    
    public void shuffle(){
        cardPointer = 0;
        Random rgen = new Random();  // Random number generator			
        for (int i=0; i<deck.length; i++) {
            int randomPosition = rgen.nextInt(deck.length);
            Card temp = deck[i];
            deck[i] = deck[randomPosition];
            deck[randomPosition] = temp;
        }
    }
    
    public int getNumDecks(){
        return (int)(deck.length / 52);
    }
}
