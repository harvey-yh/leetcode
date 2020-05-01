package 剑指offer;

/**
 * @author Harvey
 * @date 2020/5/1
 * @slogan Drive business with technology, make business generate value.
 */
public class 二维数组的查找 {
    public boolean Find(int target, int [][] array) {
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[0].length;j++){
                if(target == array[i][j]){
                    return true;
                }else if(target < array[i][j]){
                    break;
                }
            }
        }
        return false;
    }
    public boolean Find1(int target, int [][] array) {
        if(array == null || array.length==0 | array[0].length==0){
            return false;
        }
        int row = 0, col = array[0].length-1;
        while(row < array.length && col >= 0){
            if(array[row][col] == target){
                return true;
            }else if(array[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
