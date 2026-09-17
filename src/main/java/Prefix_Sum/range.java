package Prefix_Sum;

import java.util.Arrays;

public class range {

    int[] prefix;
    public range(int[] nums){
        prefix=new int[nums.length];
        prefix[0]=nums[0];

        for(int i=1;i<nums.length;i++)
            prefix[i]=prefix[i-1]+nums[i];

    }
    public int sumRange(int left, int right){
        if(left==0)
            return prefix[right];
        return prefix[right]-prefix[left-1];

    }

    public static void main(String[] args) {
        range r1=new range(new int[]{1,2,3,4,5,6});
        System.out.println(r1.sumRange(3,4));

    }
}
