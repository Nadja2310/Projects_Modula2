import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {
    AccountService accountService = new AccountService();

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
        Transaction tr2_acc2 = new Transaction("222222222", 1300,
                LocalDate.of(2020, 12, 31), State.CANCELLED);
        Transaction tr3_acc2 = new Transaction("222222222", 1400,
                LocalDate.of(2020, 12, 31), State.PROCESSING);

        Account acc1 = new Account("q111111111", 10000);
        acc1.addTransaction(tr1);
        acc1.addTransaction(tr2);
        acc1.addTransaction(tr3);
        Account acc2 = new Account("q222222222", -100);
        acc2.addTransaction(tr2_acc2);
        acc2.addTransaction(tr1_acc2);
        acc2.addTransaction(tr3_acc2);

        long res = accountService.getSumAllCancelledTransaction(Arrays.asList(acc1, acc2));
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
        Transaction tr2_acc2 = new Transaction("222222222", 1300,
                LocalDate.of(2020, 12, 31), State.CANCELLED);
        Transaction tr3_acc2 = new Transaction("222222222", 1400,
                LocalDate.of(2020, 12, 31), State.PROCESSING);

        Account acc1 = new Account("q111111111", 10000);
        acc1.addTransaction(tr1);
        acc1.addTransaction(tr2);
        acc1.addTransaction(tr3);
        Account acc2 = new Account("q222222222", 100);
        acc2.addTransaction(tr2_acc2);
        acc2.addTransaction(tr1_acc2);
        acc2.addTransaction(tr3_acc2);

        long res = accountService.getSumAllCancelledTransaction(Arrays.asList(acc1, acc2));
        assertEquals(1600, res);
    }

    @org.junit.jupiter.api.Test
    void count_resNull() {
        Transaction tr1 = new Transaction("111111111", 200,
                LocalDate.of(2020, 12, 31), State.FINISHED);
        Transaction tr2 = new Transaction("111111111", 300,
                LocalDate.of(2020, 12, 31), State.FINISHED);
        Transaction tr3 = new Transaction("111111111", 400,
                LocalDate.of(2020, 12, 31), State.PROCESSING);

        Transaction tr1_acc2 = new Transaction("222222222", 1200,
                LocalDate.of(2020, 12, 31), State.FINISHED);
        Transaction tr2_acc2 = new Transaction("222222222", 1300,
                LocalDate.of(2020, 12, 31), State.CANCELLED);
        Transaction tr3_acc2 = new Transaction("222222222", 1400,
                LocalDate.of(2020, 12, 31), State.PROCESSING);

        Account acc1 = new Account("q111111111", 10000);
        acc1.addTransaction(tr1);
        acc1.addTransaction(tr2);
        acc1.addTransaction(tr3);
        Account acc2 = new Account("q222222222", -100);
        acc2.addTransaction(tr2_acc2);
        acc2.addTransaction(tr1_acc2);
        acc2.addTransaction(tr3_acc2);
        AccountService accountService = new AccountService();

        long res = accountService.getSumAllCancelledTransaction(Arrays.asList(acc1, acc2));
        assertEquals(0, res);
    }

    @org.junit.jupiter.api.Test
    void sumTransaction() {
        Transaction tr1 = new Transaction("111111111", 200,
                LocalDate.of(2020, 12, 31), State.FINISHED);
        Transaction tr2 = new Transaction("111111111", 300,
                LocalDate.of(2020, 12, 31), State.FINISHED);
        Transaction tr3 = new Transaction("111111111", 400,
                LocalDate.of(2020, 12, 31), State.PROCESSING);

        Transaction tr1_acc2 = new Transaction("222222222", 1200,
                LocalDate.of(2020, 12, 31), State.FINISHED);
        Transaction tr2_acc2 = new Transaction("222222222", 1300,
                LocalDate.of(2020, 12, 31), State.CANCELLED);
        Transaction tr3_acc2 = new Transaction("222222222", 1400,
                LocalDate.of(2020, 12, 31), State.PROCESSING);
        Map<String,Long> res=  accountService.sumTransaction(Arrays.asList(tr1, tr2, tr3, tr1_acc2, tr2_acc2, tr3_acc2));
        assertEquals(900,res.get("111111111"));
        assertEquals(3900,res.get("222222222"));

    }
}