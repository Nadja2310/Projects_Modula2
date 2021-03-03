package workingTime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    Service service = new Service();

    @Test
    void intersectWorkingTime_test1() {
        int res = service.intersectWorkingTime(LocalTime.of(9, 0), 9, ZoneId.of("Europe/Moscow"),
                LocalTime.of(9, 0), 8, ZoneId.of("Asia/Vladivostok"));
        assertEquals(1, res);
    }

    @Test
    void intersectWorkingTime_test2() {
        int res = service.intersectWorkingTime(LocalTime.of(9, 0), 9, ZoneId.of("Europe/Moscow"),
                LocalTime.of(9, 0), 8, ZoneId.of("America/Cuiaba"));
        assertEquals(2, res);
    }

    @Test
    void intersectWorkingTime_test3() {
        int res = service.intersectWorkingTime(LocalTime.of(9, 0), 8, ZoneId.of("Asia/Vladivostok"),
                LocalTime.of(9, 0), 9, ZoneId.of("Europe/Moscow"));
        assertEquals(1, res);
    }
}