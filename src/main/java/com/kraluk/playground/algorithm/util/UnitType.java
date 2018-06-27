package com.kraluk.playground.algorithm.util;

import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * Provides supported reference systems considered as unit types in the context of file size problem
 *
 * @author lukasz
 */
public enum UnitType {

    BINARY(1_024),
    SI(1_000);

    private final int base;

    UnitType(int base) {
        this.base = base;
    }

    public int getBase() {
        return base;
    }

    public static UnitType get(final int base) {
        return Stream.of(UnitType.values())
            .filter(v -> v.getBase() == base)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(
                format("Cannot find a type for base '%s'", base)));
    }
}
