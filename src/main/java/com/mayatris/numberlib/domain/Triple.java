package com.mayatris.numberlib.domain;

import com.google.common.base.Preconditions;

public class Triple {
    private static final String[] NUMBERS_BELOW_20 = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen"};
    private static final String[] POWER_OF_TENS = {
            "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    final int value;

    public Triple(final int value) {
        Preconditions.checkArgument(((value < 1000) && (value >=0)), "Triple value should be 0 <= value < 1000");
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isBelowHundred() {
        return (value < 100);
    }

    @Override
    public String toString() {
        StringBuilder stringRepresentation = new StringBuilder();
        if (isBelowHundred()) {
            appendNumberBelowHundred(value, stringRepresentation);
        } else {
            final int hundreds = value / 100;
            stringRepresentation
                    .append(NUMBERS_BELOW_20[hundreds])
                    .append(" hundred");

            int lastTwoDigits = value % 100;
            if ((lastTwoDigits) > 0) {
                stringRepresentation.append(" and ");
                appendNumberBelowHundred(lastTwoDigits, stringRepresentation);
            }
        }
        return stringRepresentation.toString();
    }

    private static void appendNumberBelowHundred(int number, StringBuilder stringBuilder) {
        if(number < 20) {
            stringBuilder.append(NUMBERS_BELOW_20[number]);
        } else {
            stringBuilder.append(POWER_OF_TENS[(number / 10) - 2]);
            final int leastSignificantDigit = number % 10;
            if (leastSignificantDigit > 0) {
                stringBuilder.append(' ').append(NUMBERS_BELOW_20[leastSignificantDigit]);
            }
        }
    }
}
