package org.cern.secondExercise;

public class Office {

    public static SpreadsheetImpl newSpreadsheet(int rows, int cols) {
        return new SpreadsheetImpl(rows, cols);
    }
}
