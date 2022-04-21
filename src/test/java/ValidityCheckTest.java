import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidityCheckTest {

    @Test
    void failMessage() {
        ValidityCheck validityCheck = new ValidityCheck() {
            @Override
            public boolean validate(String data) {
                return false;
            }
        };

        assertTrue(validityCheck.failMessage().contains("ValidityCheck"));
    }
}