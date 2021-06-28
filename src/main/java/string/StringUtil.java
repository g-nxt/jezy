package string;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

public class StringUtil implements IStringUtil {

    // Class Constant
    private String finalString;
    private String finaldelimiter = COMMA;

    public StringUtil() {
    }

    /**
     * Constructor with String
     *
     * @param inputString
     */
    public StringUtil(String inputString) {
        this.finalString = inputString;
    }

    /**
     * Constructor with String & Delimiter
     *
     * @param inputString
     */
    public StringUtil(String inputString, String delimiter) {
        this.finalString = inputString;
        this.finaldelimiter = delimiter;
    }

    /**
     * Setter for the class String variable
     *
     * @param finalString
     */
    public StringUtil setString(String finalString) {
        this.finalString = finalString;
        return this;
    }

    /**
     * Setter for the class String Delimiter variable
     *
     * @param finaldelimiter
     * @return
     */
    public StringUtil setdelimiter(String finaldelimiter) {
        this.finaldelimiter = finaldelimiter;
        return this;
    }

    /**
     * Get String with regex
     *
     * @param open
     * @param close
     * @return
     */
    public StringUtil getStringBetween(String open, String close) {
        return getStringBetween(this.finalString, open, close);
    }

    /**
     * Get String with regex
     *
     * @param input
     * @param open
     * @param close
     * @return
     */
    public StringUtil getStringBetween(String input, String open, String close) {
        this.finalString = StringUtils.substringBetween(input, open, close);
        return this;
    }

    /**
     * Get number in given String, use it only if the final string is already populated
     *
     * @return
     */
    public StringUtil getNumbersFromString() {
        return getNumbersFromString(this.finalString);
    }

    /**
     * Get number in given String
     *
     * @param input
     * @return
     */
    public StringUtil getNumbersFromString(String input) {
        this.finalString = input.replaceAll("[^0-9]+", EMPTY);
        return this;
    }

    /**
     * Remove particular subString from finalString
     *
     * @param removeString
     * @return
     */
    public StringUtil removeFromString(String removeString) {
        return removeFromString(this.finalString, removeString);
    }

    /**
     * Remove particular subString from input String
     *
     * @param input
     * @param removeString
     * @return
     */
    public StringUtil removeFromString(String input, String removeString) {
        this.finalString = input.replaceAll(removeString, EMPTY);
        return this;
    }

    /**
     * Remove special characters from finalString
     *
     * @return
     */
    public StringUtil removeSpecialCharacters() {
        return removeSpecialCharacters(this.finalString);
    }

    /**
     * Remove special characters from String
     *
     * @param input
     * @return
     */
    public StringUtil removeSpecialCharacters(String input) {
        this.finalString = input.replaceAll("[^a-zA-Z0-9]", EMPTY);
        return this;
    }

    /**
     * Replace only first occurrence of finalString chars with desired chars
     *
     * @param oldString
     * @param newString
     * @return
     */
    public StringUtil replaceFirstOccurrence(String oldString, String newString) {
        return replaceFirstOccurrence(this.finalString, oldString, newString);
    }

    /**
     * Replace only first occurrence of chars with desired chars
     *
     * @param input
     * @param oldString
     * @param newString
     * @return this
     */
    public StringUtil replaceFirstOccurrence(String input, String oldString, String newString) {
        this.finalString = input.replaceFirst(oldString, newString);
        return this;
    }

    /**
     * Replace all occurrences of the oldString in finalString with newString
     *
     * @param oldString
     * @param newString
     * @return this
     */
    public StringUtil replaceAllOccurrences(String oldString, String newString) {
        return replaceAllOccurrences(this.finalString, oldString, newString);
    }

    /**
     * Replace all occurrences of the oldString in input with newString
     *
     * @param input
     * @param oldString
     * @param newString
     * @return this
     */
    public StringUtil replaceAllOccurrences(String input, String oldString, String newString) {
        this.finalString = input.replaceAll(oldString, newString);
        return this;
    }

