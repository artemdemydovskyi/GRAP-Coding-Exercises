package org.cern.secondExercise;

import java.util.Map;
import java.util.HashMap;

public class SpreadsheetImpl {
    private final int rows;
    private final int cols;
    private Map<String, String> spreadSheetContent;

    public SpreadsheetImpl(int rows, int cols) {
        if(rows < 0 || cols < 0) {
            throw new IllegalArgumentException("The columns and rows' numbers couldn't be negative");
        }
        this.rows = rows;
        this.cols = cols;
        this.spreadSheetContent = new HashMap<>();
    }

    public String get(int row, int column) {
        validateCell(row, column);
        String cellKey = createCellKey(row, column);

        return spreadSheetContent.getOrDefault(cellKey, "");
    }

    public void put(int row, int column, String value) {
        validateCell(row, column);
        String cellKey = createCellKey(row, column);

        spreadSheetContent.put(cellKey, value);
    }

    private void validateCell(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= cols) {
            throw new IndexOutOfBoundsException("The row or column value is out of bounds.");
        }
    }

    private String createCellKey(int row, int column) {
        return String.format("%s:%s", row, column);
    }
}
