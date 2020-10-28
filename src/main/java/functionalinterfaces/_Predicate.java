package functionalinterfaces;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("07000000000");
        System.out.println(isPhoneNumValid("07000000000"));
        System.out.println("08000000000");
        System.out.println(isPhoneNumValid("08000000000"));

        System.out.println(isPhoneNumValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumValidPredicate.test("08000000000"));
        System.out.println("Chaining predicates");
        System.out.println(isPhoneNumValidPredicate.and(containsZeroPredicate).test("07000000000"));
        System.out.println(isPhoneNumValidPredicate.or(containsZeroPredicate).test("08000000000"));

        // use can use BiPredicate instead on chaining
    }

    static boolean isPhoneNumValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }
    static Predicate<String> isPhoneNumValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsZeroPredicate = phoneNumber ->
            phoneNumber.contains("0");
}
