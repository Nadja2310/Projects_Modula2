package telran;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {
    /**
     * Writes the list of strings into the file, clearing it if the file exists and starts every string from new
     * line
     *
     * @param strings
     * @param filename
     */
    public void writeStrings(List<String> strings, String filename) throws IOException {

        Files.write(Paths.get(filename), strings, StandardOpenOption.CREATE);
    }

    /**
     * reads all the lines of the file into a list
     *
     * @param filename
     * @return list of lines
     */
    public List<String> readStrings(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
        return lines;
    }

    public void writeBytes(byte[] bytes, String filename) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(filename)) {
            outputStream.write(bytes);
        }
    }

    public byte[] readBytes(String filename) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(filename)) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            return bytes;
        }
    }

    /**
     * Writes the list of number into the file with " " as a delimiter. [12, 35, 3534] -> "12 35 3534"
     *
     * @param numbers  to read into the file
     * @param filename
     */
    public void writeInts(List<Integer> numbers, String filename) throws IOException {
        FileWriter writer = new FileWriter(filename);
        for (Integer str : numbers) {
            writer.write(Integer.toString(str) + " ");
        }
        writer.close();
    }

    /**
     * The file contains data in the following format: "12 35 3534"
     *
     * @param filename
     * @return
     */

    // Integer.parseInt
    public List<Integer> readInts(String filename) throws IOException {
        List<String> listStr = readStrings(filename);
        List<Integer> listInt = new ArrayList<>();
        for (String str : listStr) {
            int k = 0;
            int i = 0;
            while (i < str.length()) {
                k = str.indexOf(" ", i);
                listInt.add(Integer.parseInt(str.substring(i, k)));
                i = k + 1;
            }
        }
        return listInt;
    }
}
