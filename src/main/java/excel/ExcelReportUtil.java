package excel;

import org.testng.Assert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelReportUtil {

    // Class Constants, columns names to store data
    private final ArrayList<String> data = new ArrayList<>();
    private String filePath;
    private String fileName;

    // Constructor supports n number of column data
    /**
     * Constructor
     *
     * @param data
     */
    public ExcelReportUtil(String... data) {
        this.data.addAll(Arrays.asList(data));
    }

    /**
     * Initiate the excel report by adding the columns for excel report
     * Note: This initiate function should be called only from the @Test methods no additional inheritance allowed
     *
     * @param excelReportUtilList
     * @return
     * @throws ClassNotFoundException
     */
    public ExcelReportUtil initiate(List<ExcelReportUtil> excelReportUtilList) throws ClassNotFoundException {
        // Add column data if condition is met
        if (this.data.isEmpty() && excelReportUtilList.isEmpty()) {
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
            ExcelReport excelReport = method.getAnnotation(ExcelReport.class);
            this.filePath = excelReport.reportPath();
            this.fileName = excelReport.reportName();
            data.addAll(Arrays.asList(excelReport.columnNames()));
            // If the annotation parameters are missing the value, error will be thrown
            if (this.filePath == null || this.fileName == null || data.isEmpty())
                Assert.fail("reportPath or reportName should not be null, please specify them in the @ExcelReport annotation");
        }
        // Return this class object only if the path and file name is found for the report
        if (getFilePath() == null && getFileName() == null)
            return null;
        else
            return this;
    }

    // Getters

    /**
     * Get Data <ArrayList> from the class variable data
     *
     * @return
     */
    public List<String> getData() {
        return data;
    }

    /**
     * Get FilePath class variable value
     *
     * @return
     */
    public String getFilePath() {
        return this.filePath;
    }

    /**
     * Get FileName class variable value
     *
     * @return
     */
    public String getFileName() {
        return this.fileName;
    }
}
