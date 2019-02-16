package com.kraluk.playground.algorithm.common;

import java.util.stream.Stream;

import static com.kraluk.playground.algorithm.common.UnitType.BINARY;
import static com.kraluk.playground.algorithm.common.UnitType.SI;
import static java.lang.String.format;
import static java.util.Objects.nonNull;

/**
 * Simple enumeration of some file size units
 *
 * @author lukasz
 * @see UnitType
 */
public enum SizeUnit {

    BYTE(0, SI, "B"),
    KILO_BYTE(1, SI, "kB"),
    MEGA_BYTE(2, SI, "MB"),
    GIGA_BYTE(3, SI, "GB"),
    TERA_BYTE(4, SI, "TB"),
    PETA_BYTE(5, SI, "PB"),
    EXA_BYTE(6, SI, "EB"),

    BYTE_BIN(0, BINARY, "B"),
    KIBI_BYTE(1, BINARY, "KiB"),
    MEBI_BYTE(2, BINARY, "MiB"),
    GIBI_BYTE(3, BINARY, "GiB"),
    TEBI_BYTE(4, BINARY, "TiB"),
    PEBI_BYTE(5, BINARY, "PiB"),
    EXBI_BYTE(6, BINARY, "EiB");

    private final int digitGroup;
    private final UnitType type;
    private final String unitString;

    SizeUnit(final int digitGroup, final UnitType type, final String unitString) {
        this.digitGroup = digitGroup;
        this.type = type;
        this.unitString = unitString;
    }

    public int getDigitGroup() {
        return digitGroup;
    }

    public String getUnitString() {
        return unitString;
    }

    public UnitType getType() {
        return type;
    }

    public static SizeUnit get(final UnitType type, final int digitGroup) {
        if (digitGroup == 0 && nonNull(type)) {
            return SizeUnit.BYTE;
        }

        return Stream.of(SizeUnit.values())
            .filter(v -> v.getType() == type)
            .filter(v -> v.getDigitGroup() == digitGroup)
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(
                format("Cannot find a unit for type '%s' and/or group '%s'",
                    type, digitGroup)));
    }
}
