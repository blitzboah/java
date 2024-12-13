import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private static CopyOnWriteArrayList<ClientHandler> clients = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(6969);
            System.out.println("server is waiting for connections!...");

            while (true) {
                Socket clientSocket = ss.accept();
                System.out.println("someone connected " + clientSocket);

                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static void broadcast (String msg, ClientHandler sender){
            for (ClientHandler client : clients) {
                if (client != sender) {
                    client.sendMessage(msg);
                }
            }
        }

        private static class ClientHandler implements Runnable {
            private Socket clientSocket;
            private PrintWriter out;
            private BufferedReader in;
            private String username;

            public ClientHandler(Socket socket) {
                this.clientSocket = socket;

            try

            {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            }
            catch(Exception e)

            {
                e.printStackTrace();
            }
          }

        @Override
        public void run(){
          try{
            username = getUsername();
            System.out.println("user " + username + " connected");
            out.println("welcome to chat "+username);
            out.println("type ur msg");
            String inputLine;
            while((inputLine = in.readLine()) != null){
              System.out.println("["+username+"]: "+inputLine);
              broadcast("[" +username+ "]: "+inputLine, this);
            }

            clients.remove(this);
            in.close();
            out.close();
            clientSocket.close();
          }catch(Exception e){
            e.printStackTrace();
          }
        }

        private String getUsername() throws IOException {
            out.println("enter username:");
            return in.readLine();
        }

        public void sendMessage(String msg){
          out.println(msg);
          out.println("type ur msg");
        }

    }
}
