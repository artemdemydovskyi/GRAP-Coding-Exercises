package org.cern.secondExercise.exporters;

import org.cern.secondExercise.*;
import static org.cern.secondExercise.Constants.COMMA_SIGN;
import static org.cern.secondExercise.Constants.HASH_SIGN;
import static org.cern.secondExercise.Constants.MINUS_SIGN;

public class DashSpreadsheetExporter extends SpreadsheetExporter {

    public DashSpreadsheetExporter(SpreadsheetImpl spreadsheet) {
        super(spreadsheet);
    }

    public String export() {
        SpreadsheetImpl spreadsheet = getSpreadsheet();

        int rows = spreadsheet.getRows();
        int cols = spreadsheet.getCols();

        StringBuilder output = new StringBuilder();
        output.append(rows).append(COMMA_SIGN).append(cols).append(HASH_SIGN);

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                String value = spreadsheet.get(row, col);

                if (value.isEmpty()) {
                    output.append(MINUS_SIGN);
                } else {
                    output.append(value);
                    output.append(MINUS_SIGN);
                }
            }
        }

        return output.toString();
    }
}
