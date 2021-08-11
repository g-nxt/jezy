package excel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelReportUtil {

    public ArrayList<String> getData() {
        return data;
    }

    // Class Constants, columns names to store data
    private final ArrayList<String> data = new ArrayList<>();
    private String filePath;
    private String fileName;

    // Constructor support n number of column data
    public ExcelReportUtil(String... data) {
        this.data.addAll(Arrays.asList(data));
    }

    /**
     * Initiate the excel report by adding the columns for excel report
     *
     * @param clazz
     * @param method
     * @param excelReportUtilList
     * @return
     */
    public ExcelReportUtil initiate(Class<?> clazz, String method, List<ExcelReportUtil> excelReportUtilList) throws NoSuchMethodException {
        if (this.data.isEmpty() && excelReportUtilList.isEmpty()) {
            ExcelReport excelReport = clazz.getMethod(method).getAnnotation(ExcelReport.class);
            this.filePath = excelReport.reportPath();
            this.fileName = excelReport.reportName();
            data.addAll(Arrays.asList(excelReport.columnNames()));
        }
        return this;
    }

    // Getters
    public String getFilePath() {
        return this.filePath;
    }

    public String getFileName() {
        return this.fileName;
    }
}
