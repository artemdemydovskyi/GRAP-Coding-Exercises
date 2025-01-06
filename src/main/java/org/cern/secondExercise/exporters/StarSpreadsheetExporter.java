package org.cern.secondExercise.exporters;

import org.cern.secondExercise.SpreadsheetImpl;
import static org.cern.secondExercise.Constants.ASTERISK_SIGN;

public class StarSpreadsheetExporter extends SpreadsheetExporter {

    public StarSpreadsheetExporter(SpreadsheetImpl spreadsheet) {
        super(spreadsheet);
    }

    @Override
    public String getCorrespondingSign() {
        return ASTERISK_SIGN;
    }
}

