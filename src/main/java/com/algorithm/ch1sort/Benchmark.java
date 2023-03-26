package com.algorithm.ch1sort;

import java.util.Collections;
import java.util.List;

/**
 * @author Chen haoyu
 * @description
 * @date 2023/3/20
 */
public class Benchmark implements Sort {
    @Override
    public List<Integer> sort(List<Integer> sort) {
        Collections.sort(sort);
        return sort;
    }
}
