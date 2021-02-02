package Homework;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class OurBufferedReader implements FileOperation {

    @Override
    public List<String> inputText() throws IOException {
        List<String> text = new ArrayList<>();
        try (BufferedReader inputText = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = inputText.readLine()) != null && !line.equals("exit")) {
                text.add(line);
            }
            return text;
        }
    }

    @Override
    public void writeToFile(List<String> text, String filename) throws IOException {
        try (PrintWriter printWriter = new PrintWriter(filename)) {
            for (String str : text) {
                printWriter.println(str);
            }
        }
    }
}
