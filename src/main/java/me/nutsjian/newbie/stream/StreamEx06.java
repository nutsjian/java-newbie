package me.nutsjian.newbie.stream;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamEx06 {

    public static void main(String[] args) {
        // 取平均
        IntStream
                .builder()
                .add(1)
                .add(3)
                .add(5)
                .add(7)
                .add(11)
                .build()
                .average()
                .ifPresent(System.out::println);

        // 取平均
        DoubleStream.builder()
                .add(3.3)
                .add(4.4)
                .add(5.5)
                .add(1.1)
                .add(2.2)
                .build()
                .average()
                .ifPresent(System.out::println);

        // 求和
        long sum = LongStream.builder()
                .add(1L)
                .add(2L)
                .add(1200000009L)
                .build()
                .sum();
        System.out.println(sum);


        // 限制 limit
        IntStream.builder()
                .add(1)
                .add(2)
                .add(3)
                .build()
                .limit(2)
                .average()
                .ifPresent(System.out::println);

//        IntStream.builder()
//                .add(1)
//                .add(2)
//                .add(3)
//                .build()
//                .col
    }

}
