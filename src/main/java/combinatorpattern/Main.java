package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Jane",
                "jane@gmail.com",
                "+01234556789",
                LocalDate.of(2000,01,01)
                );

        System.out.println(new CustomerValidatorService().isVaild(customer));

        // combinator pattern >>>
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);
        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
    }
}
