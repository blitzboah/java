import java.util.*;
import java.io.*;
import java.net.*;

public class chatServer{
    public static void main(String[] args) {
        String greetString = "hello i am chatbot, how can i help you?\n" +
                "1.hi\n" +
                "type exactly these words\n";
        try{
            System.out.println("connecting");
            ServerSocket ss = new ServerSocket(8010);
            Socket s = ss.accept();
            System.out.println("conn established");
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(greetString);

            dis.readUTF();
            dos.writeUTF("hello");
            dos.writeUTF("byebye");

            dos.close();
            dis.close();
            s.close();
            ss.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}