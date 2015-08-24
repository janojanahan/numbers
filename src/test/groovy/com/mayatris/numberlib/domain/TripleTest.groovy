package com.mayatris.numberlib.domain

import spock.lang.Specification

class TripleTest extends Specification {

    def "creating a triple outside the range of [0..999] should throw an exception"() {
        when: "trying to initialise a tripe with a number below 0"
        new Triple(-10)

        then: "an IllegalArgumentException to be thrown"
        thrown(IllegalArgumentException)

        when: "trying to initialise a tripe with a number above 999"
        new Triple(1000)

        then: "an IllegalArgumentException to be thrown"
        thrown(IllegalArgumentException)
    }

    def "given a valid triple, expect toString to return the String representation"() {
        given: "a non negative number below 100"
        def triple = new Triple(numericRepresentation)

        expect: "a correct String representation of that number"
        stringRepresentation == triple.toString()

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
        123 | "one hundred and twenty three"
        200 | "two hundred"
        999 | "nine hundred and ninety nine"
    }

}
