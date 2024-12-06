package 搜索二维矩阵two240;

/**
 * @author klhu03
 * @since 2024/12/05 10:15
 **/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        while(i < matrix.length-1 && matrix[i][0] < target){i++;}
        i--;
        int j = 0;
        while(j < matrix[0].length && matrix[i][j] < target){j++;}
        j--;
        if(matrix[i][j] == target){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ma = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        solution.searchMatrix(ma, 5);
    }
}