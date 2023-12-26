// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class MinPathStringFormation {
    class Solution {
        public int shortestWay(String source, String target) {
        /*Brute force- 2-pointer
        pointers at starting of each str and move one point at time and compare
        if char matches: increment both else return -1
        if source ptr is out of bounds count++ */

            int sLen = source.length();
            int tLen = target.length();

        /*Map of char and its indices in source str
        useful if source str is very long, instead of traversing whole str-> jump to next index using map
        find next index using BS on array of indices inside the map */

            Map<Character, List<Integer>> map = new HashMap<>();

            for(int i = 0; i < sLen; i++){
                char c = source.charAt(i);
                if(!map.containsKey(c)){
                    map.put(c, new ArrayList<>());
                }
                map.get(c).add(i);
            }

            int count = 1;
            int i = 0;
            int j = 0;

            while(j < tLen){
                char c = target.charAt(j);
                if(!map.containsKey(c))
                    return -1;

                List<Integer> li = map.get(c);
                int idx = binarySearch(li, i);
                if(idx >= li.size()){
                    i = 0;
                    count++;
                }
                else{
                    i = li.get(idx);
                    i++;
                    j++;
                }
            }
            return count;
        }

        private int binarySearch(List<Integer> li, int target){
            int low = 0, high = li.size() - 1;

            while(low <= high){
                int mid = low + (high - low) / 2;
                if(target == li.get(mid)){
                    return mid;
                }
                else if(li.get(mid) > target){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            return low;
        }
    }
}
