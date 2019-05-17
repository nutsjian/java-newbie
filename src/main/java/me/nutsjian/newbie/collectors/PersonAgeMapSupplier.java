package me.nutsjian.newbie.collectors;

import me.nutsjian.newbie.testdata.entity.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PersonAgeMapSupplier implements Supplier<Map<Integer, Person>> {
    @Override
    public Map<Integer, Person> get() {
        return new HashMap<>();
    }
}
