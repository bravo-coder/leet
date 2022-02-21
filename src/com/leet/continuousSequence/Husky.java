/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package com.leet.continuousSequence;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author husky
 */
public class Husky {
    public static void main(String[] args) {
        Integer[] s = {3, 2, 9, 4, 5, 11, 8};
        System.out.println(test(s));
    }

    public static int test(Integer[] nums) {
        // O(n)
        Set<Integer> collect = Arrays.stream(nums).collect(Collectors.toSet());

        int size = 0;
        int left = nums[1], right = nums[1];
        for (Integer num : nums) {
            if (num > left && num < right) {
                continue;
            }
            int tempLeft = num, tempRight = num, tempSize = 0;
            while (collect.contains(tempLeft - 1)) {
                tempSize++;
                tempLeft--;
            }
            left = Math.min(left, tempLeft);
            while (collect.contains(tempRight + 1)) {
                tempSize++;
                tempRight++;
            }
            System.out.println(tempLeft + "---" + tempRight);
            right = Math.max(right, tempRight);
            size = Math.max(size, tempSize + 1);
        }

        return size;
    }
}