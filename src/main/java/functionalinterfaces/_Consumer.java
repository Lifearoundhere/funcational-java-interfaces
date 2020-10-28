package functionalinterfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Jane", "555-555-555");
        Customer customer2 = new Customer("John", "555-333-555");
        // normal java function
        greetCustomer(customer1);
        greetCustomerBi(customer2, false);
        // Consumer Functional interface
        greetCustomerConsumer.accept(customer2);
        greetCustomerBiConsumer.accept(customer1, false);
    }
    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello "+ customer.name + " Thx for registering your No. " + customer.phoneNumber );
    static BiConsumer<Customer, Boolean> greetCustomerBiConsumer = (customer, showNum) ->
            System.out.println("Hello "+ customer.name + " Thx for registering your No. " +
                    (showNum ? customer.phoneNumber: "********") );

    static void greetCustomer(Customer customer){
        System.out.println("Hello "+ customer.name + " Thx for registering your No. " + customer.phoneNumber );
    }
    static void greetCustomerBi(Customer customer, boolean showNum) {
        System.out.println("Hello " + customer.name + " Thx for registering your No. "
                + (showNum ? customer.phoneNumber: "********"));
    }
    static class Customer{
        private final String name;
        private final String phoneNumber;

        Customer(String name, String phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
}
