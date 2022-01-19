package com.github.gnxt.string;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

/**
 * StringUtil Class, used to alter/customize the string
 */
public class StringUtil implements IStringUtil {

    // Class Constant
    private String finalString;
    private String finalDelimiter = COMMA;

    StringBuilder stringBuilder = new StringBuilder();

    /**
     * Constructur
     */
    public StringUtil() {
    }

    /**
     * Constructor with String
     *
     * @param string Provide the String that needs treatment
     */
    public StringUtil(String string) {
        this.finalString = string;
    }

    /**
     * Constructor with String and Delimiter
     *
     * @param string Provide the String that needs treatment
     * @param delimiter Provide the Delimiter that need to be used in the operations
     */
    public StringUtil(String string, String delimiter) {
        this.finalString = string;
        this.finalDelimiter = delimiter;
    }

    /**
     * Setter for the class String variable
     *
     * @param string Provide the String that needs treatment
     */
    public StringUtil setString(String string) {
        this.finalString = string;
        return this;
    }

    /**
     * Setter for the class String Delimiter variable
     *
     * @param delimiter Provide the Delimiter that need to be used in the operations
     * @return This class will be returned
     */
    public StringUtil setdelimiter(String delimiter) {
        this.finalDelimiter = delimiter;
        return this;
    }

    /**
     * Get String with regex
     *
     * @param open Provide the start of the String that needs treatment
     * @param close Provide the end of the String that needs treatment
     * @return This class will be returned
     */
    public StringUtil getStringBetween(String open, String close) {
        return getStringBetween(this.finalString, open, close);
    }

    /**
     * Get String with regex
     *
     * @param string Provide the String that needs treatment
     * @param open Provide the start of the String that needs treatment
     * @param close Provide the end of the String that needs treatment
     * @return This class will be returned
     */
    public StringUtil getStringBetween(String string, String open, String close) {
        this.finalString = StringUtils.substringBetween(string, open, close);
        return this;
    }

    /**
     * Get number in given String, use it only if the final string is already populated
     *
     * @return This class will be returned
     */
    public StringUtil getNumbersFromString() {
        return getNumbersFromString(this.finalString);
    }

    /**
     * Get number in given String
     *
     * @param string Provide the String that needs treatment
     * @return This class will be returned
     */
    public StringUtil getNumbersFromString(String string) {
        this.finalString = string.replaceAll("[^0-9]+", EMPTY);
        return this;
    }

    /**
     * Add a prefix to the finalString
     *
     * @param string Provide the String that needs treatment
     * @return This class will be returned
     */
    public StringUtil addPrefix(String string) {
        stringBuilder.append(string);
        stringBuilder.append(this.finalString);
        this.finalString = stringBuilder.toString();
        stringBuilder.setLength(0);
        return this;
    }

    /**
     * Remove particular subString from finalString
     *
     * @param remove Provide the String that need to be removed from the finalString
     * @return This class will be returned
     */
    public StringUtil removeFromString(String remove) {
        return removeFromString(this.finalString, remove);
    }

    /**
     * Remove particular subString from input String
     *
     * @param string Provide the String that needs treatment
     * @param remove Provide the String that need to be removed from the finalString
     * @return This class will be returned
     */
    public StringUtil removeFromString(String string, String remove) {
        this.finalString = string.replaceAll(remove, EMPTY);
        return this;
    }

    /**
     * Remove special characters from finalString
     *
     * @return This class will be returned
     */
    public StringUtil removeSpecialCharacters() {
        return removeSpecialCharacters(this.finalString);
    }

    /**
     * Remove special characters from String
     *
     * @param string Provide the String that needs treatment
     * @return This class will be returned
     */
    public StringUtil removeSpecialCharacters(String string) {
        this.finalString = string.replaceAll("[^a-zA-Z0-9]", EMPTY);
        return this;
    }

    /**
     * Replace only first occurrence of finalString chars with desired chars
     *
     * @param oldString Provide the old String that need to be replaced
     * @param newString Provide the new String that needs treatment
     * @return This class will be returned
     */
    public StringUtil replaceFirstOccurrence(String oldString, String newString) {
        return replaceFirstOccurrence(this.finalString, oldString, newString);
    }

    /**
     * Replace only first occurrence of chars with desired chars
     *
     * @param string Provide the String that needs treatment
     * @param oldString Provide the old String that need to be replaced
     * @param newString Provide the new String that needs treatment
     * @return This class will be returned
     */
    public StringUtil replaceFirstOccurrence(String string, String oldString, String newString) {
        this.finalString = string.replaceFirst(oldString, newString);
        return this;
    }

