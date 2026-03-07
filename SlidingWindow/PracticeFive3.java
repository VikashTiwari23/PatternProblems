

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowsBasics3 {

    public static String minWindow(String s,String t){
        if(s.length()<t.length()) return "";
        Map<Character,Integer>tmap = new HashMap<>();
        for(char c:t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }

        // Working on string s
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int start = 0;
        int len = 0;
        int formed = 0;
        int required = tmap.size();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            if(tmap.containsKey(c) && tmap.get(c).intValue()==map.get(c).intValue()) formed++;
            while(formed==required){
                if(i+1-left<len){
                    len = i+1-left;
                    start = left;
                }
                char leftChar = s.charAt(left);
                map.put(leftChar,map.getOrDefault(leftChar,0)-1);
                if(tmap.containsKey(leftChar)&&map.get(leftChar)<tmap.get(leftChar)) formed--;
                left++;
            }
        }
        return len == 0?"":s.substring(start,start+len);
    }
    public static int longestSubstringKDistinct(String s,int k){
        if(s.length()<k) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int len = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.size()>k){      // for atmost k use > not >=
                char leftChar = s.charAt(left);
                map.put(leftChar,map.getOrDefault(leftChar,0)-1);
                if(map.get(leftChar)==0) map.remove(leftChar);
                left++;
            }
            len = Math.max(len,i+1-left);
        }
        return len;
    }
    public static  int longestSubarrayWithKZero(int[]arr,int k){
        int left = 0;
        int len = 0;
        int zero = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) zero++;
            while(zero>k){
                if(arr[left]==0) zero--;;
                left++;
            }
            len = Math.max(len,i+1-left);
        }
        return len;
    }
    public static int longestRepeatingCharacterReplacement(String s, int k){
        int left = 0;
        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            count[c-'a']++;
            maxCount = Math.max(maxCount,count[c-'a']);
            while(i+1-left - maxCount > k){
                count[s.charAt(left)-'A']--;
                left++;
            }
            maxLength = Math.max(maxLength,i+1-left);
        }
        return maxLength;
    }
    public static void main(String[] args) {
       // 1
       String s = "ADOBECODEBANC";
       String t = "ABC";
       String Output= "BANC";
       System.out.println(minWindow(s,t));

       // 2
       String s = "eceba";
       int k = 2;
       int Output= 3;
       System.out.println(longestSubstringKDistinct(s,k));


       // 3
       int []arr = {1,1,1,0,0,0,1,1,1,1,0};
       int k = 2;
       int Output= 6;
       System.out.println(longestSubarrayWithKZero(arr,k));

       // 4
        String s = "ABAB";
        int k = 2;
        int Output= 4;
        System.out.println(longestRepeatingCharacterReplacement(s,k));
    }
}
