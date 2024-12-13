import java.io.*;
import java.net.*;
import java.util.*;

public class Client{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    try{
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a+b;
        Socket socket = new Socket("localhost", 8010);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.write(c);
        dos.flush();
        dos.close();
        socket.close();
    }
    catch (Exception e){
        System.out.println(e);
    }
  }
}
