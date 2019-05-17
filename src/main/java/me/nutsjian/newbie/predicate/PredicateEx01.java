package me.nutsjian.newbie.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateEx01 {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-1,-2,-3,-4,-5,-6,-7,-8,-9,-10,1,2,3,4,5,6,7,8,9,10);

        List<Integer> result = conditionFilter(list, number -> number > 5);
        result.forEach(System.out::println);
        System.out.println("-----------------------------------分割线-----------------------------------");
        // 结果集的反向 default negate()
        result = conditionFilterNegate(list, number -> number >= 0);
        result.forEach(System.out::println);
        System.out.println("-----------------------------------分割线-----------------------------------");
        // 多个条件 default and()，条件可以无数个
        // 大于 5 且是偶数
        result = conditionFilterAnd(list, number -> number > 5, number -> number % 2 == 0);
        result.forEach(System.out::println);
        System.out.println("-----------------------------------分割线-----------------------------------");
        // N个and条件
        result = conditionFilterMultiAnd(list, number -> number > 5, number -> number % 2 == 0, number -> number < 10);
        result.forEach(System.out::println);
    }

    private static List<Integer> conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    private static List<Integer> conditionFilterNegate(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().filter(predicate.negate()).collect(Collectors.toList());
    }

    private static List<Integer> conditionFilterAnd(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        return list.stream().filter(predicate1.and(predicate2)).collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    private static List<Integer> conditionFilterMultiAnd(List<Integer> list, Predicate<Integer> ...predicates) {
        if (predicates.length == 0) return list;
        Predicate<Integer> combinePredicate = predicates[0];
        for (int i=1; i<predicates.length; i++) {
            combinePredicate = combinePredicate.and(predicates[i]);
        }
        return list.stream().filter(combinePredicate).collect(Collectors.toList());
    }
}
