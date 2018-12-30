public class b2l{
  public static void main(String[] args){
    String chars = "abcdefghijklmnopqrstuvwxyz";
    for(int i = 0; i < args[0].length(); i++){
      System.out.println(Integer.toString(chars.indexOf(args[0].charAt(i)),2));
    }
  }
}
