public class VirtualThreads {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        };

        Thread v1 = Thread.ofVirtual().start(runnable);

        Thread v2 = Thread.ofVirtual().unstarted(runnable); // creates but doesn't start
        v2.start();

        try {
            v2.join();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
