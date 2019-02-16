package com.kraluk.playground.algorithm.common;

import org.apache.commons.lang3.tuple.Pair;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static java.lang.String.format;
import static org.apache.commons.lang3.Validate.isTrue;

/**
 * Stores file size depending on the chosen reference system {@link UnitType} - binary or SI.
 *
 * @author lukasz
 * @see <a href="https://physics.nist.gov/cuu/Units/binary.html">Unit systemes</a>
 */
public final class FileSize {

    private static final UnitType DEFAULT_TYPE = UnitType.BINARY;

    private static final String PRETTY_PATTERN = "%s %s";
    private static final String PRETTY_FORMAT = "#,##0.#";
    private static final DecimalFormat PRETTY_DECIMAL_FORMAT = new DecimalFormat(PRETTY_FORMAT);

    private final long size; // in bytes

    // Just for caching purposes
    private final SizeUnit defaultUnit;
    private final double defaultResult;
    private final String defaultPrettyString;

    public FileSize(long size) {
        isTrue(size > 0, "Size cannot be less than zero!");

        this.size = size;

        final int defaultGroup = (int) (Math.log10(size) / Math.log10(DEFAULT_TYPE.getBase()));
        this.defaultUnit = SizeUnit.get(DEFAULT_TYPE, defaultGroup);

        this.defaultResult = get(defaultUnit);
        this.defaultPrettyString = getPrettyString(defaultUnit);
    }

    public Pair<Double, SizeUnit> get() {
        return Pair.of(defaultResult, defaultUnit);
    }

    public double get(final SizeUnit sizeUnit) {
        return size / Math.pow(sizeUnit.getType().getBase(), sizeUnit.getDigitGroup());
    }

    public String getPrettyString() {
        return defaultPrettyString;
    }

    public String getPrettyString(final SizeUnit sizeUnit) {
        if (size <= 0) {
            return BigDecimal.ZERO.toString();
        }

        final int base = sizeUnit.getType().getBase();
        final int digitGroups = (int) (Math.log10(size) / Math.log10(base));
        return format(
            PRETTY_PATTERN,
            PRETTY_DECIMAL_FORMAT.format(size / Math.pow(base, digitGroups)),
            sizeUnit.getUnitString());
    }
}
