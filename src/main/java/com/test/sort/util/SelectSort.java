package com.test.sort.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SelectSort {

    private static final Logger logger = LoggerFactory.getLogger(SelectSort.class);

    /**
     * 选择排序算法
     * 在未排序序列中找到最小元素，存放到排序序列的起始位置
     * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
     * 以此类推，直到所有元素均排序完毕。
     *
     * @param source
     */
    public static long sort(int[] source) {
        int[] numbers = source.clone();
        long startTime = System.currentTimeMillis();
        int size = numbers.length; //数组长度
        int temp = 0; //中间变量
        for (int i = 0; i < size; i++) {
            int k = i;   //待确定的位置
            //选择出应该在第i个位置的数
            for (int j = size - 1; j > i; j--) {
                if (numbers[j] < numbers[k]) {
                    k = j;
                }
            }
            //交换两个数
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
        long endTime = System.currentTimeMillis();
        logger.info("selectSort耗时：" + (endTime - startTime) + "ms");
        logger.info(JSON.toJSONString(numbers));
        return  endTime - startTime;
    }
}