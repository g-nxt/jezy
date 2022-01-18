package io.github.sannxtgen;

import io.github.sannxtgen.date.DateUtil;
import io.github.sannxtgen.excel.ExcelReport;
import io.github.sannxtgen.excel.ExcelUtil;
import io.github.sannxtgen.string.StringUtil;

public class NxtGen {

    public StringUtil stringUtil;
    public DateUtil dateUtil;
    public ExcelUtil excelUtil;
    public ExcelReport excelReport;

    public NxtGen() {
        this.stringUtil = new StringUtil();
        this.dateUtil = new DateUtil();
        this.excelUtil = new ExcelUtil();
        this.excelReport = new ExcelReport();
    }
}
