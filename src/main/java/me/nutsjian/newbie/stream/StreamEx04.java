package me.nutsjian.newbie.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamEx04 {
    private static int length(final String name) {
        System.out.println("getting length for " + name);
        return name.length();
    }
    private static String toUpper(final String name ) {
        System.out.println("converting to uppercase: " + name);
        return name.toUpperCase();
    }
    public static void main(final String[] args) {
        List<String> names = Arrays.asList("Brad", "Kate", "Kim", "Jack", "Joe", "Mike", "Susan", "George", "Robert", "Julia", "Parker", "Benson");

        final String firstNameWith3Letters = names.stream()
                .filter(name -> length(name) == 3)
                .map(name -> toUpper(name))
                .findFirst()
                .get();

        System.out.println(firstNameWith3Letters);

        final String result = names.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String name) {
                return length(name) == 3;
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(String name) {
                return toUpper(name);
            }
        }).findFirst().get();
        System.out.println(result);
    }
}
