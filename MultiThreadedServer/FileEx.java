import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; 
 
public class FileEx{
    public static void main(String[] args){
        try{
        String data;
        File myFile = new File("file.txt");
        Scanner sc = new Scanner(myFile);
        while(sc.hasNextLine()){
            data = sc.nextLine();
            System.out.println(data);
        }
        
        sc.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
