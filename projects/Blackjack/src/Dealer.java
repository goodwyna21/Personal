public class Dealer extends Person{
    public Dealer(){
        Hand[] hand = new Hand[1];
        hand[0] = new Hand();
        super.initHands(hand);
    }
}
