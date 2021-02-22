import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Account {
    private String id;
    private long balance;
    List<Transaction> transaction;

    public Account() {
    }

    public Account(String id, long balance, List<Transaction> transaction) {
        this.id = id;
        this.balance = balance;
        this.transaction = transaction;
    }

    public String getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public long count(List<Account> accounts) {
        long longStream = accounts.stream()
                .filter(x -> x.balance > 0)
                .flatMap(x -> x.getTransaction().stream())
                .filter(x -> x.getState() == State.CANCELLED)
                .mapToLong(x -> x.getSum())
                .sum();

        return longStream;
    }
}
