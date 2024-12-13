import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Server{

    public Consumer<Socket> getConsumer(){
        return(acceptedSocket) -> {
            try{
                InputStream is = acceptedSocket.getInputStream();
                FileOutputStream fos = new FileOutputStream("received_file.txt");

                byte[] buffer = new byte[4096];
                int bytesRead;
                while((bytesRead = is.read(buffer)) != -1){
                    fos.write(buffer, 0, bytesRead);
                }

                FileInputStream fis = new FileInputStream("received_file.txt");
                while((bytesRead = fis.read(buffer)) != -1){
                    System.out.println(new String(buffer, 0, bytesRead));
                }
                acceptedSocket.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args){
        int port = 8069;
        Server server = new Server();
        try{
            ServerSocket serverSocket =  new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("server is listening to port : "+port);
            while(true){
                Socket acceptedSocket = serverSocket.accept();
                Thread thread = new Thread(() -> server.getConsumer().accept(acceptedSocket));
                thread.start();
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
        

    }
} 
