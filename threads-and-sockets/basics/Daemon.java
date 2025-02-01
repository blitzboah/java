public class Daemon {
    public static void main(String[] args) throws InterruptedException {
        Runnable run = () -> {
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("runnin");
            }
        };

        Thread t = new Thread(run);
        t.setDaemon(true); //if it isn't set to true or mentioned, the jvm will still be alive, tldr: main thread is stopped but the other thread is still keeps jvm alive
        t.start();
        Thread.sleep(3000);

    }
}
