package com.mayatris.numberlib;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

import java.util.*;


public class NumberConversion {


    public static String convertIntToWords(int number) {
        Preconditions.checkArgument(((number < 1000000000) && (number >= 0)),
                "number should be 0 <= value < 1000000000");
        if (number == 0) return "zero";

        Deque<Triple> triples = new ArrayDeque<>(splitIntoTriples(number));
        int originalSize = triples.size();
        List<String> words = new ArrayList<>();

        if (triples.size() == 3) {
            words.add(scaleTripleToString(triples.remove(), "million"));
        }

        if (triples.size() == 2) {
            words.add(scaleTripleToString(triples.remove(), "thousand"));
        }
        words.add(handleLastTriple(triples.remove(), originalSize));

        return wordListToString(words);
    }

    static List<Triple> splitIntoTriples(int number) {
        List<Triple> listOfTriples = new ArrayList<>();
        while (number > 0) {
            int triple = number % 1000;
            listOfTriples.add(new Triple(triple));
            number /= 1000;
        }
        Collections.reverse(listOfTriples);
        return ImmutableList.copyOf(listOfTriples);
    }

    private static String scaleTripleToString(Triple triple, String scale) {
        return triple.getValue() == 0 ? null : triple.toString() + ' ' + scale;
    }

    private static String handleLastTriple(Triple triple, int originalSize) {
        if (triple.getValue() == 0) return null;
        boolean specialAndHandling = (originalSize > 1) && triple.isBelowHundred();
        return (specialAndHandling ? "and " : "") + triple.toString();
    }

    private static String wordListToString(List<String> words) {
        final Joiner joiner = Joiner.on(' ').skipNulls();
        return joiner.join(words);
    }
}
