package select;

/**
  * @Description 冒泡排序
  * @author kt
  * @return null
  * @date 2022/5/10 13:12
  */
public class BubbleSort {
    public static int[] bubbleSort(int[] nums){
        int length = nums.length;

        //设置循环次数
        for (int i = 0; i < length; i++){
            //设置一个状态值，若是有数字交换，则状态值为false，否则直接跳出循环
            boolean flag = true;

            //从第一个开始循环，一直到倒数第i-1个
            for (int j = 0; j < length - 1 - i; j++){
                if (nums[j] > nums[j + 1]){
                    //使用加法交换律来对两个值进行交换，从而省去变量得创建
                    nums[j] += nums[j + 1];
                    nums[j + 1] = nums[j] - nums[j + 1];
                    nums[j] = nums[j] - nums[j + 1];

                    //
                    flag = false;
                }
            }
            if (flag) break;
        }
        return nums;
    }

}
