package com.duo.algorithms.leetcode;

/**
 * @author liujie
 * @date 2022-12-27 20:16
 **/
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        //处理边界条件
        if (nums.length == 0) {
            return 0;
        }
        int i = 0, j = nums.length - 1;
        int t;
        while (i <= j) {
            if (i == j) {
                if (val == nums[i]) {
                    return i;
                } else {
                    return i + 1;
                }
            }
            while (i < j && nums[i] != val) {
                i++;
            }
            while (i < j && nums[j] == val) {
                j--;
            }
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        return -1;
    }
    /**
    * 算法思想没有变，都是用right指向要处理的位置，left指向要赋值的位置
    * @return int
    * @date 2022/12/27 23:49
    */
    public static int removeElementOpt(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right--];
            } else {
                left++;
            }
        }
        return left;
    }

    public static void test1() {
        int[] nums = {3, 2, 2, 3};
        System.out.println(removeElement(nums, 3));
    }

    public static void test2() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums, 2));
    }

    public static void test3() {
        int[] nums = {2};
        System.out.println(removeElement(nums, 3));
    }

    public static void test4() {
        int[] nums = {1};
        System.out.println(removeElement(nums, 1));
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
    }
}
