
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int tot = 0;
        for(int n = (a>b)?b:a; n<=((a>b)?a:b); n++){tot += n;}
        System.out.println(tot);
    }
}
