package account;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AccountFilter {

    public List<Account> filter(List<Account> list, Predicate pred) {
        List<Account> outputList = new ArrayList<>();
        for (Account elt : list) {
            if (pred.test(elt)) {
                outputList.add(elt);
            }
        }
        return outputList;
    }
}
