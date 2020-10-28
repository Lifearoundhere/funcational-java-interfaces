package functionalinterfaces;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionURL());
        System.out.println(getDBConnectionURLsSupplier.get());
    }

    static String getDBConnectionURL (){
        return "jdbc://localhost5432/users";
    }
    static Supplier<List<String>> getDBConnectionURLsSupplier = () ->
            List.of("jdbc://localhost5432/users", "jdbc://localhost5432/customer");
}
