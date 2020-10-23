package main.java.leetcode.algorithms.easy.problems_1301_1400;

/**
 * Given a positive integer num consisting only of digits 6 and 9.
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 *
 * Example 1:
 * Input: num = 9669
 * Output: 9969
 * Explanation:
 * Changing the first digit results in 6669.
 * Changing the second digit results in 9969.
 * Changing the third digit results in 9699.
 * Changing the fourth digit results in 9666.
 * The maximum number is 9969.
 *
 * Example 2:
 * Input: num = 9996
 * Output: 9999
 * Explanation: Changing the last digit 6 to 9 results in the maximum number.
 *
 * Example 3:
 * Input: num = 9999
 * Output: 9999
 * Explanation: It is better not to apply any change.
 *
 * Constraints:
 * 1 <= num <= 10^4
 * num's digits are 6 or 9.
 */
public class Maximum69Number {
    /**
     * idea is to find the highest power digit 6 and add 3*10^power to convert 6 to 9
     */
    public int maximum69Number (int num) {
        int power = 0;
        int pos = -1;
        int temp = num;

        while(temp > 0) {
            if(temp % 10 == 6) pos = power;

            temp /= 10;
            power++;
        }

        /**
         * means the digit 6 was not found in num, which is fine since we dont have to convert anything in this case
         */
        if(pos == -1) return num;

        return num + (3 * (int) Math.pow(10,pos));
    }
}
