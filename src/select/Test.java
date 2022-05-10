package select;

public class Test {
    public static void main(String[] args) {
        int[] nums = {5,8,1,3,6,4};
        int[] res = SelectionSort.selectionSort(nums);
        for (int num : res){
            System.out.print(num + " ");
        }
    }
}
