package BinarySearch;

import java.util.Scanner;

public class KthSmallestElementinaSortedMatrix {
//    public static int countNumFunction(int[][] mat, int n, int m, int val){
//
//    }
//    public static int kthSmallest(int[][] matrix, int k) {
//
//    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] mat=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                mat[i][j]=scanner.nextInt();
        }
        int targer=scanner.nextInt();
        //System.out.println(kthSmallest(mat, targer));
    }
}
