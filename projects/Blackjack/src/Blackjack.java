
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args){
        //variables
        final String[] suits = {"\u2660", "\u2666", "\u2665", "\u2663"};
        boolean playing = true;
        Scanner in = new Scanner(System.in);
        String inString;
        int inInt;
        int bet[] = new int[6];
        int tempMoney = 150;
        
        //object declaration
        Dealer dealer = new Dealer();
        Player player = new Player(150, 0);// = new Player(150);
        Deck deck;
        boolean dealerRes;
        
        //opening message
        for(int n = 0; n < 30; n++){
            System.out.print(suits[0] + suits[1] + suits[2] + suits[3]);
        }
        System.out.println("\n            Welcome to  Wallard Casino Blackjack!");
        for(int n = 0; n < 30; n++){
            System.out.print(suits[0] + suits[1] + suits[2] + suits[3]);
        }
        
        //number of decks
        System.out.println("");
        while(true){
           System.out.print("\nSingle or eight deck? (1/8)\n>");
           inString = in.nextLine().toLowerCase();
           if(inString.equals("1")){
               deck = new Deck(1);
               break;
           } else if(inString.equals("8")){
               deck = new Deck(8);
               break;
           } else {
               System.out.println("Sorry, please enter 1 or 8");
           }
        }
        deck.shuffle();
        
        //Game loop
        while(playing){
            try{
                tempMoney = player.getMoney();
            } catch(Exception e){
                tempMoney = 150;
            }
            //get number of hands
            while(true){
                System.out.print("\nHow many hands do you want to play? (1-6)\n>");
                try{
                    inInt = Integer.parseInt(in.next());
                    if(inInt < 1 || inInt > 6){
                        System.out.println("Must be between 1 and 6.");
                    } else {
                        break;
                    }
                }catch(Exception e){
                    System.out.println("Please enter a number.");
                }
            }
            player = new Player(tempMoney, inInt);
            
            //deal dealer
            dealer.clearHand(0);
            dealer.addCard(0, deck.dealCard());
            dealer.addCard(0, deck.dealCard());
            
            //bet
            for(int i = 0; i < player.getNumHands(); i++){
                while(true){
                    System.out.println("\nHand " + (i+1));
                    System.out.println("funds: $" + player.getMoney());
                    System.out.print("Enter bet (Multiple of 5, between 5 and 200)\n>");
                    try{
                        inInt = Integer.parseInt(in.next());
                        if(inInt%5!=0){
                            System.out.println("Bet must be a multiple of 5.");
                        } else if(inInt<5||inInt>200){
                            System.out.println("Bet must be between 5 and 200.");
                        } else if(inInt>player.getMoney()-(5*((player.getNumHands()-1)-i))){
                            System.out.println("Not enough money, you also have to bet remaining hands.");
                        } else if(inInt>player.getMoney()){
                            System.out.println("Insufficient funds.");
                        } else {
                            break;
                        }
                    } catch(Exception e){
                        System.out.println("Please enter a number.");
                        inInt = 0;
                    }
                }
                bet[i] = inInt;
                player.addFunds(-1*bet[i]);
            }
            
            //deal out hand
            for(int i = 0; i < player.getNumHands(); i++){
                player.clearHand(i);
                player.addCard(i, deck.dealCard());
                player.addCard(i, deck.dealCard());

                //print hand info

                if(!(dealer.getVal(0)==21&&dealer.getDouble(0))){
                    while(true){
                        if(player.getHandVal(i)==21&&player.getDouble(i)){
                            System.out.println("\nHand " + (i + 1) + ": Blackjack!");
                            break;
                        }

                        System.out.println("\nHand " + (i + 1));
                        System.out.println("Hand: " + player.handString(i));
                        System.out.println("Bet: " + bet[i]);

                        //Hand choices
                        System.out.print("\nChoose action:\nHit, Stay" + ((player.getDouble(i))?", Double":"") + "\n>");
                        inString = in.next().toLowerCase();
                        if(inString.equals("hit")){
                            player.addCard(i, deck.dealCard());
                        }
                        else if(inString.equals("stay")){
                            break;
                        }
                        else if(player.getDouble(i) && inString.equals("double")){
                            if(player.getMoney()>=bet[i]*2){
                                player.addCard(i, deck.dealCard());
                                System.out.println("Hand: " + player.handString(i));
                                break;
                            } else {
                                System.out.println("Sorry, not enough money.");
                            }
                        }
                        else {
                            System.out.println("Invalid choice");
                        }
                        if(player.getHandVal(i)>21){
                            break;
                        }
                    }
                }
            }
            
            //print result
            for(int n = 0; n < 30; n++){
                System.out.print(suits[0] + suits[1] + suits[2] + suits[3]);
            }
            System.out.println("\n            Results:");
            for(int n = 0; n < 30; n++){
                System.out.print(suits[0] + suits[1] + suits[2] + suits[3]);
            }
            
            
            for(int i = 0; i < player.getNumHands(); i++){
                System.out.println("Hand " + (i + 1) +":");
                System.out.println("Your hand: " + player.handString(i) + " (" + player.getVal(i) + ")");
                
                if(player.getHandVal(i)>21){
                    System.out.println("You busted!");
                } else if(player.getHandVal(i)==21&&player.getDouble(i)&&!(dealer.getDouble(0)&&dealer.getHandVal(0)==21)){
                    System.out.println("Blackjack!");
                    player.addFunds((bet[i]/2)*5);
                } else if(!(player.getHandVal(i)==21&&player.getDouble(i))&&dealer.getDouble(0)&&dealer.getHandVal(0)==21){
                    System.out.println("Dealer blackjack!");
                } else if(dealer.playDealer(deck)){
                    if(player.getHandVal(i)>dealer.getHandVal(0)){
                        System.out.println("You won!");
                        player.addFunds(2*bet[i]);
                    } else if(player.getHandVal(i)<dealer.getHandVal(0)){
                        System.out.println("You lost!");
                    } else {
                        System.out.println("Push!");
                        player.addFunds(bet[i]);
                    }
                } else {
                    System.out.println("Dealer busted!");
                    player.addFunds(2*bet[i]);
                }
                 
            }
            System.out.println("\nDealer hand: " + dealer.handString(0) + " (" + dealer.getVal(0) + ")\n");
            System.out.println("You now have $" + player.getMoney());
            
            //end loop
            while(true){
                System.out.print("\nCash out? (Y/N)\n>");
                inString = in.next().toLowerCase();
                if(inString.equals("y")){
                    playing = false;
                    break;                    
                } else if(inString.equals("n")){
                    break;
                } else {
                    System.out.println("Sorry, please enter Y or N.");
                }
            }
            deck.handleShuffle();
        }
    }
}
