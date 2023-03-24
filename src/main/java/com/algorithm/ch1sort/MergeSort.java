package com.algorithm.ch1sort;

import com.algorithm.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen haoyu
 * @description
 * @date 2023/3/20
 */
public class MergeSort implements Sort{

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        List<Integer> list = ArrayUtils.buildIntegerList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
        List<Integer> sort = mergeSort.sort(list);
        ArrayUtils.assertArrayAsc(sort);
    }

    @Override
    public List<Integer> sort(List<Integer> list) {
        mergeSort(list, 0, list.size() - 1);
        return list;
    }

    private void mergeSort(List<Integer> list, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) >> 1;
        mergeSort(list, begin, mid);
        mergeSort(list, mid + 1, end);
        int i = begin, j = mid + 1;
        List<Integer> arr = new ArrayList<>();
        while (i <= mid && j <= end) {
            if (list.get(i) > list.get(j)) {
                arr.add(list.get(j++));
            } else {
                arr.add(list.get(i++));
            }
        }
        int k = i <= mid? i: j;
        while (k <= end) {
            arr.add(list.get(k++));
        }

        for (int l = begin; l <= end; l++) {
            list.set(l, arr.get(l - begin));
        }
    }
}
