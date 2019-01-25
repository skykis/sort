package com.test.sort;

import com.alibaba.fastjson.JSON;
import org.jetbrains.annotations.NotNull;

public class Sort {
    public static void main(String[] args) {
        int n[] = new int[100000];
        for (int i = 0; i < 100000; i++) {
            n[i] = (int) (Math.random() * 100);
        }
        System.out.println(JSON.toJSON(n));
        BubbleSort.sort(n);
        QuickSort.sort(n);
    }




}
