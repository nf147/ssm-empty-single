package the_mass.decorator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileOutputStream stream = new FileOutputStream(new File("d:/ccccc.txt"));
        ProgressOutputStream gos = new ProgressOutputStream(stream);
        LogOutputStream sos = new LogOutputStream(gos);

        sos.write("hello world, my friend!!!".getBytes());

        sos.close();
    }
}
