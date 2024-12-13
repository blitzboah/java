import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client{
    public void run() throws IOException, UnknownError{
        int port = 8010;
        InetAddress address = InetAddress.getByName("localhost");
        Socket socket = new Socket(address, port);
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream());
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toSocket.println("hello from the client");
        String line = fromSocket.readLine();
        System.out.println("response from socket is "+line);
        toSocket.close();
        fromSocket.close();
        socket.close();
        
    }

    public static void main(String[] args){
        Client client = new Client();
        try{
            client.run();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}