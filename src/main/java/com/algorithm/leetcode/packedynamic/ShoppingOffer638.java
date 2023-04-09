package com.algorithm.leetcode.packedynamic;

import java.util.Arrays;
import java.util.List;

/**
 * 对应Leetcode 638.大礼包
 * Created By Have
 * 2023/4/9 15:36
 */
public class ShoppingOffer638 {
    public static void main(String[] args) {
        System.out.println(10 % 4 / 2);
    }

    /**
     * 巧妙的将组合的可能性转换成mask形式
     * @param price
     * @param special
     * @param needs
     * @return
     */
    public int shoppingOffers1(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = price.size();
        int[] g = new int[n + 1];
        g[0] = 1;
        for (int i = 1; i <= n; i++) {
            // 状态，对于每一个needs可能得取值为0-needs[i]种
            // 这里将g累成，最终得到所有needs取值的可能性
            // 譬如 needs = [1, 2]
            // 那么可能处于的中间状态有
            // [0, 0] [1, 0] [0, 1] [0, 2] [1, 2] [1, 1]
            // 也就是 2 * 3 = 6
            g[i] = g[i - 1] * (needs.get(i - 1) + 1);
        }
        int mask = g[n];
        int[] f = new int[mask];
        int[] cnt = new int[n];
        for (int state = 1; state < mask; state++) {
            f[state] = 0x3f3f3f3f;
            Arrays.fill(cnt, 0);
            for (int i = 0; i < n; i++) {
                // 求出第i个物品目前取几个
                //  譬如 needs = [1, 2]
                // g = [1, 2, 6]
                // cnt[0] = state % 2 / 1
                // cnt[1] = state % 6 / 2
                cnt[i] = state % g[i + 1] / g[i];
            }
            for (int i = 0; i < n; i++) {
                if (cnt[i] > 0) f[state] = Math.min(f[state], f[state - g[i]] + price.get(i));
            }
            for (List<Integer> x : special) {
                int cur = state;
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    if (cnt[i] < x.get(i)) {
                        flag = true;
                        break;
                    }
                    cur -= x.get(i) * g[i];
                }
                if (flag) continue;
                f[state] = Math.min(f[state], f[cur] + x.get(n));
            }
        }
        return f[mask - 1];
    }
}
