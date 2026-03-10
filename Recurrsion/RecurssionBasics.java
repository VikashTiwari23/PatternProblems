import java.util.*;

public class Main {
    public static void serialPrinintin(int n){
      if(n==0) return;
      serialPrinintin(n-1);
      System.out.println(n);
    }
    public static int factorial(int n){
      if(n==0||n==1) return 1;
      return n*factorial(n-1);
    }
    public static int sumOFDigit(int n){
      if(n<0) return 0;
      return n+sumOFDigit(n-1);
    }
    public static int product(int n){
      
      if(n<=0) return 1;
      return n*product(n-1);
    }
    public static int reverse(int n){
      int reverse = 0;
      return reverseNumber(n,reverse);
    }
    public static int reverseNumber(int n, int reverse){
        if(n==0) return reverse;
        return reverseNumber(n/10,reverse*10+n%10);
    }
    public static boolean pallindrome(int n){
        int reverse = reverse(n);
        return  n==reverse;
    }
    public static int countNoZeroes(int n){
      int count = 0;
      return countZero(n,count);
    }
    private static int countZero(int n,int count){
      if(n==0) return count;
      int digit = n%10;
      if(digit==0) count++;
      return countZero(n/10,count);
    }
    public static int numberOfSteps(int n){
      int count = 0;
      return noSteps(n,count);
    }
    private static int noSteps(int n,int count){
      
      if(n==0) return count;
      if( n%2==0) return noSteps(n/2,count+1);
      return noSteps(n-1,count+1);
    }
    public static void main(String[] args) {
      int noOfSteps = numberOfSteps(14);
      System.out.println(noOfSteps);
      int countZero = countNoZeroes(400002343);
      System.out.println(countZero);
      boolean pallindrome = pallindrome(11);
      System.out.println(pallindrome);
      int reverse = reverse(1234678);
      System.out.println(reverse);
      int product = product(10);
      System.out.println(product);
      int sum = sumOFDigit(10);
      System.out.println(sum);
      int ans = factorial(6);
      System.out.println(ans);
      serialPrinintin(50);
    }
    
    
    
}
