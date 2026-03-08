package com.vikash.sortingAlgorithms;

class QuickSort{

    public static int partition(int[]arr,int low , int high){
        int pivot = arr[high];
        int i= low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j]  =temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return;
    }
    public static void quickSort(int[]arr,int low,int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    public static void main(String[]args){
        int[] arr = {9,5,3,2,4,6,754,43,76,98,65,43,21,8,6,4,43,87,43,67,2,35,65,46,3,6,4};
        System.out.println("Origina Array : " +arr);
        quickSort(arr,0,arr.length-1);
        System.out.println("Sorted Array : "+arr);
    }
}
