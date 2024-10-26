import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.io.InputStreamReader;

public class Client {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost", 6969);

            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            new Thread(() -> {
                try{
                    String serverResponse;
                    while ((serverResponse = in.readLine())!= null){
                        System.out.println(serverResponse);
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }).start();

            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();
            while (true){
                userInput = sc.nextLine();
                out.println(userInput);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
