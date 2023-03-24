package com.algorithm.test.ch2select;

import com.algorithm.ch2select.RandomizedSelector;
import com.algorithm.ch2select.Selector;
import com.algorithm.utils.ArrayUtils;
import org.junit.Test;

import java.util.List;

public class TestAndVerify {

    private void testSelect(Selector selector, int length, int k) {
        if (k > length) {
            throw new RuntimeException("k must less than length, got length + " + length + ", k " + k);
        }
        List<Integer> list = ArrayUtils.generatorArray(length);
        long begin = System.currentTimeMillis();
        int result = selector.select(list, k);
        System.out.println("Time consumed:" + (System.currentTimeMillis() - begin) + " ms.");
        ArrayUtils.assertSelectEql(list, result, k);
    }

    @Test
    public void testRandomizedSelector() {
        RandomizedSelector randomizedSelector = new RandomizedSelector();
        testSelect(randomizedSelector, 10000000, 10);
    }

}
