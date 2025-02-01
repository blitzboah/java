public class Temp {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String tName = Thread.currentThread().getName();
            System.out.println(tName);
            System.out.println("runnnin");

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.getMessage();
            }

            System.out.println("owari da");
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();
    }
}
