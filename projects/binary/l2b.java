public class l2b{
  public static void main(String[] args){
    String[] chars = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","q","r","s","t","u","v","w","x","y","z"};
    for(int i = 0; i < args.length; i++){
      System.out.print(chars[Integer.parseInt(args[i], 2)]);
    }
    System.out.println();
  }
}
