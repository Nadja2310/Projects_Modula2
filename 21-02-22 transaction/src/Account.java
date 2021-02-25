import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Account {
    private String id;
    private long balance;
    List<Transaction> transactions;

    public Account(String id, long balance) {
        this.id = id;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public List<Transaction> getTransaction() {
        return Collections.unmodifiableList(transactions);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}
