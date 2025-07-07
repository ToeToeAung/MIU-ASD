package with.templatemethod;

public class CurrencyConverter {
    private static ICurrencyConverter eur = new Euro();
    private static ICurrencyConverter inr = new Rupee();

    public static double currencyConvert(CurrencyTypes type, double amount) {
        switch (type) {
            case EUR:
                return eur.convert(amount);
            case INR:
                return inr.convert(amount);
            default:
                return amount;
        }
    }
}
