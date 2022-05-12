package select;

public class Test {
    public static void main(String[] args) {
//        int[] nums = {5,8,1,3,6,4};
//        int[] res = SelectionSort.selectionSort(nums);
//        for (int num : res){
//            System.out.print(num + " ");
//        }

        int a = 5;
        int b = 8;
        a = a ^ b;
        System.out.println(a);
        b = a ^ b;
        System.out.println(b);
        a = a ^ b;
        System.out.println(a);

    }
}
