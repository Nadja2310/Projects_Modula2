package telran;

import org.junit.jupiter.api.Test;
import telran.action.CapitalLettersFileAction;
import telran.action.ReplaceFileAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileActionTest {

    @Test
    void testReplaceFileAction() throws IOException {
        FileOperations file = new FileOperations();

        file.writeList(Arrays.asList("1plus2=3", "2plus3=5"), "TestReplace.txt");

        FileAction fileAction = new ReplaceFileAction(new FileOperations(), "+", "plus");
        fileAction.handleFile("TestReplace.txt");
        List<String> list = Arrays.asList("1+2=3", "2+3=5");
        assertEquals(list, file.readToList("TestReplace.txt"));
    }

    @Test
    void testCapitalLettersFileAction() throws IOException {
        FileOperations file = new FileOperations();
        file.writeList(Arrays.asList("hello", "world", "!!"), "TestUpCase.txt");

        FileAction fileAction = new CapitalLettersFileAction(new FileOperations());
        fileAction.handleFile("TestUpCase.txt");
        List<String> list = Arrays.asList("HELLO", "WORLD", "!!");
        assertEquals(list, file.readToList("TestUpCase.txt"));

    }

}