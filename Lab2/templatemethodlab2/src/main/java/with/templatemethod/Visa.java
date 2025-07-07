package with.templatemethod;

public class Visa extends PaymentMethod{
    @Override
    void processPayment(double amount, Customer customer, VisaCard visaCard) {
        boolean validation = validate(visaCard);
        if (validation) {

            System.out.println("Make payment with visa card with card number " + visaCard.getCreditCardNumber()
                    + " and amount $" + amount);


            System.out.println("Notify customer " + customer.getName() + " with email " + customer.getEmail()
                    + " about visa credit card payment with card number " + visaCard.getCreditCardNumber());
        }

    }

    private boolean validate(VisaCard visaCard) {

        System.out.println("Validate visa card with card number " + visaCard.getCreditCardNumber());
        return true;
    }

    @Override
    void processPayment(double amount, Customer customer, String paypalAddress) {
        return;
    }

}
