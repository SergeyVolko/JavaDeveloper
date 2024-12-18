package article1.creating_thread;

public class ThreadByExtendingDemo {
    public static void main(String[] args) {
        ThreadByExtending threadOne = new ThreadByExtending("Thread One");
        ThreadByExtending threadTwo = new ThreadByExtending("Thread Two");

        threadOne.start();
        threadTwo.start();
    }
}
