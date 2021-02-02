package Homework;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileOperation fileOperation=new OurBufferedReader();

            fileOperation.writeToFile(fileOperation.inputText(),"test.txt");

        }
}
