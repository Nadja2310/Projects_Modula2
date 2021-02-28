import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccountService {
    public long getSumAllCancelledTransaction(List<Account> accounts) {

        return accounts.stream()
                .filter(account -> account.getBalance() > 0)
                .flatMap(account -> account.getTransaction().stream())
                .filter(transaction -> transaction.getState() == State.CANCELLED)
                .mapToLong(Transaction::getSum)
                .sum();
    }

    public Map<String, Long> sumTransaction(List<Transaction> transactions) {

        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getUuid,
                        Collectors.summingLong(Transaction::getSum)));
    }
}
