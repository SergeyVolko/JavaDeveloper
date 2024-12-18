package article1.synchron;

public class SimpleThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        SimpleThread threadOne = new SimpleThread("Thread One", counter);
        SimpleThread threadTwo = new SimpleThread("Thread Two", counter);

        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        }catch (InterruptedException e){
            System.out.println("Threads interrupted.");
            e.printStackTrace();
        }
    }
}
