package com.algorithm.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Chen haoyu
 * @description
 * @date 2023/3/20
 */
public class ArrayUtils {

    public static List<Integer> buildIntegerList(int ...nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int num: nums) {
            ret.add(num);
        }
        return ret;
    }

    public static List<Integer> buildRangeList(int min, int max) {
        if (min > max) {
            return new ArrayList<>();
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = max; i >= min; i--) {
            ret.add(i);
        }
        return ret;
    }

    public static void assertArrayAsc(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i-1)) {
                throw new AssertionError("非递增数组");
            }
        }
    }

    public static void assertArrayAsc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                throw new AssertionError("非递增数组");
            }
        }
    }

    public static List<Integer> generatorArray(int length) {
        if (length <= 0) {
            return new ArrayList<>();
        }
        return new Random()
                .ints(Integer.MIN_VALUE, Integer.MAX_VALUE)
                .limit(length)
                .boxed()
                .collect(Collectors.toList());
    }

    public static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
