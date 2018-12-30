class Player extends Person{
    private int money;
    
    public Player(int m, int nHands){
        money = m;
        Hand[] hands = new Hand[nHands];
        for(int n = 0; n < nHands; n++){
            hands[n] = new Hand();
        }
        
        super.initHands(hands);
    }
    
    public boolean addFunds(int n){
        money += n;
        return(money>0);
    }
    
    public int getMoney(){
        return money;
    }
}