import java.net.*;
import java.util.*;

public class ScannerThread implements Runnable{
  private String addr;
  private int seq;
  private int totThreads;
  private boolean singlePoint;
  private static ArrayList<Integer> ports = new ArrayList<Integer>();
  private static boolean cont = true;

  public ScannerThread(String add, int s, int tot, boolean sP){
    addr = add;
    seq = s;
    totThreads = tot;
    singlePoint = sP;
  }

  public void run(){
    for(int port = 1 + seq; port < 65535; port+=totThreads){
      scan(port, addr);
      if(!cont){
        break;
      }
    }
  }

  public void scan(int port, String addr){
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_BLUE = "\u001B[34m";

    try{
      if(cont){
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(InetAddress.getByName(addr), port), 10);
        socket.close();
        System.out.println("Port " + ANSI_BLUE + port + ANSI_RESET + " open");
        ScannerThread.addPort(port);
        if(singlePoint){
          cont = false;
        }
      }
    }catch(Exception e){}
  }

  public static void addPort(int port){
    ports.add(port);
  }

  public static ArrayList<Integer> getPorts(){
    return ports;
  }
}
