import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CensorTest {
    final Set<String> censorList = new HashSet(Arrays.asList("rrr", "ttt", "www"));
    Censor censor = new Censor(censorList);

    @org.junit.jupiter.api.Test
    void verify_obsceneText() {
        assertFalse(censor.verify("hello www world rrr !"));
    }

    @org.junit.jupiter.api.Test
    void verify_censorText() {
        assertTrue(censor.verify("hello world!"));
    }

    @org.junit.jupiter.api.Test
    void verify_TextisEmpty() {
        assertTrue(censor.verify(""));
    }
}
