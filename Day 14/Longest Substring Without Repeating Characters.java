// Longest Substring Without Repeating Characters
// Approach 1: Brute Force 
// using two loops check for each longest unique string
// Time Complexity : O(n*n)
// Space Complexity : o(n)

// Appraoch 2: Use hashset (optimal Approach)
// use HashSet to store and use left and right 
// Intiltially left and right at 0
// right will move whenever repeat character is not present 
// if repeat character is arrive then remove it using left pointer until no repeat is present
// return maxLength 
// Time Complexity - O(2n)
// Space Complexity - O(n)

// Code
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashSet<Character> set = new LinkedHashSet<>();
        int right=0, left=0, max=0;
        while(right<s.length()){
            if(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            else{
                set.add(s.charAt(right));
                right++;
                max = Math.max(max, set.size());
            }
        }
        return max;
       
    }
} 

// Approach 3 : Better Approach - using hashMap
// Time Copmexity - O(n)
// Ṣpace Complexity - O(n)

// Code 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character, Integer> hm = new HashMap<>();
        int right=0,left=0,len=0;
        while(right<s.length()){
            if(hm.containsKey(s.charAt(right))){
                left = Math.max(left, hm.get(s.charAt(right))+1);
            }
            hm.put(s.charAt(right),right);
            len = Math.max(len, right-left+1);
            right++;
        }
        return len;  
    }
}

