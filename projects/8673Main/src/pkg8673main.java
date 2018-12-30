
import java.util.Scanner;

public class pkg8673main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println(rec(in.nextInt()));
        }
    }
    
    public static double rec(double n){
        if(n == 1){
            return 1;
        } else {
            return ((365 - (n - 1))/365) * rec(n - 1);
        }
    }
}
