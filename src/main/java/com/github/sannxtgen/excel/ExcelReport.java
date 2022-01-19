package com.github.sannxtgen.excel;

import org.testng.Assert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Excel Report class will carry all the data that need to get into the excel file
 */
public class ExcelReport {

    // Class Constants, columns names to store data
    private final ArrayList<String> data = new ArrayList<>();
    private List<ExcelReport> reportUtilList;
    private String filePath;
    private String fileName;

    /**
     * Constructor supports n number of column data
     *
     * @param data Provide the column names row data
     */
    public ExcelReport(String... data) {
        this.data.addAll(Arrays.asList(data));
    }

    /**
     * Add new row of data
     *
     * @param data Provide the row data
     */
    public void newRow(String... data) {
        reportUtilList.add(new ExcelReport(data));
    }

    /**
     * Initiate the excel report by adding the columns for excel report
     * Note: This initiate function should be called only from the @Test methods no additional inheritance allowed
     *
     * @param excelReportUtilList Provide the List of ExcelReport Object
     * @throws ClassNotFoundException Class Not Found Exception on error(s).
     */
    public void initiate(List<ExcelReport> excelReportUtilList) throws ClassNotFoundException {
        // Add column data if condition is met
        if (this.data.isEmpty() && excelReportUtilList.isEmpty()) {
            this.reportUtilList = excelReportUtilList;
            StackTraceElement stackTrace = new Exception().getStackTrace()[1];
            int matchCount = 0;
            Method method = null;
            for (Method declaredMethod : Class.forName(stackTrace.getClassName()).getDeclaredMethods()) {
                if (declaredMethod.getName().equals(stackTrace.getMethodName())) {
                    method = declaredMethod;
                    matchCount++;
                }
            }
            // If More than one method match found in the declared test class and error will be thrown
            if (matchCount > 1) {
                Assert.fail("Multiple Test methods have same name in the class -> " + stackTrace.getClassName() + ", please have a unique Test method name to implement the ExcelReportUtil");
            }
            assert method != null;
            com.github.sannxtgen.excel.annotation.ExcelReport excelReport = method.getAnnotation(com.github.sannxtgen.excel.annotation.ExcelReport.class);
            this.filePath = excelReport.reportPath();
            this.fileName = excelReport.reportName();
            data.addAll(Arrays.asList(excelReport.columnNames()));
            // If the annotation parameters are missing the value, error will be thrown
            if (this.filePath == null || this.fileName == null || data.isEmpty())
                Assert.fail("reportPath or reportName should not be null, please specify them in the @ExcelReport annotation");
            this.reportUtilList.add(this);
        }
    }

    /**
     * Get Data List from the class variable data
     *
     * @return List String is retirned
     */
    public List<String> getData() {
        return data;
    }

    /**
     * Get FilePath class variable value
     *
     * @return File Path String is returned
     */
    public String getFilePath() {
        return this.filePath;
    }

    /**
     * Get FileName class variable value
     *
     * @return File Name String is returned
     */
    public String getFileName() {
        return this.fileName;
    }
}
