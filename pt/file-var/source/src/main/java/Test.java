import java.io.*;
import java.nio.file.Paths;

class Test {
    public static void main(String[] args) {
        File baseDirectory = Paths.get(args[0]).toFile();
        if (baseDirectory.exists()) {
            System.out.println("+");
        } else {
            System.out.println("-");
        }
    }
}
