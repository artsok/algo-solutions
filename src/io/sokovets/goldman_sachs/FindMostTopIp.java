package io.sokovets.goldman_sachs;
import java.util.HashMap;
import java.util.Map;
import java.util.*;


public class FindMostTopIp {

    /**
     * String findTopIpaddress(String[] lines)
     * Given an Apache log file, return IP address(es) which accesses the site most often.
     * <p>
     * Our log is in this format (Common Log Format). One entry per line and it starts with an IP address which accessed the site,
     * followed by a whitespace.
     * <p>
     * 10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] "GET /a.gif HTTP/1.0" 200 234
     * <p>
     * Log file entries are passsed as an array.
     */

    public static String findTopIpaddress(String[] lines) {

        if (Objects.isNull(lines) || lines.length == 0) {
            return null;
        }


        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String line : lines) {
            String[] subWords = line.split(" ");

            String ip = subWords[0].trim();

            if (!map.containsKey(ip)) {
                map.put(ip, 1);
            } else {
                map.merge(ip, 1, Integer::sum);
            }
        }


        String topIp = "";
        int topCount = 0;


        System.out.println(map);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > topCount) {
                topIp = entry.getKey();
                topCount = entry.getValue();
            }

            if (entry.getValue() == topCount && !topIp.contains(entry.getKey())) {
                topIp += "," + entry.getKey();
            }

        }


        return topIp;
    }

    /**
     * boolean doTestsPass()
     * Returns true if the test passes. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        // TODO: improve the test
        /**String lines[] = new String[] {
         "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
         "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
         "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234" };

         */


        /** String lines[] = new String[] {
         "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
         "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
         "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
         "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234"  };
         **/

        String lines[] = new String[]{};


        String result = findTopIpaddress(lines);


        if (result == null) {
            System.out.println("Test passed");
            return true;
        } else {
            System.out.println("Test failed");
            return false;

        }


 /*
    if (result.equals("10.0.0.1")) {
      System.out.println("Test passed");
      return true;
    } else {
      System.out.println("Test failed");
      return false;
    }
    */

/**
 if (result.equals("10.0.0.1,10.0.0.2") && result.equals("10.0.0.2,10.0.0.1")) {
 System.out.println("Test passed");
 return true;
 } else {
 System.out.println("Test failed");
 return false;
 }
 **/


    }

    public static void main(String[] args) {
        doTestsPass();
    }
}
