package com.vikash.SlidingWindow;

import java.util.*;

public class SlidingWindowsBasics1 {

    public static int maxSumSubarray(int[]arr,int k){
        int left = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(i+1-left==k){
                max = Math.max(sum,max);
                sum = sum-arr[left];
                left++;
            }
        }
        return max;
    }
    public static List<Double> average(int[]arr,int k){
        List<Double>list = new ArrayList<>();
        int left = 0;
        int sum = 0;
        for(int i =0;i<arr.length;i++){
            sum+=arr[i];
            if(i+1-left==k){
                list.add((double)sum/k);
                sum=sum-arr[left];
                left++;
            }
        }
        return list;
    }
    public static int countAnagram(String s,String p){
        if(s.length()<p.length()) return 0;
        int[]scount = new int[26];
        int []pcount = new int[26];
        for(char c : p.toCharArray()){
            pcount[c-'a']++;
        }
        int left = 0;
        int count = 0;
        for(int i=0;i<s.length();i++){
            scount[s.charAt(i)-'a']++;
            if(i+1-left==p.length()){
                if(Arrays.equals(scount,pcount)) count++;
                scount[s.charAt(left)-'a']--;
                left++;
            }
        }
        return count;
    }
    public static List<Integer> firstNegative(int[]arr,int k){
        List<Integer> ans = new ArrayList<>();
        Queue<Integer>queue = new LinkedList<>();
        int left = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0){
                queue.add(arr[i]);
            }
            // window full i+1-left==k
            if(i+1-left==k){
                ans.add(queue.isEmpty()?0:queue.peek());
                if(arr[left]<0 && !queue.isEmpty()){
                    queue.poll();
                }
                left++;
            }
        }
        return ans;
    }
    public static List<Integer>maxSubarray(int[]arr,int k){
        List<Integer>list = new ArrayList<>();
        Deque<Integer>deque = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            //remove elements out of window
            if(!deque.isEmpty() && deque.peekFirst()<=i-k){
                deque.pollFirst();
            }
            //remove smaller element from back
            while(!deque.isEmpty() && arr[deque.peekLast()]<arr[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i>=k-1){
                list.add(deque.peekFirst());
            }
        }
        return list;
    }


    public static void main(String[] args) {

        String s = "aabaabaa";
        String p = "aaba";
        System.out.println(countAnagram(s,p));
    }
}
