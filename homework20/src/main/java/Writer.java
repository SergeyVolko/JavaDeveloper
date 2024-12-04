import models.Car;
import models.Engine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Writer {
    public static void main(String[] args) throws IOException {
        Engine engine = new Engine();
        engine.setHp(150);

        Car fordFocus = new Car("Ford Focus",
                2020, engine);


        FileOutputStream fos = new FileOutputStream(
                new File("homework20/src/main/java/files/car.ser")
        );
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(fordFocus);
        oos.close();
    }
}
