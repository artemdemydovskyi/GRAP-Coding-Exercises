package org.cern.secondExercise;

import java.util.Map;
import java.util.HashMap;

public class SpreadsheetImpl {
    private final int rows;
    private final int cols;
    private final Map<String, String> spreadSheetContent;

    public SpreadsheetImpl(int rows, int cols) {
        if (rows < 0 || cols < 0) {
            throw new IllegalArgumentException("The columns and rows' numbers couldn't be negative");
        }
        this.rows = rows;
        this.cols = cols;
        this.spreadSheetContent = new HashMap<>();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public String get(int row, int column) {
        validateCell(row, column);
        String cellKey = createCellKey(row, column);

        return spreadSheetContent.getOrDefault(cellKey, "");
    }

    public void put(int row, int column, String value) {
        validateCell(row, column);
        String cellKey = createCellKey(row, column);

        String trimmedValue = value.trim();
        ValueType valueType = ValueTypeIdentifier.identifyValueType(trimmedValue);

        if (ValueType.INTEGER == valueType) {
            spreadSheetContent.put(cellKey, trimmedValue);
        } else {
            spreadSheetContent.put(cellKey, value);
        }
    }

    public ValueType getValueType(int row, int col) {
        validateCell(row, col);

        String value = get(row, col);

        return ValueTypeIdentifier.identifyValueType(value);
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
