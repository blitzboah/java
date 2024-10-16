public class SimpleThreads{

  static void threadMessage(String message){
    String threadName = Thread.currentThread().getName();
    System.out.format("%s:%s%n", threadName, message);
  }

  private static class MessageLoop implements Runnable{
    public void run(){
      String msgInfo[] = {
        "hola",
        "soy",
        "john marston",
        "por favor"
      };
      try{
        for(int i=0; i<msgInfo.length; i++){
          Thread.sleep(1500);
          threadMessage(msgInfo[i]);
        }
      }
      catch(InterruptedException e){
        System.out.println("pre owarida");
        return;
      }
    }
  }

  public static void main(String args[]) throws InterruptedException{
    long patience = 1000 * 60 * 60;

    if(args.length > 0){
      try{
        patience = Long.parseLong(args[0]) * 1000;
      }
      catch(NumberFormatException e){
        System.err.println("arguement must be an integer");
        System.exit(1);
      }

      threadMessage("starting thread loop");
      Long startTime = System.currentTimeMillis();
      Thread t = new Thread(new MessageLoop());
      t.start();

      threadMessage("waiting for thread loop to finish");
      while(t.isAlive()){
        threadMessage("still waiting...");
        t.join(500);

        if(((System.currentTimeMillis() - startTime) > patience)
            && t.isAlive()){
              threadMessage("am tired chat");
              t.interrupt();
              t.join();
            }
      }
      
      threadMessage("owarida!");
    }
  }
}
