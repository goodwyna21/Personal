public class Square {
  private boolean isBlack;
  private char letter;
  private char correctLetter;
  private int label;
  private boolean guessed;

  public Square(boolean iB, char l, int lab){
    isBlack = iB;
    correctLetter = String.valueOf(l).toUpperCase().charAt(0);
    label = lab;
    guessed = false;
    letter = ' ';
  }

  public boolean getBlack(){
    return isBlack;
  }

  public char getLetter(){
    return letter;
  }

  public int getLabel(){
    return label;
  }

  public boolean getIsBlack(){
    return isBlack;
  }

  public int getCorrectLetter(){
    return correctLetter;
  }

  public boolean getGuessed(){
      return guessed;
  }

  public boolean isCorrect(char guess){
    letter = guess;
    guessed = (correctLetter == guess);
    System.out.println((guessed)?"correct":"incorrect");
    return guessed;
  }
}
