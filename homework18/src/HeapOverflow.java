import java.util.ArrayList;
import java.util.List;

/*
Run with -Xmx1m option
 */
public class HeapOverflow {
    public static List<Object> objectList = new ArrayList<>();

    public static void main(String[] args) {
        while(true){
            objectList.add(new Object());
        }
    }
}
