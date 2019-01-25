package com.test.sort.util;

import com.alibaba.fastjson.JSON;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuickSort {

    private static final Logger logger = LoggerFactory.getLogger(QuickSort.class);

    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numbers 带查找数组
     * @param low     开始位置
     * @param high    结束位置
     * @return 中轴所在位置
     */
    private static int getMiddle(int[] numbers, int low, int high) {
        int temp = numbers[low]; //数组的第一个作为中轴
        while (low < high) {
            while (low < high && numbers[high] >= temp) {//从右向左找第一个
                //小于等于基准值得index
                high--;
            }
            numbers[low] = numbers[high];//比中轴小的记录移到低端
            while (low < high && numbers[low] <= temp) {//从左向右找第一个
                //大于等于基准值的index
                low++;
            }
            numbers[high] = numbers[low]; //比中轴大的记录移到高端
        }
        numbers[low] = temp; //中轴记录到尾
        return low; // 返回中轴的位置
    }

    /**
     * @param numbers 带排序数组
     * @param low     开始位置
     * @param high    结束位置
     */
    private static void quick(int[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high); //将numbers数组进行一分为二
            quick(numbers, low, middle - 1);   //对低字段表进行递归排序
            quick(numbers, middle + 1, high); //对高字段表进行递归排序
        }
    }

    /**
     * 快速排序
     *
     * @param source 带排序数组
     */
    public static long sort(@NotNull int[] source) {
        int[] numbers = source.clone();
        long startTime = System.currentTimeMillis();
        if (numbers.length > 0) {
            //查看数组是否为空
            quick(numbers, 0, numbers.length - 1);
        }
        long endTime = System.currentTimeMillis();
        logger.info("quickSort耗时：" + (endTime - startTime) + "ms");
        logger.info(JSON.toJSONString(numbers));
        return  endTime - startTime;
    }
}
