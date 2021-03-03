import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        // ZonedDateTime
        System.out.println(ZoneId.getAvailableZoneIds());
        ZonedDateTime minskMorning = ZonedDateTime.of(
                LocalDateTime.of(2021, Month.MARCH, 2, 6, 0),
                ZoneId.of("Europe/Minsk")
        );
        System.out.println(minskMorning);
        ZonedDateTime moskauMorning = minskMorning.withZoneSameInstant(ZoneId.of("Asia/Vladivostok"));// IMPORTANTE
        System.out.println(moskauMorning);
        ZonedDateTime sameTimeOtherZone = minskMorning.withZoneSameLocal(ZoneId.of("Asia/Vladivostok"));// IMPORTANTE
        System.out.println(sameTimeOtherZone);

    }
}
