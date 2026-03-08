package com.vikash.sortingAlgorithms;

public BubbleSort{

    public static void bubbleSort(int[]arr){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return;
    }
    public static void main(String[]args){
        int[] arr = {9,5,3,2,4,6,754,43,76,98,65,43,21,8,6,4,43,87,43,67,2,35,65,46,3,6,4};
        System.out.println("Origina Array : " +arr);
        bubbleSort(arr);
        System.out.println("Sorted Array : "+arr);
    }
}
