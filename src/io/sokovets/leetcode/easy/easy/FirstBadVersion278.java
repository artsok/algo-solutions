package io.sokovets.leetcode.easy.easy;

/**
 * ou are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * Example 2:
 * <p>
 * Input: n = 1, bad = 1
 * Output: 1
 */
public class FirstBadVersion278 {

    public static void main(String[] args) {
        int i = Math.floorDiv(1063376695 + 2126753390, 2);
        System.out.println(i);
    }

    public int firstBadVersion(int n) {

        //Стратегия использовать BinarySearch (https://www.programiz.com/dsa/binary-search)
        //n/2 -> Math.floor(n/2) = 5/2 = 2;

        int left = 0;
        int right = n;
        int result = 0;

        while (left <= right) { //0..5/
            int mid = left + (right - left) / 2;

            boolean callAPIResponse = isBadVersion(mid);
            if (callAPIResponse) { //если true, то надо уменьшать
                right = mid - 1; //right=4
            } else { //если false, надо увеличивать
                left = mid + 1; //left=3
            }
            result = Math.max(left, right); //result = 2;//4//
        }

        return result;
    }


    //Реализация от 4.09.22
    public int firstBadVersion_4_09_22(int n) {
        int l = 1;
        int r = n;

        int result = 0;

        while (l <= r) {
            int mid = l + (r - l)/2;

            if (isBadVersion(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            result = mid;
        }

        //Не забываем про проверочку в конце.
        if (!isBadVersion(result)) {
            result += +1;
        }

        return result;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }

}

