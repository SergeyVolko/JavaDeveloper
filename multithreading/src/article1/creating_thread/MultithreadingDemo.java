package article1.creating_thread;

public class MultithreadingDemo {
    public static void main(String[] args) {
        ThreadByRunnable threadOne = new ThreadByRunnable("ThreadOne");
        ThreadByRunnable threadTwo = new ThreadByRunnable("ThreadTwo");

        threadOne.start();
        threadTwo.start();

    }
}
