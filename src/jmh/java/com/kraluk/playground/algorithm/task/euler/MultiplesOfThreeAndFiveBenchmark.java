package com.kraluk.playground.algorithm.task.euler;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
public class MultiplesOfThreeAndFiveBenchmark {

    @Param({"1000", "1000000", "1000000000"})
    public long limit;

    @Benchmark
    public long calculateBenchmark() {
        return MultiplesOfThreeAndFive.calculate(limit);
    }

    @Benchmark
    public long calculateOptimizedBenchmark() {
        return MultiplesOfThreeAndFive.calculateOptimized(limit);
    }
}