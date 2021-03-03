import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolvTest {
    Solv test = new Solv();

    @Test
    void calculateDaysUntilNewYear() {
        int days = test.calculateDaysUntilNewYear();
        System.out.println(days);
    }

    @Test
    void birthdays_test1() {
        test.birthdays("1984.04.26");
    }

    @Test
    void birthdays_test2() {
        test.birthdays("1984.02.26");
    }
}