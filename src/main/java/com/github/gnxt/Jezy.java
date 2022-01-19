package com.github.gnxt;

import com.github.gnxt.date.DateUtil;
import com.github.gnxt.excel.ExcelReportUtil;
import com.github.gnxt.excel.ExcelUtil;
import com.github.gnxt.string.StringUtil;

/**
 * This class is kind of a DSL setup, invoke this and get access to all available classes from here
 */
public class Jezy {

    public StringUtil stringUtil;
    public DateUtil dateUtil;
    public ExcelUtil excelUtil;
    public ExcelReportUtil excelReportUtil;

    /**
     * This method is invoking and setting all the available class variables defined in the class
     */
    public Jezy() {
        this.stringUtil = new StringUtil();
        this.dateUtil = new DateUtil();
        this.excelUtil = new ExcelUtil();
        this.excelReportUtil = new ExcelReportUtil();
    }
}
