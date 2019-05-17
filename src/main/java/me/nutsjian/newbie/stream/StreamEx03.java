package me.nutsjian.newbie.stream;


import java.io.BufferedReader;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamEx03 {

    public static void main(String[] args) {
        // Stream<Integer>、Stream<Long>、Stream<Double>
        // 但是 boxing 和 unboxing 会很耗时，所以特别为这三种基本数值提供了对应的 Stream

        IntStream intStream = IntStream.builder().build();
        LongStream longStream = LongStream.builder().build();
        DoubleStream doubleStream = DoubleStream.builder().build();


    }

}
