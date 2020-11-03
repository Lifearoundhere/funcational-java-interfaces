package streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Jane", Female),
                new Person("John", Male),
                new Person("Jack", Male),
                new Person("Sky", PREFER_NOT_TO_SAY)
        );

//        Function<Person, String> personStringFunction = person -> person.name;
//        ToIntFunction<String> length = s -> s.length();
//        IntConsumer println = x -> System.out.println(x);

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        Predicate<Person> personPredicate = person -> Female.equals(person.gender);

        boolean IsOnlyFemale = people.stream()
                .allMatch(personPredicate);

        System.out.println(IsOnlyFemale);
    }
    static class Person {
        private final String name;
        private final Gender gender;


        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        Male, Female, PREFER_NOT_TO_SAY
    }
}