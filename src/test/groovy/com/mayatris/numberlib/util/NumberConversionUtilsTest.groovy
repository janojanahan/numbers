package com.mayatris.numberlib.util

import spock.lang.Specification

/**
 * Created by jano on 24/08/2015.
 */
class NumberConversionUtilsTest extends Specification {

    def "convertion of a negative number throws an exception" (){
        given: "a negative number"
        int number = - 100;

        when:
        NumberConversionUtils.numberBelow100ToString(number)

        then:
        thrown(IllegalArgumentException)
    }

    def "Convert numbers below 100 to string"() {
        given: "a non negative number below 20"
        def number = numericRepresentation

        expect: "a correct String representation of that number"
        stringRepresentation == NumberConversionUtils.numberBelow100ToString(number)

        where: "with test cases"
        numericRepresentation | stringRepresentation
        0 | "zero"
        1 | "one"
        2 | "two"
        3 | "three"
        4 | "four"
        5 | "five"
        6 | "six"
        7 | "seven"
        8 | "eight"
        9 | "nine"
        10 | "ten"
        11 | "eleven"
        12 | "twelve"
        13 | "thirteen"
        14 | "fourteen"
        15 | "fifteen"
        16 | "sixteen"
        17 | "seventeen"
        18 | "eighteen"
        19 | "nineteen"
        20 | "twenty"
        35 | "thirty five"
        76 | "seventy six"
        99 | "ninety nine"

    }

}
