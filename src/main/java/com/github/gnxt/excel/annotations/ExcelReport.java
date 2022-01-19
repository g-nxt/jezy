package com.github.gnxt.excel.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation class to invoke the required excel file and column info
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExcelReport {
    String reportPath() default "";

    String reportName() default "jezy_Report.xlsx";

    String[] columnNames();
}