    /**
     * Replace all occurrences of the oldString in finalString with newString
     *
     * @param oldString Provide the old String that need to be replaced
     * @param newString Provide the new String that needs treatment
     * @return This class will be returned
     */
    public StringUtil replaceAllOccurrences(String oldString, String newString) {
        return replaceAllOccurrences(this.finalString, oldString, newString);
    }

    /**
     * Replace all occurrences of the oldString in input with newString
     *
     * @param string Provide the String that needs treatment
     * @param oldString Provide the old String that need to be replaced
     * @param newString Provide the new String that needs treatment
     * @return this
     */
    public StringUtil replaceAllOccurrences(String string, String oldString, String newString) {
        this.finalString = string.replaceAll(oldString, newString);
        return this;
    }

    /**
     * Random Number generation
     *
     * @param length Provide the Length of Random Number
     * @return This class will be returned
     */
    public StringUtil generateRandomNumber(Integer length) {
        StringBuilder maxNumString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            maxNumString.append(9);
            i++;
        }
        int maxNum = Integer.parseInt(maxNumString.toString());
        this.finalString = String.valueOf(new Random().nextInt(maxNum));
        return this;
    }

    /**
     * Random Number generation
     *
     * @param minimum Provide the Minimum Number
     * @param maximum Provide the Maximum Number
     * @return This class will be returned
     */
    public StringUtil generateRandomNumber(int minimum, int maximum) {
        this.finalString = String.valueOf(minimum + (int) (Math.random() * maximum));
        return this;
    }

    /**
     * Trim the finalString
     *
     * @return This class will be returned
     */
    public StringUtil trim() {
        this.finalString = this.finalString.trim();
        return this;
    }

    /**
     * convert finalString to LowerCase
     *
     * @return This class will be returned
     */
    public StringUtil toLowerCase() {
        return toLowerCase(this.finalString);
    }

    /**
     * convert given String to LowerCase
     *
     * @param string Provide the String that needs treatment
     * @return This class will be returned
     */
    public StringUtil toLowerCase(String string) {
        this.finalString = string.toLowerCase();
        return this;
    }

    /**
     * convert finalString to UpperCase
     *
     * @return This class will be returned
     */
    public StringUtil toUpperCase() {
        return toLowerCase(this.finalString);
    }

    /**
     * convert given String to UpperCase
     *
     * @param string Provide the String that needs treatment
     * @return This class will be returned
     */
    public StringUtil toUpperCase(String string) {
        this.finalString = string.toLowerCase();
        return this;
    }

    /**
     * Get Length of finalString
     *
     * @return finalString length will be returned as Integer
     */
    public int getLength() {
        return this.finalString.length();
    }

    /**
     * Get the final string value
     *
     * @return finalString will be returned
     */
    public String finish() {
        return this.finalString;
    }

    /*----------------------------------------------------------------------------------------------------
    ------------------------------- VALIDATIONS ARE LISTED BELOW -----------------------------------------
    ------------------------------------------------------------------------------------------------------*/

    /**
     * Check if finalString contains given text
     *
     * @param contains Provide the text to validate if it contains in finalString
     * @return Boolean will be returned
     */
    public boolean contains(String contains) {
        return contains(this.finalString, contains);
    }

    /**
     * check if original string contains given text
     *
     * @param original Provide the String that needs treatment
     * @param contains Provide the text to validate if it contains in original String
     * @return Boolean will be returned
     */
    public boolean contains(String original, String contains) {
        return this.finalString.contains(contains);
    }

    /**
     * check if finalString equals given text
     *
     * @param equals Provide the text to validate if it equals to finalString
     * @return Boolean will be returned
     */
    public boolean equals(String equals) {
        return this.finalString.contains(equals);
    }

    /**
     * check if original string equals given text
     *
     * @param original Provide the String that needs treatment
     * @param equals Provide the text to validate if it equals to finalString
     * @return Boolean will be returned
     */
    public boolean equals(String original, String equals) {
        return this.finalString.contains(equals);
    }

    /*----------------------------------------------------------------------------------------------------
    ------------------------------- CONVERSIONS ARE LISTED BELOW -----------------------------------------
    ------------------------------------------------------------------------------------------------------*/

    /**
     * Convert the string to Integer
     *
     * @return Integer will be returned
     */
    public Integer convertToInt() {
        return Integer.parseInt(this.finalString);
    }

    /**
     * Split the finalString using the finalDelimiter
     *
     * @return String Array will be returned
     */
    public String[] convertToStringArray() {
        return convertToStringArray(this.finalString, this.finalDelimiter);
    }

    /**
     * Split the finalString with the delimiter and return the String Array.
     *
     * @param delimiter Provide the Delimiter that need to be used in the operations
     * @return String Array will be returned
     */
    public String[] convertToStringArray(String delimiter) {
        return convertToStringArray(this.finalString, delimiter);
    }

    /**
     * Split the String according to delimiter and return the array of String.
     *
     * @param original Provide the String that needs treatment
     * @param delimiter Provide the Delimiter that need to be used in the operations
     * @return String Array will be returned
     */
    public static String[] convertToStringArray(String original, String delimiter) {
        return original.split(delimiter);
    }


    /**
     * Convert String with Dollar Amount to plain String
     * e.g. $2,000.00 -> 2000
     *
     * @param original Provide the String that needs treatment
     * @return Formatted String will be returned
     */
    public String formatDollarAmountToPlainString(String original) {
        String amount = original.substring(0, original.indexOf("."));
        amount = getNumbersFromString(amount).finish();
        return amount;
    }

    /**
     * Convert plain String to Dollar Amount formatted string
     * e.g. 1000 -> $1,000.00
     *
     * @param string Provide the String that needs treatment
     * @return Formatted String will be returned
     */
    public static String formatPlainStringToDollarAmount(String string) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        return numberFormat.format(new BigDecimal(string));
    }

    /**
     * Coverts string to arraylist seperated by given delimiter
     * e.g. if input String is '1,2,3' and default delimiter is COMMA.
     *
     * @return ArrayList String will be returned
     */
    public ArrayList<String> convertToArrayList() {
        return convertToArrayList(this.finalString, this.finalDelimiter);
    }

    /**
     * Coverts string to arraylist seperated by given delimiter
     * e.g. if input String is '1,2,3' and delimiter is ','. This will be converted to a List.
     *
     * @param delimiter Provide the Delimiter that need to be used in the operations
     * @return ArrayList String will be returned
     */
    public ArrayList<String> convertToArrayList(String delimiter) {
        return convertToArrayList(this.finalString, delimiter);
    }

    /**
     * Coverts string to arraylist seperated by given delimiter
     * e.g. if input String is '1,2,3' and delimiter is ','. This will be converted to a List.
     *
     * @param string Provide the String that needs treatment
     * @param delimiter Provide the Delimiter that need to be used in the operations
     * @return ArrayList String will be returned
     */
    public ArrayList<String> convertToArrayList(String string, String delimiter) {
        return new ArrayList<>(Arrays.asList(string.split("\\s*" + delimiter + "\\s*")));
    }

    /**
     * Replace Boolean values to Pass or Fail
     *
     * @param string Provide the String that needs treatment
     * @return Replaced String will be returned
     */
    public static String replaceBooleanToPassFail(String string) {
        return string == null ? EMPTY : string.trim().replaceAll("true", "PASS").replaceAll("false", "FAIL")
                .replaceAll("TRUE", "PASS").replaceAll("FALSE", "FAIL");
    }

    /**
     * Converts string to hashmap seperated by value
     * e.g. If input string = 'x=1,2;y=3,4' and regex = finalDelimiter
     *
     * @return HashMap (x-> 1,2 and y->3,4)
     * @throws IOException IO Exception on error(s).
     */
    public HashMap convertToHashMap() throws IOException {
        return convertToHashMap(this.finalDelimiter);
    }

    /**
     * Converts string to hashmap seperated by given delimiter
     * e.g. If input string = 'x=1,2;y=3,4' and regex = ';'
     *
     * @param delimiter Provide the Delimiter that need to be used in the operations
     * @return HashMap (x-> 1,2 and y->3,4)
     * @throws IOException IO Exception on error(s).
     */
    public HashMap convertToHashMap(String delimiter) throws IOException {
        String propFormat = this.finalString.replaceAll(delimiter, "\n");
        Properties properties = new Properties();
        properties.load(new StringReader(propFormat));
        return new HashMap<>(properties);
    }

    /**
     * Convert HashMap with String, ArrayList to HashMap String, String by providing the ArrayList index
     *
     * @param map Provide the HashMap String, ArrayList that needs treatment
     * @param index provide the ArrayList index to extract the string
     * @return HashMap String, String will be returned
     */
    public static HashMap<String, String> convertToHashMap(HashMap<String, ArrayList<String>> map, int index) {
        HashMap<String, String> data = new HashMap<>();
        ArrayList<String> columns = new ArrayList<>(map.keySet());
        for (String s : columns) {
            data.put(s, String.valueOf(map.get(s).get((index - 1))));
        }
        return data;
    }
}
