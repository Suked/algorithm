/**
 * 删列造序 给定一个字符串数组，返回字符串数组中字符不是按字典升序排列的列
 */
public class MinDeletionSize {
    public static int minDeletionSize(String[] strs){
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++){
            for (int j = 1; j < strs.length; j++){
                if (strs[j - 1].charAt(i) > strs[j].charAt(i)){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
