import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i : nums) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1]; // 下标为0其实不被使用
        for (Integer key : frequencyMap.keySet()) {
            Integer frequecy = frequencyMap.get(key);
            if (buckets[frequecy] == null) {
                buckets[frequecy] = new ArrayList<>();
            }
            buckets[frequecy].add(key);
        }
        List<Integer> topKList = new ArrayList<>(k);
        for (int i = buckets.length - 1; i > 0 && topKList.size() < k; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= k - topKList.size()) {
                topKList.addAll(buckets[i]);
            } else {
                topKList.addAll(buckets[i].subList(0, k - topKList.size()));
            }
        }
        return topKList;
    }
}