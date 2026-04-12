class BinaySearch {

    public static int peakElement(int[]arr){
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(arr[mid]>arr[mid+1])right = mid;
            else left = mid+2;
        }
        return arr[left];
    }

    public static int firstBadVersion(int n){
        int left = 1;
        int right = n;
        while(left<right){
            int mid = left + (right-left)/2;
            if(isBadVersion(mid))right = mid;
            else left = mid+1;
        }
        return right;
    }   

    public static int searchInsertPosition(int[]arr,int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]<target) left = mid+1;
            else right = mid-1;
        }
        return left;
    }

    public static  int guessNumber(int n) {
        int left = 1;
        int right =n;
        while(left<right){
            int mid = left + (right-left)/2;
            if(guess(mid)==0)return mid;
            else if(guess(mid)==1) left = mid+1;
            else if(guess(mid)==-1) right = mid-1;
        }
        return left;
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        while(left<right){
            int mid = left + (right-left)/2;
            if(arr[mid]>arr[mid+1]) right = mid;
            else left = mid+1;
        }
        return left;
    }

    public static boolean serchIn2DMatrix(int[][]arr,int target){
        int m = arr.length;
        int n = arr[0].length;
        int row = 0;
        int col = n-1;
        while(row<m && col>=0){
            if(arr[row][col]==target)return true;
            else if(arr[row][col]>target) col--;
            else row++;
        }
        return false;
    }

    public static int minInRotatedArray(int[]arr){
        int left = 0;
        int right = arr.length-1;
        if(arr[left]<arr[right]) return arr[left];
        while(left<right){
            int mid = left + (right-left)/2;
            if(arr[mid]>arr[right]) left = mid+1;
            else right = mid;
        }
        return arr[left];
    }

    public static int findKClosest(int[]arr,int k,int x){
        int left = 0;
        int right =arr.length-k;
        while(left<right){
            int mid = (left+right)/2;
            if(x-arr[mid]<=arr[mid+k]-x) right = mid;
            else left = mid+1;
        }
        List<Integer>list = new ArrayList<>();
        for(int i=left;i<left+k;i++){
            list.add(arr[i]);
        }
        return list;
    }

    public static int firstMissingPositive(int[]nums){
        Set<Integer>set = new HashSet<>();
        for(int num:nums) set.add(num);
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)) return i;
        }
        return n+1;
    }

    public boolean searchMatrixII(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n-1;
        while(row<m && col>=0){
            if(matrix[row][col]==target) return true;
            if(matrix[row][col]>target) col--;
            else row++;
        }
        return false;
    }

    public static int DivideTwoInteger(int dividend,int divisor){
        if(divisor==0 ) return new ArithmeticException("divison by zero");
        if(dividend==Integer.MAX_VALUE && divisor==-1){return Integer.MAX_VALUE;}
        
    }

    public static void main(String[] args) {
        int[]arr = {1,2,3,1};
        int ans = peakElement(arr);
        System.out.println(ans);

    }
}
