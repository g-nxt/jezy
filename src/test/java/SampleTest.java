import com.github.gnxt.Jezy;
import com.github.gnxt.excel.ExcelReportUtil;
import com.github.gnxt.excel.annotations.ExcelReport;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SampleTest {

    // Initialize a List of Excel Report Util Class
    List<ExcelReportUtil> excelReportUtilList = new ArrayList<>();
    // Initialize the Jezy class
    Jezy jezy = new Jezy();

    // Add the annotation @ExcelReport to any of your test method
    @Test(testName = "Jezy Test", description = "Jezy Test")
    @ExcelReport(columnNames = {"S.No", "testName", "Name", "Description"})
    public void newTest() throws ClassNotFoundException {

        // Initiate the excel report
        jezy.excelReportUtil.initiate(excelReportUtilList);

        int[] list = IntStream.range(1, 20).toArray();
        for (Integer integer : list) {
            String iterator = integer.toString();
            // Add a new row to the report
            jezy.excelReportUtil.newRow(iterator, "Test " + iterator, "Name " + iterator, "Description " + iterator);
        }
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        // In the afterSuite (If using TestNG) or when you are ready to export the report write the below line
        jezy.excelUtil.writeExcel(excelReportUtilList);
    }
}

