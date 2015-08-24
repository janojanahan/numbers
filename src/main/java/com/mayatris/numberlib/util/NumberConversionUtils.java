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
    private static final String[] POWER_OF_TENS = {
            "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public static String numberBelow100ToString(int number) {
        Preconditions.checkArgument(number >= 0, "Number has to be positive");
        if(number < 20) {
            return NUMBERS_BELOW_20[number];
        }
        StringBuilder representation = new StringBuilder()
                .append(POWER_OF_TENS[(number / 10) - 2]);
        final int leastSignificantDigit = number % 10;
        if(leastSignificantDigit > 0) {
            representation.append(' ').append(NUMBERS_BELOW_20[leastSignificantDigit]);
        }
        return representation.toString();
    }
}
