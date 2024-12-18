package article1.deadlock;

public class SolveDeadLock {
    public static final Object Lock1 = new Object();
    public static final Object Lock2 = new Object();

    public static void main(String args[]) {

        ThreadOne threadOne = new ThreadOne();
        ThreadTwo threadTwo = new ThreadTwo();
        threadOne.start();
        threadTwo.start();
    }

    private static class ThreadOne extends Thread {
        public void run() {
            synchronized (Lock1) {
                System.out.println("ThreadOne is holding lock 1...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadOne is waiting for lock 2...");
                synchronized (Lock2) {
                    System.out.println("ThreadOne is holding lock 1 & 2...");
                }
            }
        }
    }

    private static class ThreadTwo extends Thread {
        public void run() {
            synchronized (Lock1) {
                System.out.println("ThreadTwo is holding lock 1...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadOne is waiting for lock 2......");
                synchronized (Lock2) {
                    System.out.println("ThreadTwo is holding lock 1 & 2...");
                }
            }
        }
    }
}
