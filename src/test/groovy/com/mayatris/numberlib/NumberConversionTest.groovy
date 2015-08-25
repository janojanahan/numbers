package com.mayatris.numberlib

import spock.lang.Specification

class NumberConversionTest extends Specification {

    def "split large numbers to triples (each below 1000)"() {
        given: "a number between 0 and 999,999,999"
        int number = numericRepresentation

        when: "the number is split into triples"
        List<Triple> triples = NumberConversion.splitIntoTriples(number)
        def intList = tripleListToIntList(triples)

        then: "the correct number of triples"
        intList == expectedTriples

        where:
        numericRepresentation | expectedTriples
        100000000             | [100, 0, 0]
        999                   | [999]
        100000321             | [100, 0, 321]
    }

    def "Convert number to words"() {
        expect: "numbers to be converted to words"
        stringRepresentation == NumberConversion.convertIntToWords(intRepresentation)

        where: "it appears in the following test cases"
        intRepresentation | stringRepresentation
        0 | "zero"
        1 | "one"
        21 | "twenty one"
        105 | "one hundred and five"
        123 | "one hundred and twenty three"
        1005 | "one thousand and five"
        1042 | "one thousand and forty two"
        1105 | "one thousand one hundred and five"
        56945781 | "fifty six million nine hundred and forty five thousand seven hundred and eighty one"
        999999999 | "nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine"
    }

    def "attempting to convert a number not in the range 0..999,999,999 will throw an exception"() {
        when: "trying to convert a number below 0"
        NumberConversion.convertIntToWords(-1)

        then: "an IllegalArgumentException to be thrown"
        thrown(IllegalArgumentException)

        when: "trying to convert a number above 999,999,999"
        NumberConversion.convertIntToWords(1000000000)

        then: "an IllegalArgumentException to be thrown"
        thrown(IllegalArgumentException)
    }

    private static def tripleListToIntList(List<Triple> triples) {
        return triples.collect { x -> x.getValue() }
    }
}
