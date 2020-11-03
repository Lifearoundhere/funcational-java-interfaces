package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Jane", Female),
                new Person("John", Male),
                new Person("Jack", Male)
        );
        // Imperative >>>
        List<Person> females = new ArrayList<>();

        for (Person person : people){
            if (Female.equals(person.gender)){
                females.add(person);
            }
        }

        for (Person female : females){
            System.out.println(female);
        }
        // <<< Imperative
        System.out.println("Declarative >>>>");
        // Declarative >>>
        List<Person> femalesDec = people.stream()
                .filter(person -> Female.equals(person.gender))
                .collect(Collectors.toList());
        femalesDec.forEach(System.out::println);
        // <<< Declarative
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
        Male, Female
    }
}
