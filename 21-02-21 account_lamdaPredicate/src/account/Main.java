package account;

import account.Account;
import account.AccountFilter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Account acc1 = new Account("111111", 23, false);
        Account acc2 = new Account("222222", 0, false);
        Account acc3 = new Account("333333", -10, true);
        Account acc4 = new Account("234535", 110000, false);

        AccountFilter accountFilter = new AccountFilter();
        List<Account> listAccounts = Arrays.asList(acc1, acc2, acc3, acc4);

        // Predicate- balance more 0
        Predicate<Account> balanceMore0 = (account -> account.balance > 0);
        System.out.println(accountFilter.filter(listAccounts, balanceMore0));

        Predicate<Account> balanceMore100000 = (account -> account.balance > 100000 && !account.isLocked);
        System.out.println(accountFilter.filter(listAccounts, balanceMore100000));


    }
}

