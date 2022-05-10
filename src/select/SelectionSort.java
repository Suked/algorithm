package select;

/**
  * @Description 选择排序
  * @author kt
  * @return null
  * @date 2022/5/10 13:26
  */
public class SelectionSort {
    public static int[] selectionSort(int[] nums){
        //总共比较n-1轮，因为最后一轮就剩最后一个数字
        for (int i = 0; i < nums.length - 1; i++){
            //
            int min = i;

            //从第i + 1个数开始循环
            for (int j = i + 1; j < nums.length; j++){
                //记录最小的值的下标，并赋值给min
                if (nums[j] < nums[min]){
                    min = j;
                }
            }

            if (i != min){
                //使用加法交换律来对两个值进行交换，从而省去变量得创建
                int tmp = nums[i];
                nums[i] = nums[min];
                nums[min] = tmp;
            }
        }



        return nums;
    }
}
