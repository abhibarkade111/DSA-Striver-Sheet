// Permuatations String or Array
// Generate all permutations of the given string or array

// Approach 1: Use Recursion and Datastructure to store all the permutation and also maintain the map or array to check whether element is picked or not
// Accordingly add all the elememts 

// Time Complexity - O(N!*N)
// Space Complexity - O(N) + O(N)

// Approach 2: Use Swapping technique and reduce the space


// Time Complexity - O(N! * N)
// Space Complexity - O(N)-(i.e. Recursion space)

// Code:
import java.util.*;
public class Solution {
    public static void func(int index, char[] s,List<String> ans){
        if(s.length==index){
            ans.add(new String(s));
            return;
        }
        for(int i=index;i<s.length;i++){
            swap(i,index,s);
            func(index+1,s,ans);
            swap(i,index,s);
        }
    }
    public static void swap(int i,int j, char[] s){
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
    public static List<String> findPermutations(String s) {
        // Write your code here.
        char[] str = s.toCharArray();
        List<String> ans = new ArrayList<>();
        func(0,str,ans);
        return ans;
    }
}

