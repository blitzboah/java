import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.io.FileInputStream;
import java.io.OutputStream;

public class Client{

    public Runnable getRunnable(){
        return new Runnable() {
            @Override
            public void run() throws UnknownError{
                    try{
                        int port = 8069;
                    InetAddress address = InetAddress.getByName("localhost");
                    Socket socket = new Socket(address, port);
                    BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    FileInputStream fis = new FileInputStream("file.txt");
                    OutputStream ous = socket.getOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while((bytesRead = fis.read(buffer)) != -1){
                        ous.write(buffer, 0, bytesRead);
                    }
                    ous.close();
                    fis.close();
                    fromSocket.close();
                    socket.close();
                    }
                    catch(IOException e){
                        e.printStackTrace();
                    }
                
            }
};
    }

    public static void main(String[] args){
        Client client = new Client();
        for(int i=0; i<100; i++){
            try{
                Thread thread = new Thread(client.getRunnable());
                thread.start();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
