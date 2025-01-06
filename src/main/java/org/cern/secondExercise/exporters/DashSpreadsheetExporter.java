package org.cern.secondExercise.exporters;

import org.cern.secondExercise.SpreadsheetImpl;
import static org.cern.secondExercise.Constants.DASH_SIGN;

public class DashSpreadsheetExporter extends SpreadsheetExporter {

    public DashSpreadsheetExporter(SpreadsheetImpl spreadsheet) {
        super(spreadsheet);
    }

    @Override
    public String getCorrespondingSign() {
        return DASH_SIGN;
    }
}
