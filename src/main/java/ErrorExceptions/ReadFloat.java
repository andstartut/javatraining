package ErrorExceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFloat {
    public ReadFloat() {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource("errorAndException").getFile());

        try {
            FileReader reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
