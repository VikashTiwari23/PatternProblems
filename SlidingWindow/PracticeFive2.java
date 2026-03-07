package com.vikash.SlidingWindow;

import java.util.Arrays;
import java.util.List;

public class SlidingWindowsBasics2 {

    public static int maxVowels(String s,int k){
        List<Character>vowels = Arrays.asList('a','e','i','o','u');
        int left =0 ;
        int count =0;
        int maxCount= 0;
        for(int i=0;i<s.length();i++){
//            if(vowels.contains(s.charAt(i)))count++;
            if("aeiouAEIOU".indexOf(s.charAt(i))!=1) count++;
            //when window is going out of bound k
            if(i>=k){
//                if(vowels.contains(s.charAt(left))) count--;
                if("aeiouAEIOU".indexOf(s.charAt(left))!=1) count--;
                left++;
            }
            // window is formed
            if(i>=k-1){
                maxCount = Math.max(count,maxCount);
            }
        }
        return maxCount;
    }
    public static  int maxDivSubarray(int[]arr,int k,int x){
        int left = 0;
        int count = 0;

        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum%x==0) count++;
            // when is full
            if(i>=k-1){

                sum -= arr[left];
                left++;
            }
        }
        return count;
    }
    public static int minimumSumSubarray(int[]arr,int k){
        int left = 0;
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(i>=k-1){
                minSum = Math.min(minSum,sum);
                sum -= arr[left];
                left++;
            }
        }
        return minSum;
    }
    public static int maxProduct(int[]arr,int k){
        int left = 0;
        int product = 1;
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            product *= arr[i];
            if(i>=k-1){
                maxProduct = Math.max(maxProduct,product);
                if(arr[left]==0){
                    product = 1;
                    for(int j = left+1;j<arr.length;j++){
                        product *= arr[j];
                    }
                }
                else{
                    product /= arr[left];
                }
                left++;
            }
        }
        return maxProduct;
    }
    public static boolean givenSumSubarray(int[]arr,int k,int target){
        int left = 0;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(i>=k-1){
                if(sum==target) return true;
                sum -= arr[left];
                left++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
       // 1
       String s = "leetcode";
       int k = 3;
       int output = 2;
       int ans = maxVowels(s,k);
       System.out.println(ans);

       // 2
       int[]arr = {7,7,7,7};
       int k = 2;
       int x = 7;
       int Output= 2;
       int ans = maxDivSubarray(arr,k,x);
       System.out.println(ans);

       // 3
       int[]arr = {1,1,1,1};
       int k = 3;
       int Output=3;
       System.out.println(minimumSumSubarray(arr,k));

       // 4
       int[]arr = {2,3,-2,4};
       int k = 2;
       int Output= 6;
       System.out.println(maxProduct(arr,k));

       // 5
        int[]arr = {2,4,6,8};
        int k=2;
        int target = 5;
        System.out.println(givenSumSubarray(arr,k,target));
    }

}
