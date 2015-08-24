package com.mayatris.numberlib.util

import com.mayatris.numberlib.domain.Triple
import spock.lang.Specification

/**
 * Created by jano on 24/08/2015.
 */
class NumberConversionUtilsTest extends Specification {

    def "split large numbers to triples (each below 1000)"() {
        given: "a number between 0 and 999,999,999"
        int number = numericRepresentation

        when: "the number is split into triples"
        List<Triple> triples = NumberConversionUtils.splitIntoTriples(number)
        def intList = tripleListToIntList(triples)

        then: "the correct number of triples"
        intList == expectedTriples

        where:
        numericRepresentation | expectedTriples
        100000000  | [100,0,0]
        999 | [999]
        100000321 | [100,0,321]
    }

    private def tripleListToIntList(List<Triple> triples) {
        return triples.collect {x -> x.getValue()}
    }
}
