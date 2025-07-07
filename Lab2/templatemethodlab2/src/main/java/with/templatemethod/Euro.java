package with.templatemethod;

public class Euro implements ICurrencyConverter {
    @Override
    public double convert(double amount) {
        return amount * 1.1;
    }

}
