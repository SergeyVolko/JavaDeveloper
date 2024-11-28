public class Event implements Comparable<Event> {
    private int start;
    private int end;
    private String title;

    public Event(int start, int end, String title) {
        this.start = start;
        this.end = end;
        this.title = title;
    }

    public Event(int start) {
        this.start = start;
    }

    @Override
    public int compareTo(Event o) {
        if (start == o.start) {
            return Integer.compare(end, o.end);
        }
        return Integer.compare(start, o.start);
    }

    @Override
    public String toString() {
        return String.format("[%d - %d] : %s", start, end, title);
    }
}
