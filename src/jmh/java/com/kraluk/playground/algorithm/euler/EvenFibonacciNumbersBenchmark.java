package com.kraluk.playground.algorithm.euler;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class EvenFibonacciNumbersBenchmark {

    @Param({"400000", "4000000"})
    public long maximum;

    @Benchmark
    public void calculateBenchmark(Blackhole blackhole) {
        blackhole.consume(EvenFibonacciNumbers.calculate(maximum));
    }

    @Benchmark
    public void calculateWhiledBenchmark(Blackhole blackhole) {
        blackhole.consume(EvenFibonacciNumbers.calculateWhiled(maximum));
    }

    @Benchmark
    public void calculateOptimizedBenchmark(Blackhole blackhole) {
        blackhole.consume(EvenFibonacciNumbers.calculateOptimized(maximum));
    }
}