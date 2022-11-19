package io.sokovets.leetcode.easy.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string path, which is an absolute path (starting with a slash '/') to a file or directory in a Unix-style file system, convert it to the simplified canonical path.
 *
 * In a Unix-style file system, a period '.' refers to the current directory, a double period '..' refers to the directory up a level, and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'. For this problem, any other format of periods such as '...' are treated as file/directory names.
 *
 * The canonical path should have the following format:
 *
 * The path starts with a single slash '/'.
 * Any two directories are separated by a single slash '/'.
 * The path does not end with a trailing '/'.
 * The path only contains the directories on the path from the root directory to the target file or directory (i.e., no period '.' or double period '..')
 * Return the simplified canonical path.
 *
 *
 *
 * Example 1:
 *
 * Input: path = "/home/"
 * Output: "/home"
 * Explanation: Note that there is no trailing slash after the last directory name.
 * Example 2:
 *
 * Input: path = "/../"
 * Output: "/"
 * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
 * Example 3:
 *
 * Input: path = "/home//foo/"
 * Output: "/home/foo"
 * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
 *
 *
 * Constraints:
 *
 * 1 <= path.length <= 3000
 * path consists of English letters, digits, period '.', slash '/' or '_'.
 * path is a valid absolute Unix path.
 */
public class SimplifyPath71 {
    public static void main(String[] args) {
        System.out.println(new SimplifyPath71().simplifyPath("/home//foo/"));
    }

    public String simplifyPath(String path) {

        String[] paths = path.split("/");

        Deque<String> queuePath = new ArrayDeque<>();

        ///home//foo/

        for (String p : paths) {
            if (p == null || p.equals(".") || p.length() == 0) {
                continue;
            } else if (p.equals("..")) {
                if (!queuePath.isEmpty()) {
                    queuePath.pollLast();
                }
            } else {
                queuePath.addLast(p);
                //Notes: queuePath.push(p);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queuePath.isEmpty()) {
            sb.append("/").append(queuePath.pollFirst());
        }

        return sb.length() > 0 ? sb.toString() : "/";
    }
}
