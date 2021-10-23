import java.io.*;

public class Serialization {
    public static void main(String[] args) throws IOException {
    Cube c = new Cube();
    c.color = "green";
    c.width = 15.3d;
    c.height = 12.4d;
    c.depth = 3d;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("output9.txt"));
        oos.writeObject(c);
    }
}

class Cube implements Serializable {
    String color;
    double width;
    double height;
    double depth;
}
