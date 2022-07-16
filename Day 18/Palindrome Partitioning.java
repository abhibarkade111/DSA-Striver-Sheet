// Palindrome Partitioning 
// Input : s="aab" 
// Output : [["a","a","b"],["aa","b"]]

// Approach 1: Use Recursion And check for each index is palindrome or not if it is palindrome then only do the Partitioning

// Code:

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0,s,path,ans);
        return ans;
    }
    
    public void func(int index, String s, List<String> path, List<List<String>> ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();++i){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                func(i+1,s,path,ans);
                path.remove(path.size()-1);
            }    
        }
        
    }
    
    boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}