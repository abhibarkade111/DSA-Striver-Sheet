// Count Distinct Substring 

// Approach : Using Trie We can Solve this Problem with less Space Complexity
// We can solve this problem using differen solution
// Same as we create a trie and check whther exist or not if not exist add it and increase the counter

// COde:

class Node{
    Node links[] = new Node[26];
    
    Node(){}
    
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    
    Node get(char ch){
        return links[ch-'a'];
    }
    
    void put(char ch, Node node){
        links[ch-'a']=node;
    }
}
public class Solution {
    public static int distinctSubstring(String word) {
        // Write your code here.
        int ans=0;
        Node root = new Node();
        for(int i=0;i<word.length();i++){
            Node node = root;
            for(int j=i;j<word.length();j++){
                if(!node.containsKey(word.charAt(j))){
                    node.put(word.charAt(j),new Node());
                    ans++;
                }
                node = node.get(word.charAt(j));
            }
        }
        return ans;
    }
}
