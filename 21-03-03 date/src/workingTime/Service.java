package workingTime;

import java.time.*;
import java.util.TimeZone;

public class Service {
    final int MINUTE = 60;
    final int SECONDS = 60;
    final int MILLISECONDS = 1000;

    public int intersectWorkingTime(LocalTime start1, int hours, ZoneId zone1,
                                    LocalTime start2, int hours2, ZoneId zone2) {

        long differenceTimeZone = TimeZone.getTimeZone(zone2).getRawOffset()
                - TimeZone.getTimeZone(zone1).getRawOffset();
        long differenceTimeZoneHour = (differenceTimeZone / (MINUTE * SECONDS * MILLISECONDS));

        if (differenceTimeZoneHour < 0)
            return (int) (hours - Math.abs(differenceTimeZoneHour));
        else
            return (int) (hours - (hours - hours2) - differenceTimeZoneHour);
    }
}
