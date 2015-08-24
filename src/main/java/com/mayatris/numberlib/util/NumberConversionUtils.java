package com.mayatris.numberlib.util;

import com.google.common.collect.ImmutableList;
import com.mayatris.numberlib.domain.Triple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberConversionUtils {

    public static List<Triple> splitIntoTriples(int number) {
        List<Triple> listOfTriples= new ArrayList<>();
        while(number > 0) {
            int triple = number % 1000;
            listOfTriples.add(new Triple(triple));
            number /= 1000;
        }
        Collections.reverse(listOfTriples);
        return ImmutableList.copyOf(listOfTriples);
    }
}
