package article1.creating_thread;

public class ThreadByExtending extends Thread {
    private Thread thread;
    private String threadName;

    public ThreadByExtending(String threadName) {
        this.threadName = threadName;
        System.out.println("Thread " + threadName + " created successfully.");
    }

    @Override
    public void run() {
        System.out.println("Thread " +  threadName + " is running...");

        try {
            for(int i = 1;i <= 5; i++) {
                System.out.println("Thread " + threadName + " " + i);
                Thread.sleep(100);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " is interrupted.");
            e.printStackTrace();
        }
        System.out.println("Leaving thread " + threadName);
    }

    public void start() {
        System.out.println("Thread " + threadName + " is started successfully.");
        if(thread == null) {
            thread = new Thread(this,threadName);
            thread.start();
        }
    }
}
