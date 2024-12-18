package article1.interaction_threads;

public class ThreadInteraction {
    boolean isActive = false;

    public synchronized void request(String request) {
        if(isActive) {
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Pilot:");
        System.out.println(request);
        isActive = true;
        notify();
    }

    public synchronized void response(String response) {
        if(!isActive) {
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Controller:");
        System.out.println(response);
        isActive = false;
        notify();
    }
}
