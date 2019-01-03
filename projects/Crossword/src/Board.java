public class Board {
    private Square[][] board;

    public Board(boolean[][] blacks, char[][] letters){
        int cnt = 0;
        board = new Square[blacks.length][blacks[0].length];
        for(int y = 0; y < blacks[0].length; y++){
            for(int x = 0; x < blacks.length; x++){
                board[x][y] = new Square(blacks[x][y], letters[x][y], (labeled(x, y, blacks)?cnt+=1:0));
            }
        }
    }

    public boolean isCorrect(char guess, int x, int y){
      return board[x][y].isCorrect(guess);
    }

    public String toString(){
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";

        String tot = " ";
        for(int x = 0; x < board.length; x++){
            tot += ANSI_RED + "   " + ((x+1>=10)?"":" ") + (x + 1);
        }
        tot += "\n" + ANSI_RESET;
        int label;
        for(int y = 0; y < board[0].length; y++){
            tot += "  +";
            for(int x = 1; x <= board.length * 5; x++){
                tot += (x%5==0)?"+":"-";
            }
            tot += "\n" + ANSI_RED + (y + 1) + ((y+1 >= 10)?"":" ") + ANSI_RESET + "|";
            for(int x = 0; x < board.length; x++){
              label = board[x][y].getLabel();
              tot += ((!board[x][y].getBlack())?(((label!=0)?(ANSI_CYAN + label + ANSI_RESET):" ") + ((label>=10)?"":" ") + ((label>=100)?"":" ") + board[x][y].getLetter()):"####") + "|";
            }
            tot += "\n";
        }
        tot += "  +";
        for(int x = 1; x <= board.length * 5; x++){
            tot += (x%5==0)?"+":"-";
        }
        return tot;
    }

    public boolean checkWon(){
      boolean correct = true;
      for(int x = 0; x < board.length; x++){
        for(int y = 0; y < board[0].length; y++){
          if(!board[x][y].getIsBlack()){
            correct = (correct)?(board[x][y].getGuessed()):false;
          }
        }
      }
      return correct;
    }

    public boolean labeled(int x, int y, boolean[][] blacks){
        //System.out.println(x + " " + y);
        if(blacks[x][y]){
            return false;
        }
        if(x==0||y==0){
            return true;
        }
        return(blacks[x-1][y]||blacks[x][y-1]);
    }
}
