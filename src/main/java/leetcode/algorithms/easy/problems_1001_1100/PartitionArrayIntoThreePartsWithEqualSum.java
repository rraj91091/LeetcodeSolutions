package main.java.leetcode.algorithms.easy.problems_1001_1100;

/**
 * Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.
 * Formally, we can partition the array if we can find indexes
 * i+1 < j with (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 *
 * Example 1:
 * Input: A = [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * Example 2:
 * Input: A = [0,2,1,-6,6,7,9,-1,2,0,1]
 * Output: false
 *
 * Example 3:
 * Input: A = [3,3,6,5,-2,2,5,1,-9,4]
 * Output: true
 * Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 * Constraints:
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 */
public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int total = 0;
        for(int a : A) total += a;

        if(total % 3 != 0) return false;

        int oneThird = total / 3;
        int thirds = 0;
        int sum = 0;

        for(int i=0; i<A.length; i++) {
            sum += A[i];

            if(sum == oneThird) {
                sum = 0;
                thirds++;
            }
        }

        return (thirds >= 3);
    }

    public boolean canThreePartsEqualSumV2(int[] A) {
        int total = 0;
        for(int a : A) total += a;

        if(total % 3 != 0) return false;

        int oneThird = total / 3;
        int twoThird = total / 3;
        int index = 0;

        while(index < A.length) {
            oneThird -= A[index];
            index++;

            if(oneThird == 0) break;
        }

        while(index < A.length) {
            twoThird -= A[index];
            index++;

            if(twoThird == 0) break;
        }

        if(oneThird != 0 || twoThird != 0 || index == A.length) return false;

        return true;
    }
}
