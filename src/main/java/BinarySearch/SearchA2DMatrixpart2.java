package BinarySearch;

import java.util.Scanner;

public class SearchA2DMatrixpart2 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        int i=row-1;
        int j=0;
        while(i>=0 && j<col){
            int val = matrix[i][j];
            if(val==target) {
                return true;
            } else if(val > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] mat=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                mat[i][j]=scanner.nextInt();
        }
        int target=scanner.nextInt();
        System.out.println(searchMatrix(mat, target));
    }
}
/*
Write an efficient algorithm that searches for a value target in an m x n integer
matrix matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.


Example 1:


Input: matrix = [[1,4,7,11,15],
                  [2,5,8,12,19],
                  [3,6,9,16,22],
                  [10,13,14,17,24],
                  [18,21,23,26,30]],
                  target = 5
Output: true
Example 2:


Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]],
target = 20
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109
* */