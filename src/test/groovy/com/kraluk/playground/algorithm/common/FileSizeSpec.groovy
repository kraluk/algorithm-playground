package com.kraluk.playground.algorithm.common

import com.kraluk.playground.algorithm.common.FileSize
import spock.lang.Specification
import spock.lang.Unroll

import static com.kraluk.playground.algorithm.common.SizeUnit.*

class FileSizeSpec extends Specification {

    @Unroll
    def "should get proper conversion from #bytes bytes to #expected #unit.getUnitString()"() {
        given:
        def fileSize = new FileSize(bytes)

        when:
        def result = fileSize.get(unit)

        then:
        assert result == expected

        where:
        bytes         || unit      || expected
        1             || BYTE      || 1
        1_00          || BYTE      || 100
        1_024         || KIBI_BYTE || 1
        1_048_576     || MEBI_BYTE || 1
        1_073_741_824 || GIBI_BYTE || 1
        1_000         || KILO_BYTE || 1
        1_000_000     || MEGA_BYTE || 1
        1_000_000_000 || GIGA_BYTE || 1
    }

    @Unroll
    def "should get default conversion from #bytes bytes to #expectedValue #expectedUnit.getUnitString()"() {
        given:
        def fileSize = new FileSize(bytes)

        when:
        def result = fileSize.get()

        then:
        with(result) {
            assert getLeft() == expectedValue
            assert getRight() == expectedUnit
        }

        where:
        bytes         || expectedUnit || expectedValue
        1_024         || KIBI_BYTE    || 1
        1_048_576     || MEBI_BYTE    || 1
        1_073_741_824 || GIBI_BYTE    || 1
    }

    @Unroll
    def "should get pretty string for #bytes bytes - #expected"() {
        given:
        def fileSize = new FileSize(bytes)

        when:
        def result = fileSize.getPrettyString()

        then:
        result == expected

        where:
        bytes         || expected
        1_024         || "1 KiB"
        1_048_576     || "1 MiB"
        1_073_741_824 || "1 GiB"
    }

    @Unroll
    def "should get pretty string for #bytes bytes and unit #unit.getUnitString() - #expected"() {
        given:
        def fileSize = new FileSize(bytes)

        when:
        def result = fileSize.getPrettyString(unit)

        then:
        assert result == expected

        where:
        bytes     || unit      || expected
        1         || BYTE      || "1 B"
        1_00      || BYTE      || "100 B"
        1_024     || KIBI_BYTE || "1 KiB"
        1_048_576 || MEBI_BYTE || "1 MiB"
        1_000     || KILO_BYTE || "1 kB"
        1_000_000 || MEGA_BYTE || "1 MB"
    }
}
