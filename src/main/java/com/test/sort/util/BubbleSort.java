package com.test.sort.util;

import com.alibaba.fastjson.JSON;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BubbleSort {

    private static final Logger logger = LoggerFactory.getLogger(BubbleSort.class);

    /**
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param source 需要排序的整型数组
     */
    public static long sort(@NotNull int[] source) {
        int[] numbers = source.clone();
        long startTime = System.currentTimeMillis();
        int temp = 0;
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1])  //交换两数位置
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        logger.info("bubbleSort耗时：" + (endTime - startTime) + "ms");
        logger.info(JSON.toJSONString(numbers));
        return  endTime - startTime;
    }
}
