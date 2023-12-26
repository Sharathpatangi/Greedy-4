// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class EqualRowFromMinDominoRotation {
    class Solution {
        public int minDominoRotations(int[] tops, int[] bottoms) {
            int topsLen = tops.length;
            int bottomsLen = bottoms.length;

        /*Optimla no extra space
        take first pair: 1st ele from each arr
        traverse considering one ele and check if next pair contains the ele
        if there : count++, else -1
        same for the other ele of the pair */

            if(topsLen != bottomsLen)
                return -1;

            int result = check(tops, bottoms, tops[0]);
            if(result != -1)
                return result;
            return check(tops, bottoms, bottoms[0]);
        }

        private int check(int[] tops, int[] bottoms, int target){
            int topRot = 0;
            int bottomRot = 0;
            int topsLen = tops.length;

            for(int i = 0; i < topsLen; i++){
                if(tops[i] != target && bottoms[i] != target)
                    return -1;

                if(tops[i] != target)
                    topRot++;

                if(bottoms[i] != target)
                    bottomRot++;
            }
            return Math.min(topRot, bottomRot);
        }
    }
}
