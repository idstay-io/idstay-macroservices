package idstay.domain.model.shared;

import java.util.UUID;

/**
 * Created by min on 4/22/17.
 */
public class IDGenerator {
    public static Long gen() {
        return (long) (Math.random() * (100000000 - 1 + 1)) + 1;
    }
}
