package Homework;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class OurBufferedReaderTest {
    FileOperation fileOperation=new OurBufferedReader();

    @Test
    void test() throws IOException {
        fileOperation.writeToFile(fileOperation.inputText(),"test.txt");

    }

}