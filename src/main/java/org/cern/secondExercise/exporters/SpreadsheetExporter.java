package org.cern.secondExercise.exporters;

import org.cern.secondExercise.*;

public abstract class SpreadsheetExporter {

    private SpreadsheetImpl spreadsheet;

    public SpreadsheetExporter(SpreadsheetImpl spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    public SpreadsheetImpl getSpreadsheet() {
        return spreadsheet;
    }

    abstract public String export();
}
