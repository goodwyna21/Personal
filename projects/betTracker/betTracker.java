import java.util.*;

public class betTracker{

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int starting_bet = Integer.parseInt(args[0]);
    String[] names = null;
    try{
      names = new String[Integer.parseInt(args[1])];
      for(int i = 0; i < names.length; i++){
        names[i] = "player " + (i + 1);
      }
    }catch(NumberFormatException e){
      names = new String[args.length - 1];
      for(int i = 0; i < names.length; i++){
        names[i] = args[i + 1];
      }
    }catch(Exception e){
      System.out.println(e);
    }

    int[] balances = new int[names.length];
    for(int i = 0; i < balances.length; i++){
      balances[i] = starting_bet;
    }

    while(true){
      printTotals(names, balances);

    }
  }


  public static void printTotals(String[] names, int[] balances){
    String[] colors = {
      "\u001B[31m",
      "\u001B[32m",
      "\u001B[33m",
      "\u001B[34m",
      "\u001B[35m",
      "\u001B[36m",
      "\u001B[37m"
    };

    int gap_length = 0;

    for(int n = 0; n < 100; n++){
      System.out.println();
    }

    for(int i = 0; i < names.length; i++){
      if(names[i].length() > gap_length){
        gap_length = names[i].length();
      }
    }
    for(int i = 0; i < names.length; i++){
      System.out.print(colors[i%7] + names[i] + ANSI_RESET);
      for(int n = 0; n < (gap_length - names[i].length()); n++){
        System.out.print(" ");
      }
      System.out.print("|");
    }
    System.out.print('\n');
    for(int i = 0; i < balances.length; i++){
      System.out.print(balances[i]);
      for(int n = 0; n < (gap_length - String.valueOf(balances[i]).length()); n++){
        System.out.print(" ");
      }
      System.out.print("|");
    }
    System.out.println();
  }
}
