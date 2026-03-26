import java.util.*;

public class Main {
  public static int maximumSubarray(int[]arr){
    int sum = 0;
    int maxSum = 0;
    for(int i=0;i<arr.length;i++){
      if(sum<0) sum = 0;
      sum+= arr[i];
      maxSum = Math.max(maxSum,sum);
    }
    return maxSum;
  }
  
  public static int moveZeroes(int[]arr){
    int idx = 0;
    for(int i=0;i<arr.length;i++){
      if(arr[i]!=0){
        arr[idx] = arr[i];
        idx++;
      }
    }
    for(int i = idx;i<arr.length;i++){
      arr[i]=0;
    }
  }
  
  public static String removeDuplicate(String s){
    int[]freq = new int[26];
    boolean[]visited = new boolean[26];
    for(char c:s.toCharArray()){
      freq[c-'a']++;
      
    }
    Stack<Character>stack = new Stack<>();
    for(char c:s.toCharArray()){
      freq[c-'a']--;
      if(visited[c-'a']) continue;
      while(!stack.isEmpty() && c<stack.peek() && freq[stack.peek()-'a']>0){
        visited[c-'a']=false;
      }
      stack.push(c);
      visited[c-'a']=true;
    }
    
    StringBuilder sb = new StringBuilder();
    for(char c : stack){
      sb.append(c);
    }
    return sb.toString();
  }
  
  public static int[] intersection(int[]arr){
    Set<Integer>set = new HashSet<>();
    Set<Integer>result = new HashSet<>();
    for(int num : nums1) set.add(num);
    for(int num : nums2) if(set.contains(num)) result.add(num);
    int[] ans = new int[result.size()];
    int i=0;
    for(int num : result){
      ans[i++] = num;
    }
    return ans;
  }
  
  public static int[] intersectionII(int[]arr1,int[]arr2){
    Map<Integer,Integer>map = new HashMap<>();
    List<Integer>list = new ArrayList<>();
    for(int num : arr1){
      map.put(num,map.getOrDefault(num,0)+1);
    }
    for(int num : num2){
      if(map.getOrDefault(num,0)>0){
        list.add(num);
        map.put(num,map.getOrDefault(num,0)-1);
      }
    }
    int[]ans = new int[list.size()];
    for(int i=0;i<list.size();i++){
      ans[i]= list.get(i);
    }
    return ans;
  }
  
  public static int[] rotateArray(int[]arr,int k){
    int n = arr.length;
    int k = k%n;
    reverse(arr,0,n-1);
    reverse(arr,0,k-1);
    reverse(arr,k,n-1);
    return arr;
  }
  private static void reverse(int[]arr,int low,int end){
    while(low<=end){
      int temp = arr[low];
      arr[low] = arr[end];
      arr[end] = temp;
      low++;
      end--;
    }
  }
  
  public static int thirdMaximum(int[]arr){
    Long first = Long.MIN_VALUE;
    Long second = Long.MIN_VALUE;
    Long third = Long.MIN_VALUE;
    for(int num : nums){
      if(num==first || num==second | num== third) continue;
      if(num>first){
        third = second;
        second = first;
        first =(long) num;
      }
      else if(num>second){
        third  = second;
        second =(long) num;
      }
      else if(num>third){
        third =(long) num;
      }
    }
    return third==Long.MIN_VALUE ? first.intValue():third.intValue();
  }
  
  
  public static boolean isPallindrome(String s){
    int left = 0;
    int right = s.length()-1;
    while(left<right){
      while(!Character.isLetterOrDigits(s.charAt(left))) left++;
      while(!Character.isLetterOrDigits(s.charAt(right))) right--;
      if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right)))  return false;
      left++;
      right--;
    }
    return true;
  }
  
  public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            }
            else{
                nums1[k--] = nums2[j--];
            }
        }
        while(j>=0){
            nums1[k--] = nums2[j--];
        }
        return ;
    }
    
    public static int minSizeSubArray(int[] nums,int target){
      int left = 0;
      int minLen = Integer.MAX_VALUE;
      int sum =0;
      for(int i=0;i<nums.length;i++){
        sum += nums[i];
        while(sum>=target){
          minLen = Math.min(minLen , i+1-left);
          sum -= nums[left];
          left++;
        }
      }
      return minLen == Integer.MIN_VALUE ? 0 : minLen;
    }
    
    public static int maximumProduct(int[]arr){
      int min = nums[0];
      int max = nums[0];
      int result = max;
      for(int i=1;i<nums.length;i++){
        int curr = nums[i];
        max = Math.max(curr,Math.max(curr*min,curr*max));
        min = Math.min(cur,Math.min(min*cur,max*cur));
        result = Math.max(max,result);
      }
      return result;
    }



  
    public static void main(String[] args) {
      
    }
}
