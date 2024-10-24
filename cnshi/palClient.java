import java.io.*;
import java.net.*;
import java.util.*;

public class palClient{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    try{
        String str = sc.nextLine();
        Socket socket = new Socket("localhost", 8010);
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(str);
        dos.flush();
        dos.close();
        socket.close();
    }
    catch (Exception e){
        System.out.println(e);
    }
  }
}
