// Check for Anagarms
// Input: s="abcd", t="dcab" 
// Output: true

// Approach 1: using XOR
// Time Complexity - O(n)
// Space Complexity - O(1)

// Code:

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int res1=0;
        int res2=0;
        for(int i=0;i<s.length();i++){
            res1^= ((1<<(s.charAt(i)-'a'+1))^ (1<<(t.charAt(i)-'a'+1)));
            res2+= ((1<<(s.charAt(i)-'a'+1)) - (1<<(t.charAt(i)-'a'+1)));
        }
        return res1==0 && res2==0;
    }
}

// Approach 2: Using HashMap

// Time Complexity - O(2n)
// Space Complexity - O(n)

// Code:

public class Solution {
    public static boolean areAnagram(String str1, String str2){
        // Write your code here.
        if(str1.length()!=str2.length()) return false;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<str1.length();i++){
            hm.put(str1.charAt(i),hm.getOrDefault(str1.charAt(i),0)+1);
        }
        for(int i=0;i<str2.length();i++){
            if(hm.containsKey(str2.charAt(i))){
                hm.put(str2.charAt(i),hm.getOrDefault(str2.charAt(i),0)-1);
                if(hm.get(str2.charAt(i))==0) hm.remove(str2.charAt(i));
            }
            else{
                return false;
            }
        }
        return true;
    }
}