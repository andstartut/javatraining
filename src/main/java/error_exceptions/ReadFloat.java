package error_exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class ReadFloat {
    String currentLine;
    FileReader fileReader;
    BufferedReader bufferedReader;
    public ReadFloat() {


    }

    public void show(String name) throws MyException, IOException {
        URL filePath = ReadFloat.class.getClassLoader().getResource(name);
        if (filePath == null) {
            throw new MyException("Не правильное имя файла.");
        }

        File file = new File(ReadFloat.class.getClassLoader().getResource(name).getFile());
        if (!file.exists()) {
            throw new MyException("Файл не существует.");
        }

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
        }
        catch (OutOfMemoryError e) {
            System.out.println("Файл слишком большой. Нехватка памяти.");
        }

        while ((currentLine = bufferedReader.readLine()) != null) {
            try {
                System.out.println(Float.parseFloat(currentLine));
            }
            catch (NumberFormatException e) {
                System.out.println("Не число.");
            }
        }

        fileReader.close();
        bufferedReader.close();
    }
}
