package com.github.sannxtgen.excel;

import com.github.sannxtgen.date.DateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Excel util to process the file
 */
public class ExcelUtil {

    /**
     * Class Constants
     */
    public static final String EMPTY = "";
    public static final String HH_MM_SS = "HH-mm-ss";
    public static final String MMDDYYYY = "MMddyyyy";
    public static final String DOT_XLS = ".xls";
    public static final String UNDERSCORE = "_";
    public static final String XLSX = "xlsx";
    public static final String XLS = "xls";
    private final String tempDir = System.getProperty("java.io.tmpdir");

    /**
     * Method to write list of POJO objects to Excel File
     *
     * @param outputObjectList Provide the list of data objects to write excel output
     * @throws IOException IO Exception
     */
    public void writeExcel(List<ExcelReport> outputObjectList) throws IOException {
        if (!outputObjectList.isEmpty()) {
            outputObjectList.removeAll(Collections.singleton(null));
            String excelFilePath = outputObjectList.get(0).getFilePath() + outputObjectList.get(0).getFileName()
                    // Added date and time stamp to the file suffix to avoid failure in producing the report in case the old file is opened by another process/user,
                    // below replace all will handle both .xls & .xlsx files
                    .replaceAll(DOT_XLS, UNDERSCORE + com.github.sannxtgen.date.DateUtil.getDate(MMDDYYYY) + UNDERSCORE + DateUtil.getTime(HH_MM_SS) + DOT_XLS);
            Workbook workbook = getWorkbook(excelFilePath);
            Sheet sheet = workbook.createSheet();
            int rowCount = 0;
            for (ExcelReport outputObject : outputObjectList) {
                Row row = sheet.createRow(rowCount);
                writeBook((ArrayList<String>) outputObject.getData(), row);
                ++rowCount;
            }
            try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
                workbook.write(outputStream);
            }
        }
    }

    /**
     * Method to write the data to work sheet in given row
     *
     * @param outputRowData Provide the Data in the Row
     * @param row           Provide the apache poi Row
     */
    private void writeBook(ArrayList<String> outputRowData, Row row) {
        for (int i = 0; i < outputRowData.size(); i++) {
            Cell cell = row.createCell(i);
            String outputData = outputRowData.get(i);
            cell.setCellValue(outputData == null ? EMPTY : outputData);
        }
    }

    /**
     * Method to return appropriate "xls" or Xlsx" workbook based on the file path
     *
     * @param fileName Provide the file name including the path
     * @return apache poi Workbook object will be returned
     * @throws IOException IO Exception on any error(s).
     */
    private Workbook getWorkbook(String fileName) throws IOException {
        Workbook workbook;
        if (fileName.endsWith(XLSX)) {
            workbook = new XSSFWorkbook();
        } else if (fileName.endsWith(XLS)) {
            workbook = new HSSFWorkbook();
        } else {
            throw new IOException("The file name does not have the Excel file format: " + fileName);
        }
        return workbook;
    }

    /**
     * If a file doesn't exist, a new file and a sheet will be created
     *
     * @param fileName  Provide the file name including the path
     * @param sheetName Provide the tab/sheet name in excel file
     * @throws IOException IO Exception on any error(s).
     */
    public void fileHandler(String fileName, String sheetName) throws IOException {
        File file = new File(fileName);
        // Retrieve the workbook
        XSSFWorkbook workbook;
        // Check file existence
        if (!file.exists()) {
            // Create new file if it does not exist
            workbook = new XSSFWorkbook();
        } else {
            try (
                    // If file exist initiate the instance
                    InputStream is = new FileInputStream(file)) {
                workbook = new XSSFWorkbook(is);
            }
        }
        XSSFSheet spreadsheet = workbook.getSheet(sheetName);
        if (spreadsheet == null) {
            // Create the sheet if the expected sheet doesn't exist in the file
            workbook.createSheet(sheetName);
        }
        FileOutputStream out = new FileOutputStream(file);
        workbook.write(out);
        workbook.close();
    }

    /**
     * Create a copy of file in temp directory
     *
     * @param fileName Provide the input File Name including the path
     * @throws IOException Io Exception on error(s).
     */
    public void copyFileToTemp(String fileName) throws IOException {
        String excelFileName;
        if (fileName.contains("\\")) {
            excelFileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
        } else {
            excelFileName = fileName.substring(fileName.lastIndexOf("/") + 1);
        }
        String outputSheet = tempDir + excelFileName;
        copyFile(fileName, outputSheet);
    }

    /**
     * Method overload to copy spreadsheet from one location to other
     *
     * @param sourceFileName Provide the source file name including the path
     * @param destFileName   Provide the destination file name including the path
     * @throws IOException IO Exception on error(s).
     */
    public void copyFile(String sourceFileName, String destFileName) throws IOException {
        Path FROM = Paths.get(sourceFileName);
        Path TO = Paths.get(destFileName);
        //overwrite existing file, if exists
        CopyOption[] options = new CopyOption[]{
                StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES
        };
        try {
            Files.copy(FROM, TO, options);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
