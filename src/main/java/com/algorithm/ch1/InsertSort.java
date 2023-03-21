package com.algorithm.ch1;

import com.algorithm.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Chen haoyu
 * @description
 * @date 2023/3/20
 */
public class InsertSort implements Sort{


    @Override
    public List<Integer> sort(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return list;
        }
        int n = list.size();
        for (int i = 1; i < n; i++) {
            if (list.get(i) > list.get(i - 1)) {
                continue;
            }
            int temp = list.get(i);
            int j = binarySearch(list, 0, i - 1, temp);
            if (j == -1) {
                continue;
            }
            move(list, j, i);
            list.set(j, temp);

//            for (int j = 0; j < i; j++) {
//                if (list.get(i) < list.get(j)) {
//                    int temp = list.get(i);
//                    move(list, j, i);
//                    list.set(j, temp);
//                    break;
//                }
//            }
        }
        return list;
    }

    public void move(List<Integer> list, int moveBegin, int moveEnd) {
        if (moveBegin > moveEnd) {
            return;
        }
        for (int i = moveEnd; i > moveBegin; i--) {
            list.set(i, list.get(i-1));
        }
    }

    public int binarySearch(List<Integer> list, int begin, int end,  int target) {
        int l = begin, r = end;
        int ret = -1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (list.get(mid) >= target) {
                ret = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        List<Integer> list = ArrayUtils.buildIntegerList(10, 9, 11, 0, 5, 5, 4, 3, 2, 1);
        InsertSort insertSort = new InsertSort();
        System.out.println(insertSort.sort(list));
    }
}
