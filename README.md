Jezy [Jezy_Report.pdf](https://github.com/g-nxt/jezy/files/7894997/Jezy_Report.pdf)

Jezy is made to make developers life easy. This package will assist in writing excel files, Formatting & Converting String in an easy manner.

> ### **Steps to generate the Excel Report**

### **Initialization**

Initialize a List of Excel Report Util Class
`List<ExcelReportUtil> excelReportUtilList = new ArrayList<>();`

Initialize the Jezy class
`Jezy jezy = new Jezy();`

### **Annotation**

Add the annotation @ExcelReport to any of your test method
`@ExcelReport(reportPath = "", reportName = "", columnNames = {"S.No", "testName", "Name", "Description"})`

_Details about the parameters in the ExcelReport annotation:_
reportPath = “” [default] (optional)
reportName = jezy_Report.xlsx [default] (optional)
columnNames = This is mandatory field, can add ’n’ number of columns

### **Report related code in test method**

Initiate the excel report
`jezy.excelReportUtil.initiate(excelReportUtilList);`

Add a new row to the report
`jezy.excelReportUtil.newRow("1", "Test 1" + "Name 1" + "Description 1");`
`jezy.excelReportUtil.newRow("2", "Test 2" + "Name 2" + "Description 2");`

Keep adding the newRow 'n' number of times based on the requirement

### **Closing and generating the report**
In the afterSuite (If using TestNG) or when you are ready to export the report write the below line
`jezy.excelUtil.writeExcel(excelReportUtilList);`
