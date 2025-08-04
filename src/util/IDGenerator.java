package util;

import java.math.BigInteger;
import java.util.UUID;

public class IDGenerator {

    public String calculateID() {
        return String.format("%040d", new BigInteger(UUID.randomUUID().toString().replace("-", ""), 16));
    }

}
