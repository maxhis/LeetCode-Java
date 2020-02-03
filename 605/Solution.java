class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int pre, next;
        for (int i = 0; i < flowerbed.length && count < n; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            pre = i == 0 ? 0 : flowerbed[i - 1];
            next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            if (pre == 0 && next == 0) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }
}