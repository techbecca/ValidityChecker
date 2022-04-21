import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsSsnTest {

    private static IsSsn isSsn;

    @BeforeAll
    static void beforeAll() {
        isSsn = new IsSsn();
    }

    @Test
    void rejectsIfTooLong() {
        String tooLongSsn = "1234567891-1232";
        assertFalse(isSsn.validate(tooLongSsn));
    }

    @Test
    void rejectIfContainsChar() {
        String charSsn = "HA567891-1232";
        assertFalse(isSsn.validate(charSsn));
    }

    @Test
    void acceptShortSizesOfSsn() {
        String shortSsn = "1701072397"; // Must be 10 digits
        assertTrue(isSsn.validate(shortSsn));

    }

    @Test
    void acceptLongSizesOfSsn() {
        String longSsn = "201701072397"; // Must be 12 digits
        assertTrue(isSsn.validate(longSsn));
    }

    @Test
    void acceptSsnWithDash() {
        String dashSsn = "20170107-2397";
        assertTrue(isSsn.validate(dashSsn));
    }

    @Test
    void acceptsSsnWithAddedSpaces() {
        String spaceSsn = "  20170107 2397 ";
        assertTrue(isSsn.validate(spaceSsn));
    }

    @Test
    void acceptValidSsn() {
        String ssn = "19820411-2380";
        assertTrue(isSsn.validate(ssn));
    }

    @Test
    void acceptAnotherValidSsn() {
        String ssn = "19780202-2389";
        assertTrue(isSsn.validate(ssn));
    }

    @Test
    void rejectInvalidSsn() {
        String ssn = "19820411-2382";
        assertFalse(isSsn.validate(ssn));
    }
}