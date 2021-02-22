import java.time.LocalDate;
import java.util.Arrays;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @org.junit.jupiter.api.Test
    void count() {
        Transaction tr1 = new Transaction("111111111", 200,
                LocalDate.of(2020, 12, 31), State.FINISHED);
        Transaction tr2 = new Transaction("111111111", 300,
                LocalDate.of(2020, 12, 31), State.CANCELLED);
        Transaction tr3 = new Transaction("111111111", 400,
                LocalDate.of(2020, 12, 31), State.PROCESSING);

        Transaction tr1_acc2 = new Transaction("222222222", 1200,
                LocalDate.of(2020, 12, 31), State.FINISHED);
        Transaction tr2_acc2 = new Transaction("111111111", 1300,
                LocalDate.of(2020, 12, 31), State.CANCELLED);
        Transaction tr3_acc2 = new Transaction("111111111", 1400,
                LocalDate.of(2020, 12, 31), State.PROCESSING);

        Account acc1 = new Account("q111111111", 10000, Arrays.asList(tr1, tr2, tr3));
        Account acc2 = new Account("q222222222", -100, Arrays.asList(tr1_acc2, tr2_acc2, tr3_acc2));
        Account test = new Account();
        long res = test.count(Arrays.asList(acc1, acc2));
        assertEquals(300, res);
    }

    @org.junit.jupiter.api.Test
    void count_2() {
        Transaction tr1 = new Transaction("111111111", 200,
                LocalDate.of(2020, 12, 31), State.FINISHED);
        Transaction tr2 = new Transaction("111111111", 300,
                LocalDate.of(2020, 12, 31), State.CANCELLED);
        Transaction tr3 = new Transaction("111111111", 400,
                LocalDate.of(2020, 12, 31), State.PROCESSING);

        Transaction tr1_acc2 = new Transaction("222222222", 1200,
                LocalDate.of(2020, 12, 31), State.FINISHED);
        Transaction tr2_acc2 = new Transaction("111111111", 1300,
                LocalDate.of(2020, 12, 31), State.CANCELLED);
        Transaction tr3_acc2 = new Transaction("111111111", 1400,
                LocalDate.of(2020, 12, 31), State.PROCESSING);

        Account acc1 = new Account("q111111111", 10000, Arrays.asList(tr1, tr2, tr3));
        Account acc2 = new Account("q222222222", 1, Arrays.asList(tr1_acc2, tr2_acc2, tr3_acc2));
        Account test = new Account();
        long res = test.count(Arrays.asList(acc1, acc2));
        assertEquals(1600, res);
    }

    @org.junit.jupiter.api.Test
    void count_resNull() {
        Transaction tr1 = new Transaction("111111111", 200,
                LocalDate.of(2020, 12, 31), State.FINISHED);
        Transaction tr2 = new Transaction("111111111", 300,
                LocalDate.of(2020, 12, 31), State.CANCELLED);
        Transaction tr3 = new Transaction("111111111", 400,
                LocalDate.of(2020, 12, 31), State.PROCESSING);

        Transaction tr1_acc2 = new Transaction("222222222", 1200,
                LocalDate.of(2020, 12, 31), State.FINISHED);
        Transaction tr2_acc2 = new Transaction("111111111", 1300,
                LocalDate.of(2020, 12, 31), State.CANCELLED);
        Transaction tr3_acc2 = new Transaction("111111111", 1400,
                LocalDate.of(2020, 12, 31), State.PROCESSING);

        Account acc1 = new Account("q111111111", -10000, Arrays.asList(tr1, tr2, tr3));
        Account acc2 = new Account("q222222222", 0, Arrays.asList(tr1_acc2, tr2_acc2, tr3_acc2));
        Account test = new Account();
        long res = test.count(Arrays.asList(acc1, acc2));
        assertEquals(0, res);
    }
}