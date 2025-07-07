package with.templatemethod;

public abstract  class PaymentMethod {

    abstract void processPayment(double amount, Customer customer, VisaCard visaCard);

    abstract void processPayment(double amount, Customer customer, String paypalAddress);

}
