package with.templatemethod;

public class Paypal extends PaymentMethod{

    @Override
    void processPayment(double amount, Customer customer, String paypalAddress) {
        boolean validation = validate(paypalAddress);
        if (validation) {

            System.out.println("Make payment with paypal address " + paypalAddress + " and amount $" + amount);

            System.out.println("Notify customer " + customer.getName() + " with email " + customer.getEmail()
                    + " about paypal payment to address " + paypalAddress);
        }
    }

    private boolean validate(String paypalAddress) {

        System.out.println("Validate paypal address " + paypalAddress);
        return true;
    }

    @Override
    void processPayment(double amount, Customer customer, VisaCard visaCard) {
        return;
    }
}
