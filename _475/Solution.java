package _475;

import java.util.Arrays;

/**
 * @author klhu03
 * @since 2024/12/13 11:22
 **/
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0, j = 0; i < houses.length; i++) {
            int curDistance = Math.abs(houses[i] - heaters[j]);
            while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(houses[i] - heaters[j + 1])) {
                j++;
                curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
            }
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }
}
