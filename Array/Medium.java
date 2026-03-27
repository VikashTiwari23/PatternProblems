import java.util.*;

public class Main {
  
  public static int[] productOfSelf(int[]arr){
    int[] result = new int[arr.length];
    Arrays.fill(arr,1);
    int pre = 1;
    for(int i=0;i<arr.length;i++){
      result[i] = pre;
      pre = pre * nums[i];
    }
    int post = 1;
    for(int i=arr.length-1;i>=0;i--){
      result[i] = result[i]*post;
      post = post*nums[i];
    }
    return result;
  }
  
  public static int containerWithMostWater(int[]arr){
    int left = 0;
    int right =arr.length-1;
    int maxArea = 0;
    for(int i=0;i<arr.length;i++){
       int width = right-left;
       int height = Math.min(arr[left],arr[right]);
       maxArea = Math.max(maxArea,width*height);
       if(arr[left]<arr[right]) left++;
       else right--;
    }
    return maxArea;
  }
  
  public static int searchInRotatedArray(int[]arr,int target){
    int left = 0;
    int right = arr.length-1;
    while(left<right){
      int mid = left+(right-left)/2;
      if(arr[left]<arr[mid]){
        //left is sorted
        if(arr[left]<target && target < arr[mid]) right = mid-1;
        else left = mid+1;
      }
      else{
         // right is sorted 
         if(arr[mid]<target && target < arr[right]) left = mid+1;
         else right = mid-1;
      }
    }
    return left;
  }
  
  public static int[]firstAndLastPosition(int[]arr,int target){
    int left = 0;
    int right = arr.length-1;
    int index1 = -1;
    while(left<=right){
        int mid = left+(right-left)/2;
        if(arr[mid]>=target) {
            if(arr[mid]==target)index1= mid;
            right = mid-1;
        }
        else  left = mid+1;
    }
    
    int index2 = -1;
    left = 0;
    right = arr.length-1;
    while(left<=right){
        int mid = left+(right-left)/2;
        if(arr[mid]<=target) {
            if(arr[mid]==target ) index2= mid;
            left = mid+1;
        }
        else if(arr[mid]<target) left = mid+1;
        else  right = mid-1;
    }
    return new int[]{index1,index2};
  }
  
  public static List<List<Integer>> ThreeSum(int[]arr,int target){
    List<List<Integer>>result = new ArrayList<>();
     if(arr==null || arr.length<3||arr.length==0) return result;
     Arrays.sort(arr);
     for(int i=0;i<arr.length;i++){
          if(i>0 && arr[i]==arr[i-1]) continue;
          int left = i+1;
          int right = arr.length-1;
          while(left<right){
              int sum = arr[left]+arr[right]+arr[i];
              if(sum==0){
                  result.add(Arrays.asList(arr[i],arr[left],arr[right]));
                  left++;
                  right--;
                  while(left<right && arr[left]==arr[left-1]) left++;
                  while(left<right && arr[right] ==arr[right+1]) right--;
              }
              else if(sum<0) left++;
              else right--;
          }
         
     }
    return result;
  }
  
  public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();

        int minr = 0;
        int maxr = matrix.length-1;
        int minc = 0;
        int maxc = matrix[0].length-1;

        while(minr<=maxr && minc<=maxc){
            for(int i=minc;i<=maxc;i++){
                list.add(matrix[minr][i]);
            }
            minr++;
            for(int i=minr;i<=maxr;i++){
                list.add(matrix[i][maxc]);
            }
            maxc--;
            if(minr<=maxr){
                for(int i=maxc;i>=minc;i--){
                    list.add(matrix[maxr][i]);
                }
                maxr--;
            }
            if(minc<=maxc){
                for(int i=maxr;i>=minr;i--){
                    list.add(matrix[i][minc]);
                }
                minc++;
            }
        }
        return list;
    }
    
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i=0;i<nums.length;i++){
            if(i>maxReach) return false;
            maxReach = Math.max(maxReach,i+nums[i]);
        }
        return true;    
    }
  
  public int firstMissingPositive(int[] nums) {
        Set<Integer>set = new HashSet<>();
        
        for(int num:nums){
            if(num>0) set.add(num);
        }
        int n= nums.length;
        for(int  i=1;i<=nums.length;i++){
            if(!set.contains(i))return i;
        }
        return n+1;
 }

  
    public static void main(String[] args) {
      
    }
}
