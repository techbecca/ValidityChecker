public class NotNull extends ValidityCheck {

    @Override
    public boolean validate(String data) {
        return data != null;
    }
}
