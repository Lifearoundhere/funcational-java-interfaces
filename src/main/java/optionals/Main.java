package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");

        Object val = Optional.ofNullable("Hello World")
                .orElseThrow(exception);

        System.out.println(val);
    }
}
