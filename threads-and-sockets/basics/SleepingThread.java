public class SleepingThread{
  public static void main(String args[]) throws InterruptedException{
    String importantInfo[] = {
      "hello",
      "i am",
      "blitz",
      "bye"
    };

    for(int i = 0; i<importantInfo.length; i++){
      Thread.sleep(6900); //thread sleeps for 6.9 secs mp
      System.err.println(importantInfo[i]);
    }
  }
} //throws InterruptedException, it is an exception that sleep throws when another thread interrupts the curent thread while sleep is active
// in this case nothing happens no one to interrupt
