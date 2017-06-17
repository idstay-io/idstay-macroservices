package idstay.domain.support;

import java.util.Date;
import java.util.UUID;

public class IDGenerator {
    public static String getIdString() {
        return UUID.randomUUID().toString();
    }

    public static String getIdString2() {
        return "#" + String.valueOf(new Date().getTime());
    }

    public static Long gen() {
        return 1L;
    }
}
