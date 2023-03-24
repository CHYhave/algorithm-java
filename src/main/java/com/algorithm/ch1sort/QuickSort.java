package com.algorithm.ch1sort;

import com.algorithm.utils.ArrayUtils;

import java.util.List;

/**
 * @author Chen haoyu
 * @description
 * @date 2023/3/21
 */
public class QuickSort implements Sort {
    public static void main(String[] args) {
        List<Integer> list = ArrayUtils.buildIntegerList(1, 3, 2, 4, 6, 8, 10, 9, 7);
        QuickSort quickSort = new QuickSort();
        quickSort.sort(list);
        System.out.println(list);
        ArrayUtils.assertArrayAsc(list);
    }

    @Override
    public List<Integer> sort(List<Integer> list) {
        quickSort(list, 0, list.size() - 1);
        return list;
    }

    private void quickSort(List<Integer> list, int begin, int end) {
        if (begin > end) return;
        int l = begin, r = end;
        int pivot = list.get(begin);

        while (l < r) {
            while (l < r && list.get(r) >= pivot) r--;
            while (l < r && list.get(l) <= pivot) l++;
            if (l <= r) {
                ArrayUtils.swap(list, l, r);
            }
        }
        list.set(begin, list.get(l));
        list.set(l, pivot);

        quickSort(list, begin, l - 1);
        quickSort(list, l + 1, end);
    }
}
