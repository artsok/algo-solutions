package io.sokovets.leetcode.easy.easy;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A cell (r, c) of an excel sheet is represented as a string "<col><row>" where:
 *
 * <col> denotes the column number c of the cell. It is represented by alphabetical letters.
 * For example, the 1st column is denoted by 'A', the 2nd by 'B', the 3rd by 'C', and so on.
 * <row> is the row number r of the cell. The rth row is represented by the integer r.
 * You are given a string s in the format "<col1><row1>:<col2><row2>", where <col1> represents the column c1, <row1> represents the row r1, <col2> represents the column c2, and <row2> represents the row r2, such that r1 <= r2 and c1 <= c2.
 *
 * Return the list of cells (x, y) such that r1 <= x <= r2 and c1 <= y <= c2. The cells should be represented as strings in the format mentioned above and be sorted in non-decreasing order first by columns and then by rows.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s = "K1:L2"
 * Output: ["K1","K2","L1","L2"]
 * Explanation:
 * The above diagram shows the cells which should be present in the list.
 * The red arrows denote the order in which the cells should be presented.
 * Example 2:
 *
 *
 * Input: s = "A1:F1"
 * Output: ["A1","B1","C1","D1","E1","F1"]
 * Explanation:
 * The above diagram shows the cells which should be present in the list.
 * The red arrow denotes the order in which the cells should be presented.
 *
 *
 * Constraints:
 *
 * s.length == 5
 * 'A' <= s[0] <= s[3] <= 'Z'
 * '1' <= s[1] <= s[4] <= '9'
 * s consists of uppercase English letters, digits and ':'.
 */
public class CellsInARangeOnAnExcelSheet2194 {

    public static void main(String[] args) {
        //System.out.println(new CellsInARangeOnAnExcelSheet2194().cellsInRange("K1:L2"));
        //System.out.println(new CellsInARangeOnAnExcelSheet2194().cellsInRange("A1:F1"));
        System.out.println(new CellsInARangeOnAnExcelSheet2194().cellsInRange1("A1:F1"));

    }

    public List<String> cellsInRange(String s) {

        //Example: A(1):C(4)

        char[] chars = s.toCharArray(); //chars [a,1,:,c,4]

        Map<Character,Integer> map = new LinkedHashMap(); //map [1-A, 2-B,3-C..]
        for (int i = 1; i <= 26; i++) {
            map.put((char)('A' + i - 1), i);
        }

        Map<Integer, Character> map1 = new LinkedHashMap(); //map1 [A-1,B-2,C-3...]
        for (int i = 1; i <= 26; i++) {
            map1.put(i, (char)('A' + i - 1));
        }


        //K1:L2
        //01234

        //In this block of code I understand range of letters
        int startFrom = map.get(chars[0]); //Example: 1
        int startUntil = map.get(chars[3]); //Example: 3

        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList();

        while (startFrom <= startUntil) {

            char columnName = map1.get(startFrom); //-> 'A'

            for (int i = 1; i <= Integer.parseInt(s.substring(4,5)); i++) { //1..4
                sb.append(columnName).append(i);
                result.add(sb.toString()); //A1,A2,A3,A4
                sb.delete(0,2);

            }

            startFrom++;
        }

        return result;

    }

    public List<String> cellsInRange1(String s) {
        int col1 = (int) s.charAt(0); //it's convert character to int. For example: K
        int col2 = (int) s.charAt(3); //it's convert character to int. For example: L

        int row1 = Character.getNumericValue(s.charAt(1)); //1
        int row2 = Character.getNumericValue(s.charAt(4)); //1

        List<String> result = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = col1; i <= col2; i++) {
            char c = (char) i;

            for (int j = row1; j <= row2; j++) {
                sb.append(c).append(j);
                result.add(sb.toString());
                sb.setLength(0);
            }

        }

        return result;
    }
}
