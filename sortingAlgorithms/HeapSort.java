package com.vikash.sortingAlgorithms;

class HeapSort{

    public static void heapSort(int[]arr){
        int n = arr.length;
        for(int i=n/2;i>=0;i--){
            heapify(arr,n,i);
        }
        for(int i=n-1;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr,i,0);
        }
    }

    public static void heapify(int[]arr, int n , int i){
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;
        if(left<n && arr[left]>arr[largest]){
            largest = left;
        }
        if(right<n && arr[right]>arr[largest]){
            largest = right;
        }
    }
    public static void main(String[]args){
        int[] arr = {9,5,3,2,4,6,754,43,76,98,65,43,21,8,6,4,43,87,43,67,2,35,65,46,3,6,4};
        System.out.println("Origina Array : " +arr);
        heapSort(arr,0,arr.length-1);
        System.out.println("Sorted Array : "+arr);
    }
}
