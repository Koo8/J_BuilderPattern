package TimeZone_Stream;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class MainTimeZone {
    public static void main(String[] args) {

        // defind localTime and localDate to arrive at LocalDateTime (2015-06-01T04:10)
        LocalTime localTime = LocalTime.of(5, 10);
        localTime = localTime.minus(1, ChronoUnit.HOURS); // is this for summer time one hour change?

        LocalDate localDate = LocalDate.of(2015, Month.MAY, 20);
        localDate = localDate.plusDays(12);

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime);

        // attach time zone to the localDatetime
        // to sort all the id for easy referrence, refer to the method of  organizeZoneId
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("America/Antigua"));
        System.out.println(zonedDateTime);

        organizeZoneId();
    }

    private static void organizeZoneId() {

        Set<String> idSet = ZoneId.getAvailableZoneIds();
        /* display each zoneid on its own line */
        idSet.stream().sorted().forEach((id) -> System.out.println(id));

        //




    }
}