import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotNullTest {
    private static NotNull notNull;

    @BeforeAll
    static void beforeAll() {
        notNull = new NotNull();
    }

    @Test
    void failsWhenDataIsNull() {
        assertFalse(notNull.validate(null));
    }

    @Test
    void succeedsWhenDataIsNotNull() {
        assertTrue(notNull.validate("data"));
    }

}