import java.util.*;
import java.io.*;
import java.net.*;

public class chatClient{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String res;
        try{
            Socket s = new Socket("localhost", 8010);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            System.out.println(dis.readUTF());
            System.out.println("you:");
            res = sc.next();
            dos.writeUTF(res);
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());

            dos.close();
            dis.close();
            s.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}