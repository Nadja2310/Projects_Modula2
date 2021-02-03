package telran.action;

import telran.FileAction;
import telran.FileOperations;

import java.util.ArrayList;
import java.util.List;

public class ReplaceFileAction extends FileAction {

    private final String pattern;
    private final String target;

    public ReplaceFileAction(FileOperations fileOperations, String pattern, String target) {
        super(fileOperations);
        this.pattern = pattern;
        this.target = target;
    }

    /**
     * Replace all occurrences of 'pattern' to 'target'
     *
     * @param text
     * @return
     */
    @Override
    protected List<String> perform(List<String> text) {
        List<String> copyText = new ArrayList<>();
        for (String str : text) {
            copyText.add(str.replaceAll(target,pattern));
        }
        return copyText;
    }
}
