package com.algorithm.ch1;

import com.algorithm.utils.ArrayUtils;

import java.util.List;

/**
 *
 * 以大顶堆为例
 * 每次要做的是把最大的元素放到数组末尾，而不是把最小元素放在前面。、
 * 注意大顶堆不是顺序二叉树
 * @author Chen haoyu
 * @description
 * @date 2023/3/21
 */
public class HeapSort implements Sort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        List<Integer> list = ArrayUtils.buildRangeList(0, 10);
        heapSort.sort(list);
        ArrayUtils.assertArrayAsc(list);
    }

    @Override
    public List<Integer> sort(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return list;
        }
        int size = list.size();
        for (int i = size / 2 - 1; i >= 0; i--) {
            buildMaxHeap(list, i, size);
        }

        for (int i = size - 1; i >= 0; i--) {
            swap(list, 0, i);
            buildMaxHeap(list,0, i);
        }
        return list;
    }


    private void buildMaxHeap(List<Integer> list, int i, int size) {
        int temp = list.get(i);
        for (int k = i * 2 + 1; k < size; k = k * 2 + 1) {
            if (k + 1 < size && list.get(k) < list.get(k + 1)) {
                k++;
            }
            if (list.get(k) > temp) {
                list.set(i, list.get(k));
                i = k;
            } else {
                break;
            }
        }
        list.set(i, temp);
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
