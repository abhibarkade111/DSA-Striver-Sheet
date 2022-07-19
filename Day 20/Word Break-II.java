// Word Break-II 
// Given Dictionary of word and string
// We need to find the possible combination and return it

// Code:

public class Solution {
    
    public static void words(String s, int start,ArrayList<String> dictionary, ArrayList<String> ans, String curr){
        if(start>=s.length()){
            ans.add(curr);
            return;
        }
        
        for(int i=start;i<s.length();++i){
            String tmp = s.substring(start, i+1);
            
            if(dictionary.contains(tmp)){
                String x  = curr;
                curr+=tmp+" ";
                words(s,i+1,dictionary,ans,curr);
                curr=x;
            }
        }
    }

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		// Write your code here.
        ArrayList<String> ans = new ArrayList<>();
        words(s,0,dictionary,ans,"");
        return ans;
	}
}