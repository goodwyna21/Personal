import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class newAccount{
  public static void main(String[] args) throws IOException {
    if(args.length<3){
      System.out.println("Error: missing parameters.\nMust provide NAME and BALANCE");
    } else if(Integer.parseInt(args[2])<=0){
      System.out.println("Invalid balance, must be positive");
    } else {
      String name = args[0] + " " + args[1];

      String balance = args[2];
      long acnt_num = name.hashCode() & 0x00000000ffffffffL;
      System.out.println("Account number: " + acnt_num);

      String tot = "{\n\t\"Name\": \"" + name + "\"\n\t\"Balance\": " + Float.parseFloat(balance) + "\"\n\t\"Operations\": [\n\t\t\n\t]\n}";
      try (FileWriter file = new FileWriter(acnt_num + ".txt");
           FileWriter fw = new FileWriter("accounts.txt", true);
           BufferedWriter bw = new BufferedWriter(fw);
           PrintWriter out = new PrintWriter(bw)) {

  			file.write(tot);
        out.println(name + ">" + acnt_num);
  		} catch(Exception e){
        System.out.println(e);
      }
    }
  }
}
