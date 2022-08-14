// Longest String with All Prefixes

// Approach : Trie

// Using Trie data structure and flag we first build the trie for each word in array
// Now we can check again array which is the longest string uisng flag 
// if flag is true for each char in string of a[i] if all letter have a flag is true then we assign ans=a[i]
// return longest string

// Code:

class Node{
    Node links[] = new Node[26];
    boolean flag = false;
    
    public Node(){}
    
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    
    void put(char ch, Node node){
        links[ch-'a'] = node;
    }
    
    Node get(char ch){
        return links[ch-'a'];
    }
    
    void setEnd(){
        flag = true;
    }
    
    boolean isEnd(){
        return flag;
    }
    
}
class Solution {
    public static Node root;
    
  public static void makeTrie(String a[]){
      root = new Node();
      for(int i=0;i<a.length;i++){
          Node node = root;
          for(int j=0;j<a[i].length();j++){
              if(!node.containsKey(a[i].charAt(j))){
                  node.put(a[i].charAt(j), new Node());
              }
              node = node.get(a[i].charAt(j));
          }
          node.setEnd();
      }
  }
  
  public static String findInTrie(String a[]){
      String ans="";
      for(int i=0;i<a.length;i++){
          Node node = root;
          int j=0;
          for(j=0;j<a[i].length();j++){
              if(node.containsKey(a[i].charAt(j)) && node.get(a[i].charAt(j)).isEnd()){
                 node = node.get(a[i].charAt(j));
              }
              else{
                  break;
              }
          }
          if(j==a[i].length() && node.isEnd()){
              if(ans.length()<=a[i].length()){
                  ans = a[i];
              }
          }
      }
      if(ans.equals("")){
          return "None";
      }
      return ans;
  }

  public static String completeString(int n, String[] a) {
    // Write your code here.
      if(n==0) return "None";
      makeTrie(a);
      return findInTrie(a);
  }
}