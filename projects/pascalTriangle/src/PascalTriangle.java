import java.io.File;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
 
class PascalTriangle {
     
    // Function to print first
    // n lines of Pascal's Triangle
    static String printPascal(double n)
    {
      String tot = "";
         
      // Iterate through every line
      // and print entries in it
      for (int line = 0; line < n; line++)
      {
        // Every line has number of 
        // integers equal to line number
        System.out.println(line);
        for(int s = 0; s < n - line - 1; s++){tot += " "; /*System.out.print(" ");*/}
        for (int i = 0; i <= line; i++){
            tot += (((binomialCoeff(line, i).mod(BigInteger.valueOf(2))!=BigInteger.valueOf(0))?"#":" ")+" ");
            //System.out.print(((binomialCoeff(line, i).mod(BigInteger.valueOf(2))!=BigInteger.valueOf(0))?"#":" ")+" ");
        }
              
        tot += "\n";
        //System.out.println();
      }
      return tot;
    }
      
    // Link for details of this function
    // https://www.geeksforgeeks.org/archives/25621
    static BigInteger binomialCoeff(int n, int k)
    {
        BigInteger res = BigInteger.valueOf(1);
         
        if (k > n - k)
           k = n - k;
            
        for (int i = 0; i < k; ++i)
        {
            res = res.multiply(BigInteger.valueOf(n - i));
            res = res.divide(BigInteger.valueOf((i + 1)));
        }
        return res;
    }
      
    // Driver code
    public static void main(String args[])
    {
        ///Users/goodwyna21/Desktop
        File file = new File("/Users/goodwyna21/Desktop/triangleSave.txt");
        file.getParentFile().mkdirs();

        PrintWriter out;
        try{
            out = new PrintWriter(file);
        } catch(Exception e){
            System.out.print(e);
            out = null;
        }

        Scanner in = new Scanner(System.in);
        System.out.print("Number of rows: ");
        double n = Math.pow(2, in.nextInt());
        out.println(printPascal(n));
        out.close();
    }
}