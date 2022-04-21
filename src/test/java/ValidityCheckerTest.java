import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ValidityCheckerTest {

    private static ValidityChecker validityChecker;
    private static NotNull notNull;
    private static IsSsn isSsn;
    private List<ValidityCheck> validityChecks;
    private static String data;

    @BeforeAll
    static void beforeAll() {
        notNull = new NotNull();
        isSsn = new IsSsn();
        data = null;
    }

    @BeforeEach
    void setUp() {
        System.out.println("Next test:");
    }

    @Test
    void performsOneValidityCheck(){
        ValidityChecker.checkValidity(notNull, data);
    }

    @Test
    void performsSeveralValidityChecks(){
        ValidityChecker.checkValidity(List.of(notNull, isSsn), data);

    }
}
