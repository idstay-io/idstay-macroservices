package idstay.domain.support;

import java.util.UUID;

/**
 * Created by min on 4/22/17.
 */
public class IDGenerator {
    public static String newId() {
        return UUID.randomUUID().toString();
    }
}
