import java.util.Arrays;
import java.util.stream.IntStream;

public class IsSsn extends ValidityCheck {
    @Override
    public boolean validate(String data) {
        // Check that data is not null or undefined or empty string
        if (data == null || data.isBlank() || data.isEmpty()) {
            return false;
        }
        // Preprocess SSN string
        String preprocessedData = data.strip().replaceAll("[\\s\\-]", "");
        int length = preprocessedData.length();

        // Check length
        if ( length != 10 && length != 12) {
            return false;
        }

        // Check if only numbers
        if (!preprocessedData.matches("\\d+")) {
            return false;
        }

        return validateSsn(preprocessedData);
    }

    private boolean validateSsn(String input) {
        System.out.println("Input is " + input);
        int ssnLength = input.length();
        int startIndex = ssnLength == 12 ? 2 : 0;
        String ssn = input.substring(startIndex);
        IntStream numberStream = ssn.chars();
        int[] numbers = numberStream.map(Character::getNumericValue).toArray();

        int control = numbers[9];
        System.out.println("Control is " + control);
        System.out.println("---------");
        int aggregate = 0;

        // Iterate through all numbers except control number
        for (int i = 0; i < numbers.length-1; i++) {
            int current = (int) numbers[i];
            System.out.println("Current number  is " + current);
            // Check modulus to alternate between multiplication with 1 or 2
            int multiple = i % 2 == 0 ? 2 : 1;
            System.out.println("Multiplying with " + multiple + "...");
            current *= multiple;
            System.out.println("Result is " + current);
            // Check if there are two digits after multiplication
            if (Math.floor(current/10) != 0) {
                // If so, add those two digits together
                System.out.println("Adding digits together...");
                current = (int) (Math.floor(current/10) + (current % 10));
                System.out.println("Result is " + current);
            }

            // Add result to the aggregate
            System.out.println("Adding result to aggregate...");
            aggregate += current;
            System.out.println("Aggregate is now " + aggregate);
        }

        System.out.println("Final aggregate: " + aggregate);
        // Take aggregate modulo 10
        int finalNumber = aggregate % 10;
        System.out.println("Modulo 10 gives: " + finalNumber);
        // Subtract result from 10
        finalNumber = 10 - finalNumber;
        System.out.println("10 - previous result gives: " + finalNumber);
        // Take result modulo 10 for final number
        finalNumber = finalNumber % 10;
        System.out.println("Modulo 10 gives final control number: " + finalNumber);

        // Return true if final number matches control
        return finalNumber == control;
    }




}
