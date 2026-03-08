package com.vikash.sortingAlgorithms;

class InsertionSort{

    public static void insertionSort(int[]arr){
        int n = arr.length;
        for(int i = 1;i<n;i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    public static void main(String[]args){
        int[] arr = {9,5,3,2,4,6,754,43,76,98,65,43,21,8,6,4,43,87,43,67,2,35,65,46,3,6,4};
        System.out.println("Origina Array : " +arr);
        insertionSort(arr);
        System.out.println("Sorted Array : "+arr);
    }
}
