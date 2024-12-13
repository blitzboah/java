import java.io.*;
import java.net.*;
import java.util.*;
public class Server{
public static void main(String args[]){
  try{
    System.out.println("connecting....");
    ServerSocket ss = new ServerSocket(8010);
    Socket s = ss.accept();
    System.err.println("connection established to "+s.getRemoteSocketAddress());
    DataInputStream dis = new DataInputStream(s.getInputStream());
    int out = dis.read();
    System.err.println("output:"+out);
    dis.close();
    s.close();
    ss.close();
  }
  catch(Exception e){
    System.err.println(e.getMessage());
  }
}
}
