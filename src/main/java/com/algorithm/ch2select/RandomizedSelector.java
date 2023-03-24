package com.algorithm.ch2select;

import com.algorithm.utils.ArrayUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 随机选择算法，再乱序数组中以最优O(nlogn)的时间复杂度找到第K小(大)元素
 * 时间复杂度
 *    下界 O(nlogn)
 *    上界 O(n^2)
 */
public class RandomizedSelector implements Selector {
    public static void main(String[] args) {
        int k = 3;
        List<Integer> integers = ArrayUtils.generatorArray(10);
        RandomizedSelector randomizedSelector = new RandomizedSelector();
        int select = randomizedSelector.select(integers, k);
        System.out.println("Selected: " + select);
        Collections.sort(integers);
        System.out.println(integers);
        System.out.println(integers.get(k-1));
    }

    @Override
    public int select(List<Integer> arr, int k) {
        if (arr.size() < k) {
            throw new RuntimeException();
        }
        return randomizedSelect(arr, 0, arr.size() - 1, k);
    }

    private int randomizedSelect(List<Integer> arr, int p, int r, int k) {
        if (p == r) {
            return arr.get(p);
        }
        int q = randomizedPartition(arr, p, r);
        int i = q - p + 1;
        if (i == k) {
            return arr.get(q);
        } else if (k < i) {
            return randomizedSelect(arr, p, q -1, k);
        } else {
            return randomizedSelect(arr, q +1, r, k - i);
        }
    }

    private static int randomizedPartition(List<Integer> arr, int p, int r) {
        Random rand = new Random();
        int i = rand.nextInt(r - p + 1) + p;
        ArrayUtils.swap(arr, i, r);
        return partition(arr, p, r);
    }

    private static int partition(List<Integer> arr, int p, int r) {
        int x = arr.get(r);
        int i = p - 1;
        for (int j = p; j <= r -1; j++) {
            // 将所有比x小的元素移动到左边
            if (arr.get(j) <= x) {
                i = i + 1;
                ArrayUtils.swap(arr, i, j);
            }
        }
        ArrayUtils.swap(arr, i +1, r);
        return i + 1;
    }
}
