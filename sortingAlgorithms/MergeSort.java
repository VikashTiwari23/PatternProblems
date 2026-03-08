package com.vikash.sortingAlgorithms;

class MergeSort{

    public static void mergeSort(int[]arr,int low, int high){
        if(low<high){
            int mid = low+(high-low)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    public static void merge(int[]arr,int low ,int mid, int high){
        int n1 = mid+1-low;
        int n2 = high-mid;

        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i=0;i<n1;i++){
            L[i] = arr[left+i];
        }
        for(int j=0;j<n2;j++){
            R[j]=arr[mid+j+1];
        }

        int i= 0 , j =0 , k = low;
        while(i<n1&&j<n2){
            if(L[i]<R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[]args){
        int[] arr = {9,5,3,2,4,6,754,43,76,98,65,43,21,8,6,4,43,87,43,67,2,35,65,46,3,6,4};
        System.out.println("Origina Array : " +arr);
        mergeSort(arr,0,arr.length-1);
        System.out.println("Sorted Array : "+arr);
    }
}
