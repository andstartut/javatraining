package error_exceptions;

import java.io.IOException;

public class MainTaskRunner {
    public static void main(String[] args) throws MyException, IOException {

        ReadFloat fileRead = new ReadFloat();
        fileRead.show("errorAndExceptions");
    }
}
