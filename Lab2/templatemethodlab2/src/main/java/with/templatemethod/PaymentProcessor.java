package with.templatemethod;

public class PaymentProcessor {
    private PaymentMethod visaPayment = new Visa();
    private PaymentMethod paypalPayment = new Paypal();

    protected void proccessPayment(double amount, CurrencyTypes type, PaymentTypes paymentType, Customer customer,
                                   VisaCard visaCard, String paypalAddress) {
        double convertedAmount = CurrencyConverter.currencyConvert(type, amount);

        if (null != visaCard) {
            visaPayment.processPayment(convertedAmount, customer, visaCard);
        }
        else if (null != paypalAddress) {
            paypalPayment.processPayment(convertedAmount, customer, paypalAddress);
        }
    }
}
