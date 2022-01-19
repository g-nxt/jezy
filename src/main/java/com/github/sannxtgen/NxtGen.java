package com.github.sannxtgen;

import com.github.sannxtgen.date.DateUtil;
import com.github.sannxtgen.excel.ExcelReport;
import com.github.sannxtgen.excel.ExcelUtil;
import com.github.sannxtgen.string.StringUtil;

/**
 * This class is kind of a DSL setup, invoke this and get access to all available classes from here
 */
public class NxtGen {

    public StringUtil stringUtil;
    public DateUtil dateUtil;
    public ExcelUtil excelUtil;
    public ExcelReport excelReport;

    /**
     * This method is invoking and setting all the available class variables defined in the class
     */
    public NxtGen() {
        this.stringUtil = new StringUtil();
        this.dateUtil = new DateUtil();
        this.excelUtil = new ExcelUtil();
        this.excelReport = new ExcelReport();
    }
}
