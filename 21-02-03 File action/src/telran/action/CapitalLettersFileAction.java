package telran.action;

import telran.FileAction;
import telran.FileOperations;

import java.util.ArrayList;
import java.util.List;

public class CapitalLettersFileAction extends FileAction {

    public CapitalLettersFileAction(FileOperations fileOperations) {
        super(fileOperations);
    }

    @Override
    protected List<String> perform(List<String> text) {
        List<String> copyText = new ArrayList<>();
        for (String str : text) {
            copyText.add(str.toUpperCase());
        }
        return copyText;
    }
}
