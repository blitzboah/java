import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server{

    private final ExecutorService threadPool;

    public Server(int poolSize){
            this.threadPool = Executors.newFixedThreadPool(poolSize);
    }

    public void handleClient(Socket clientSocket){
            try{
                PrintWriter toSocket = new PrintWriter(clientSocket.getOutputStream());
                toSocket.println("hello from server : "+clientSocket.getInetAddress());
            }
            catch(IOException e){
                e.printStackTrace();
            }
       } 

    public static void main(String[] args){
        int port = 8069;
        int threadPool = 10;
        Server server = new Server(threadPool);
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            System.out.println("server is running on port:"+port);

            while(true){
                Socket clientSocket = serverSocket.accept();
                server.threadPool.execute(() -> server.handleClient(clientSocket));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            server.threadPool.shutdown();
        }

    }
}
