import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for (int i = 0; i < S.toCharArray().length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < S.toCharArray().length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}