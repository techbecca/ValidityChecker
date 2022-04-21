import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidityChecker {

    public static void main(String[] args) {
        IsSsn isSsn = new IsSsn();
        NotNull notNull = new NotNull();
        String data = "201701112391";
        List<ValidityCheck> checks = List.of(notNull, isSsn);
        checkValidity(checks, data);
    }
    public static void checkValidity(ValidityCheck validityCheck, String data) {
        // Check validity
        boolean valid = validityCheck.validate(data);

        // if validity fails, log fail
        if (!valid) {
            System.out.println(validityCheck.failMessage());
        }
    }

    public static void checkValidity(List<ValidityCheck> validityCheckList, String data) {
        // Check validity for each element in the list
        validityCheckList.parallelStream().forEach( validityCheck -> checkValidity(validityCheck, data));

    }


}
