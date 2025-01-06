package org.cern.secondExercise.exporters;

import org.cern.secondExercise.SpreadsheetImpl;
import static org.cern.secondExercise.Constants.COMMA_SIGN;
import static org.cern.secondExercise.Constants.HASH_SIGN;

public abstract class SpreadsheetExporter {

    private final SpreadsheetImpl spreadsheet;

    public SpreadsheetExporter(SpreadsheetImpl spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    public abstract String getCorrespondingSign();

    public String export() {

        int rows = spreadsheet.getRows();
        int cols = spreadsheet.getCols();

        StringBuilder output = new StringBuilder();
        output.append(rows).append(COMMA_SIGN).append(cols).append(HASH_SIGN);
        
        String correspondingSign = getCorrespondingSign();

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                String value = spreadsheet.get(row, col);

                if (value.isEmpty()) {
                    output.append(correspondingSign);
                } else {
                    output.append(value);
                    output.append(correspondingSign);
                }
            }
        }

        return output.toString();
    }
}
