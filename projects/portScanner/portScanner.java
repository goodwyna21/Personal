import java.net.*;
import java.util.*;

public class portScanner{
  public static void main(String[] args){
    String addr = "";
    int numThreads;
    try{
      addr = args[0];
    } catch(Exception e){
      System.out.println("Error, no address specified\nSpecify parameters like ADDRESS [NUMBER OF THREADS (INTEGER)] [SINGLE PORT SCAN (BOOLEAN)]");
    }
    try{
      numThreads = Integer.parseInt(args[1]);
    } catch(Exception e){
      numThreads = 1;
    }
    boolean singlePoint;
    try{
      singlePoint = Boolean.parseBoolean(args[2]);
    } catch(Exception e){
      singlePoint = false;
    }

    ScannerThread[] threads = new ScannerThread[numThreads];

    if(!addr.isEmpty()){
      for(int i = 0; i < numThreads; i++){
        threads[i] = new ScannerThread(addr, i, numThreads, singlePoint);
        new Thread(threads[i]).start();
      }
      ArrayList<Integer> ports = ScannerThread.getPorts();
      for(int i = 0; i < ports.size(); i++){
        System.out.println(ports.get(i));
      }
    }
  }
}
