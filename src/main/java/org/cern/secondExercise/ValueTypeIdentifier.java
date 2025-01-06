package org.cern.secondExercise;

import java.util.*;
import static org.cern.secondExercise.Constants.EQUALS_SIGN;

public class ValueTypeIdentifier {

    public static ValueType identifyValueType(String value) {

        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("The passed value is null, it's type cannot be defined.");
        }

        if (isFormula(value)) {
            return ValueType.FORMULA;
        }

        if (isInteger(value)) {
            return ValueType.INTEGER;
        }

        return ValueType.STRING;
    }

    private static boolean isFormula(String value) {
        return value.startsWith(EQUALS_SIGN);
    }

    private static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
