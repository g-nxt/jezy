import date.DateUtil;
import excel.ExcelReportUtil;
import excel.ExcelUtil;
import string.StringUtil;

public class Jezy {

    StringUtil stringUtil;
    DateUtil dateUtil;
    ExcelUtil excelUtil;
    ExcelReportUtil excelReportUtil;

    public Jezy() {
        this.stringUtil = new StringUtil();
        this.dateUtil = new DateUtil();
        this.excelUtil = new ExcelUtil();
        this.excelReportUtil = new ExcelReportUtil();
    }
}
