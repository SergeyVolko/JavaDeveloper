import java.util.*;

public class Schedule {
    private final TreeSet<Event> scheduleSet = new TreeSet<>();
    private final TreeMap<Integer, Integer> scheduleMap = new TreeMap<>();

    public void addEvent(int start, int end, String title) {
        Event event = new Event(start, end, title);
        scheduleSet.add(event);
        scheduleMap.put(start, scheduleMap.getOrDefault(start, 0) + 1);
        scheduleMap.put(end, scheduleMap.getOrDefault(end, 0) - 1);
    }

    public List<Event> getNext3(int time) {
        Event o = new Event(time);
        NavigableSet<Event> tailSet = scheduleSet.tailSet(o, true);
        List<Event> result = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            if (!tailSet.isEmpty()) {
                result.add(tailSet.pollFirst());
            }
        }
        return result;
    }

    public boolean hasOverlaps() {
        int cnt = 0;
        for (Integer key : scheduleMap.keySet()) {
            cnt += scheduleMap.get(key);
            if (cnt > 1) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        schedule.addEvent(9, 10, "Daily meeting");
        schedule.addEvent(11, 12, "1:1 with Ivan");
        schedule.addEvent(15, 16, "Sync - Gig Bet project");
        schedule.addEvent(17, 20, "Java community meeting");
        schedule.addEvent(19, 21, "Private appointment");

        System.out.println(schedule.getNext3(9));
        System.out.println(schedule.hasOverlaps());
    }
}
