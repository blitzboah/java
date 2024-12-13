public class RunnableThread implements Runnable{
  public void run(){
    System.out.println("hello from thread");
  }

  public static void main(String args[]){
    (new Thread(new RunnableThread())).start();
  }
}
