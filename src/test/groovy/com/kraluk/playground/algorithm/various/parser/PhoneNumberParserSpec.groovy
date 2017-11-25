package com.kraluk.playground.algorithm.various.parser

import spock.lang.Specification

class PhoneNumberParserSpec extends Specification {

    def "parse given strings to the phone number format"() {
        expect:
        PhoneNumberParser.parse(raw) == expected

        where:
        raw                               | expected
        "9944  48 1111-8861 "             | "994-448-111-188-61"
        "7 - -6-6 1985--664 "             | "766-198-56-64"
        "55537-6654   "                   | "555-376-654"
        " 7 - -6-6 1985--6647"            | "766-198-566-47"
        "7 - -6-6 198-6665--664"          | "766-198-666-56-64"
        "   7 - -6-6 198-666-4445--664"   | "766-198-666-444-56-64"
        "7 - -6-6 198-666-444-9-995--664" | "766-198-666-444-999-56-64"
        "  -6-6 "                         | "66"
        "55---55"                         | "55-55"
    }
}