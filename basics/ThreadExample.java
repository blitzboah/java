public class ThreadExample extends Thread{
  
  public void run(){
    System.out.println("hello from thred");
  }

  public static void main(String args[]){
    (new ThreadExample()).start();
  }
}
