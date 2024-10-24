import java.io.*;
import java.net.*;
import java.util.*;
public class palServer{
public static void main(String args[]){
  try{
    String rev = "";
    System.out.println("connecting....");
    ServerSocket ss = new ServerSocket(8010);
    Socket s = ss.accept();
    System.err.println("connection established to "+s.getRemoteSocketAddress());
    DataInputStream dis = new DataInputStream(s.getInputStream());
    String str = dis.readUTF();
    for(int i=str.length()-1; i>=0; i--){
      rev = rev + str.charAt(i);
    }
    if(str.equals(rev)){
      System.out.println("string is palindrome");
    }
    else{
      System.out.println("string is not palindrome");
    }
    dis.close();
    s.close();
    ss.close();
  }
  catch(Exception e){
    System.err.println(e.getMessage());
  }
}
}
