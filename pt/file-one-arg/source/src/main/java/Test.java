import java.io.*;

class Test {
    public static void main(String[] args) {
        File baseDirectory = new File("/root/path/to/dir" + args[0]);
        if (baseDirectory.exists()) {
            System.out.println("+");
        } else {
            System.out.println("-");
        }
    }
}
