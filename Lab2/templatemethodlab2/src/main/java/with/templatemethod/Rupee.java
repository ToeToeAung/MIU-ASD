package with.templatemethod;

public class Rupee implements ICurrencyConverter{
    @Override
    public double convert(double amount) {
        return amount * 0.014;
    }
}
