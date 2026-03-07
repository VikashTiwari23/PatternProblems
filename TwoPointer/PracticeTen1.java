

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class TwoPointerBasics {
    
    
    public static int[] twoSumII(int[] arr, int target) {
        if (arr == null || arr.length == 0) return new int[0];
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            if (sum > target) right--;
            else left++;
        }
        return new int[0];
    }
    
   
    public static boolean palindrome(String str) {
        if (str == null || str.length() == 0) return true;
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) right--;
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) 
                return false;
            left++;
            right--;
        }
        return true;
    }
    
    
    public static String reverseString(String str) {
        if (str == null) return null;
        char[] letter = str.toCharArray();
        int left = 0;
        int right = letter.length - 1;
        while (left < right) {
            char temp = letter[left];
            letter[left] = letter[right];
            letter[right] = temp;
            left++;
            right--;
        }
        return new String(letter);
    }
    
   
    public static int[] squareOfSortedArray(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        int n = arr.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int index = n - 1;
        
        while (left <= right) {
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            
            if (leftSquare > rightSquare) {
                result[index--] = leftSquare;
                left++;
            } else {
                result[index--] = rightSquare;
                right--;
            }
        }
        return result;
    }
    
    
    public static boolean sumOfSquares(int c) {
        if (c < 0) return false;
        long i = 0;
        long j = (long) Math.sqrt(c);
        while (i <= j) {
            long sum = i * i + j * j;
            if (sum == c) return true;
            if (sum < c) i++;
            else j--;
        }
        return false;
    }
    
   
    public static int containerWithMostWater(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int left = 0;
        int right = arr.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int height = Math.min(arr[left], arr[right]);
            int area = height * width;
            maxArea = Math.max(area, maxArea);
            if (arr[left] < arr[right]) left++;
            else right--;
        }
        return maxArea;
    }
    
    
    public static int trapWater(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int left = 0;
        int right = arr.length - 1;
        int total = 0;
        int leftMax = 0;
        int rightMax = 0;
        
        while (left < right) {
            if (arr[left] < arr[right]) {
                if (arr[left] >= leftMax) {
                    leftMax = arr[left];
                } else {
                    total += leftMax - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= rightMax) {
                    rightMax = arr[right];
                } else {
                    total += rightMax - arr[right];
                }
                right--;
            }
        }
        return total;
    }
    
   
    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length < 3) return result;
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            
            int target = -arr[i];
            int left = i + 1;
            int right = arr.length - 1;
            
            while (left < right) {
                int sum = arr[left] + arr[right];
                if (sum == target) {
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                    
                    while (left < right && arr[left] == arr[left - 1]) left++;
                    while (left < right && arr[right] == arr[right + 1]) right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
    
    
    public static int threeSumClosest(int[] arr, int target) {
        if (arr == null || arr.length < 3) return 0;
        Arrays.sort(arr);
        int closestSum = arr[0] + arr[1] + arr[2];
        
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            
            while (left < right) {
                int currentSum = arr[i] + arr[left] + arr[right];
                
                if (currentSum == target) return target;
                
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
    
    public static List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length < 4) return result;
        Arrays.sort(arr);
        
        for (int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            
            for (int j = i + 1; j < arr.length - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) continue;
                
                int left = j + 1;
                int right = arr.length - 1;
                
                while (left < right) {
                    long sum = (long) arr[i] + arr[j] + arr[left] + arr[right];
                    
                    if (sum == target) {
                        result.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;
                        
                        while (left < right && arr[left] == arr[left - 1]) left++;
                        while (left < right && arr[right] == arr[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
    
    // Main method for testing
    public static void main(String[] args) {
        // Test twoSumII
        int[] nums1 = {2, 7, 11, 15};
        System.out.println("1. Two Sum II: " + Arrays.toString(twoSumII(nums1, 9)));
        
        // Test palindrome
        System.out.println("2. Valid Palindrome: " + palindrome("A man, a plan, a canal: Panama"));
        
        // Test reverseString
        System.out.println("3. Reverse String: " + reverseString("hello"));
        
        // Test squareOfSortedArray
        int[] nums2 = {-4, -1, 0, 3, 10};
        System.out.println("4. Squares of Sorted Array: " + Arrays.toString(squareOfSortedArray(nums2)));
        
        // Test sumOfSquares
        System.out.println("5. Sum of Square Numbers: " + sumOfSquares(5));
        
        // Test containerWithMostWater
        int[] nums3 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("6. Container With Most Water: " + containerWithMostWater(nums3));
        
        // Test trapWater
        int[] nums4 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("7. Trapping Rain Water: " + trapWater(nums4));
        
        // Test threeSum
        int[] nums5 = {-1, 0, 1, 2, -1, -4};
        System.out.println("8. 3Sum: " + threeSum(nums5));
        
        // Test threeSumClosest
        int[] nums6 = {-1, 2, 1, -4};
        System.out.println("9. 3Sum Closest: " + threeSumClosest(nums6, 1));
        
        // Test fourSum
        int[] nums7 = {1, 0, -1, 0, -2, 2};
        System.out.println("10. 4Sum: " + fourSum(nums7, 0));
    }
}
