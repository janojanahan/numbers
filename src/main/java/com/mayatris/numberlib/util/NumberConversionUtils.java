package com.mayatris.numberlib.util;

import com.google.common.base.Preconditions;

/**
 * Created by jano on 24/08/2015.
 */
public class NumberConversionUtils {
    private static final String[] NUMBERS_BELOW_20 = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen"};

    public static String numberBelow20ToString(int number) {
        Preconditions.checkArgument(number >= 0, "Number has to be positive");
        return NUMBERS_BELOW_20[number];
    }
}
