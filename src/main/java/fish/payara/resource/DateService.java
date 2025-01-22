package fish.payara.resource;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class DateService {
    public long secondUntilChristmas (ZonedDateTime startTime) {
        ZonedDateTime christmas = ZonedDateTime.of(2025, 12, 25, 0, 0, 0, 0, ZoneId.systemDefault());
        return ChronoUnit.SECONDS.between(startTime, christmas);
    }
}
