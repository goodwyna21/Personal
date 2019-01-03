
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Crossword {
  public static void main(String[] args) {

    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_PURPLE = "\u001B[35m";
    final String ANSI_CYAN = "\u001B[36m";
    final String ANSI_WHITE = "\u001B[37m";

    Scanner in = new Scanner(System.in);
    List<String> save;
    try{
      save = readFile(args[0]);
    } catch(Exception e){
      System.out.println("Error: File not Found\nLoading test1");
      save = readFile("test1.txt");
    }
    int lengthOfArray = Integer.parseInt(save.get(0));

    //read in array of blacks and chars
    boolean[][] isBlack = new boolean[lengthOfArray][save.get(1).length()];
    char[][] lets = new char[lengthOfArray][save.get(1).length()];
    for(int x = 0; x < isBlack.length; x++){
      for(int y = 0; y < isBlack[0].length; y++){
        isBlack[x][y] = (save.get(y + 1).toCharArray()[x]=='1');
        lets[x][y] = (save.get(y + isBlack[0].length + 1).toCharArray()[x]);
      }
    }
    //align them the right way, involves transposing
    //isBlack = transposeBoolMatrix(isBlack);
    //lets = transposeCharMatrix(lets);

    //read in clues
    String[] downClues = new String[Integer.parseInt(save.get((lengthOfArray * 2) + 1))];
    String[] acrossClues = new String[Integer.parseInt(save.get((lengthOfArray * 2) + 2 + Integer.parseInt(save.get((lengthOfArray * 2) + 1))))];
    for(int n = 0; n < Integer.parseInt(save.get(lengthOfArray * 2 + 1)); n++){
      downClues[n] = save.get(n + (lengthOfArray * 2) + 2);
    }
    for(int n = 0; n < acrossClues.length; n++){
      acrossClues[n] = save.get(1 + lengthOfArray + lengthOfArray + 1 + downClues.length + 1 + n);
    }

    Board b = new Board(isBlack, lets);
    while(true){
      if(b.checkWon()){
        break;
      }
      System.out.print("\n\n" + b + "\n\n" + formatString(acrossClues, downClues) + "\n\nEnter Guess (letter, x, y)\n>");
      b.isCorrect(in.next().toUpperCase().toCharArray()[0], in.nextInt() - 1, in.nextInt() - 1);
      //System.out.println();
    }
    System.out.println("You won!");
  }

  public static String formatString(String[] acrossClues, String[] downClues){
    /*
      ACROSS  |  DOWN
    1-------  | 2-----
    */
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_RESET = "\u001B[0m";


    String tot = "";
    int maxLength = 0;
    for(int i = 0; i < acrossClues.length; i++){
      maxLength = (acrossClues[i].length() > maxLength)?acrossClues[i].length():maxLength;
    }
    maxLength++;

    tot += ANSI_BLUE + " DOWN" + ANSI_RESET;
    for(int n = 0; 5 + n < maxLength; n++){
      tot += " ";
    }
    tot += "|";
    tot += ANSI_BLUE + " ACROSS" + ANSI_RESET + "\n";
    for(int n = 0; n < ((acrossClues.length>downClues.length)?acrossClues.length:downClues.length); n++){
      tot += acrossClues[n];
      for(int i = 0; acrossClues[n].length() + i < maxLength; i++){
        tot+=" ";
      }
      tot+="|";
      try{
        tot+=" " + downClues[n];
      } catch(Exception e){
        tot+=" ";
      }
      tot+="\n";
    }
    return tot;
  }

  public static List<String> readFile(String filename){
    List<String> records = new ArrayList<String>();
    try{
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      String line;
      while ((line = reader.readLine()) != null){
        records.add(line);
      }
      reader.close();
      return records;
    }
    catch (Exception e){
      System.out.println("Error occurred trying to read '" + filename + "'.");
      System.out.println("Loading test1");
      return readFile("test1.txt");
    }
  }

  public static char[][] transposeCharMatrix(char[][] matrix){
    int m = matrix.length;
    int n = matrix[0].length;

    char[][] trasposedMatrix = new char[n][m];

    for(int x = 0; x < n; x++){
        for(int y = 0; y < m; y++){
            trasposedMatrix[x][y] = matrix[y][x];
        }
    }

    return trasposedMatrix;
  }

  public static boolean[][] transposeBoolMatrix(boolean[][] matrix){
    int m = matrix.length;
    int n = matrix[0].length;

    boolean[][] trasposedMatrix = new boolean[n][m];

    for(int x = 0; x < n; x++){
        for(int y = 0; y < m; y++){
            trasposedMatrix[x][y] = matrix[y][x];
        }
    }
        return trasposedMatrix;
    }
}
