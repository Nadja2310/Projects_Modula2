package Operation;

public class LowerCaseSO implements IStringOperation{
    @Override
    public String operate(String input) {
        return input.toLowerCase();
    }

    @Override
    public String getName() {
        return "lower_case";
    }
}
