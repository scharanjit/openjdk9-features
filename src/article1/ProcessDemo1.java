package article1;

import java.io.IOException;

public class ProcessDemo1 {

    public static void main(String[] args) throws IOException {
        Process p = new ProcessBuilder("gedit").start();
        System.out.println("Process Id : "+p.pid());
    }

}
