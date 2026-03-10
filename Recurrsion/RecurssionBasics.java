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
    public static int reverse(int n,int reverse){
      if(n<0) return 0;
      return reverse*10+n%10 + reverse(n/10,reverse);
    }
    public static void main(String[] args) {
      int reverse = reverse(12345,0);
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