    /**
     * Random Number generation
     *
     * @param length
     * @return
     * @throws Exception
     */
    public StringUtil generateRandomNumber(Integer length) throws Exception {
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
     * @param minimum
     * @param maximum
     * @return
     * @throws Exception
     */
    public StringUtil generateRandomNumber(int minimum, int maximum) throws Exception {
        this.finalString = String.valueOf(minimum + (int) (Math.random() * maximum));
        return this;
    }

    /**
     * Trim the finalString
     *
     * @return
     */
    public StringUtil trim() {
        this.finalString = this.finalString.trim();
        return this;
    }

    /**
     * Get Length of finalString
     *
     * @return
     */
    public int getLength() {
        return this.finalString.length();
    }

    /**
     * Get the final string value
     *
     * @return
     */
    public String finish() {
        return this.finalString;
    }

    /*----------------------------------------------------------------------------------------------------
    ------------------------------- CONVERSIONS ARE LISTED BELOW -----------------------------------------
    ------------------------------------------------------------------------------------------------------*/

    /**
     * Convert the string to Integer
     *
     * @return
     */
    public Integer convertToInt() {
        return Integer.parseInt(this.finalString);
    }

    /**
     * Split the finalString using the finalDelimiter
     *
     * @return
     */
    public String[] splitString() {
        return splitString(this.finalString, this.finaldelimiter);
    }

    /**
     * Split the finalString with the delimiter and return the String Array.
     *
     * @param delimiter
     * @return
     */
    public String[] splitString(String delimiter) {
        return splitString(this.finalString, delimiter);
    }

    /**
     * Split the String according to delimiter and return the array of String.
     *
     * @param input
     * @param delimiter
     * @return
     */
    public static String[] splitString(String input, String delimiter) {
        return input.split(delimiter);
    }


    /**
     * Convert String with Dollar Amount to plain String
     * e.g. $1,000.00 -> 1000
     *
     * @param input
     * @return
     */
    public String formatDollarAmountToPlainString(String input) {
        String amount = input.substring(0, input.indexOf("."));
        amount = getNumbersFromString(amount).finish();
        return amount;
    }

    /**
     * Convert plain String to Dollar Amount formatted string
     * e.g. 1000 -> $1,000.00
     *
     * @param input
     * @return
     */
    public static String formatPlainStringToDollarAmount(String input) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        return numberFormat.format(new BigDecimal(input));
    }

    /**
     * Coverts string to arraylist seperated by given delimiter
     * e.g. if input String is '1,2,3' and default delimiter is COMMA.
     *
     * @return
     */
    public ArrayList<String> stringToArrayList() {
        return stringToArrayList(this.finalString, this.finaldelimiter);
    }

    /**
     * Coverts string to arraylist seperated by given delimiter
     * e.g. if input String is '1,2,3' and delimiter is ','. This will be converted to a List.
     *
     * @param delimiter
     * @return
     */
    public ArrayList<String> stringToArrayList(String delimiter) {
        return stringToArrayList(this.finalString, delimiter);
    }

    /**
     * Coverts string to arraylist seperated by given delimiter
     * e.g. if input String is '1,2,3' and delimiter is ','. This will be converted to a List.
     *
     * @param input
     * @param delimiter
     * @return
     */
    public ArrayList<String> stringToArrayList(String input, String delimiter) {
        return new ArrayList<>(Arrays.asList(input.split("\\s*" + delimiter + "\\s*")));
    }

    /**
     * Replace Boolean values to Pass or Fail
     *
     * @param string
     * @return
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
     * @throws IOException
     */
    public HashMap convertToHashMap() throws IOException {
        return convertToHashMap(this.finaldelimiter);
    }

    /**
     * Converts string to hashmap seperated by given delimiter
     * e.g. If input string = 'x=1,2;y=3,4' and regex = ';'
     *
     * @param delimiter
     * @return HashMap (x-> 1,2 and y->3,4)
     * @throws IOException
     */
    public HashMap convertToHashMap(String delimiter) throws IOException {
        String propFormat = this.finalString.replaceAll(delimiter, "\n");
        Properties properties = new Properties();
        properties.load(new StringReader(propFormat));
        return new HashMap<>(properties);
    }

    /**
     * Convert HashMap<String, ArrayList> to HashMap<String, String> by providing the ArrayList index
     *
     * @param map
     * @param index
     * @return
     */
    public static HashMap<String, String> hashmapConversion(HashMap<String, ArrayList> map, int index) {
        HashMap<String, String> data = new HashMap<>();
        ArrayList<String> columns = new ArrayList<>(map.keySet());
        for (String s : columns) {
            data.put(s, String.valueOf(map.get(s).get((index - 1))));
        }
        return data;
    }
}
