package functionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        // Function (1 augment and 1 result)
        int increment = increment(0);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyByTenFunction.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> combination =
                incrementByOneFunction.andThen(multiplyByTenFunction);
        System.out.println(combination.apply(2));

        //BiFunction (2 augment and 1 result)

        System.out.println(incrementByOneAndMultiply(2, 10));

        System.out.println(incrementByOneAndMultiplyBiFunction.apply(2, 10));
    }
    static int increment(int number){
        return number + 1;
    }
    static  int incrementByOneAndMultiply(int number, int multiple ){
        return (number + 1) * multiple;
    }

    static Function<Integer,Integer> incrementByOneFunction =
            number -> number++;

    static Function<Integer,Integer> multiplyByTenFunction =
            number -> number * 10;

    static BiFunction<Integer,Integer,Integer> incrementByOneAndMultiplyBiFunction =
            (number, multiple ) -> (number + 1) * multiple;
}
