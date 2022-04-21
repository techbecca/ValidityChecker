public abstract class ValidityCheck {
    // Implementations need to be:
    // - atomic
    // - combinable in Validity Checker without affecting other Validity Checks
    public abstract boolean validate(String data);

    public String failMessage() {
        return "Validity check failed for: " + this.getClass().toString();
    }
}
