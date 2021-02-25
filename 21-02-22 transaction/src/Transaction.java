import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    private String uuid;
    private long sum;
    private LocalDate date;
    private State state;

    public Transaction(String uuid, long sum, LocalDate date, State state) {
        this.uuid = uuid;
        this.sum = sum;
        this.date = date;
        this.state = state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getUuid() {
        return uuid;
    }

    public LocalDate getDate() {
        return date;
    }

    public State getState() {
        return state;
    }

    public long getSum() {
        return sum;
    }
}
