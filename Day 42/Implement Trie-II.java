// Implement Trie-II 
// In this Question we implement some more function with the trie data Structure

// like- INSERT, COUNTSTARTWITH, COUNTEQUALTO

// As in the previous question we take a flag in this question we maintain the starts with and endswith variable and according to the function we incremeent and decrement it

// Code:

class Node{
    Node links[] = new Node[26];
    int prefix=0;
    int endswith=0;
    
    boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    
    void put(char ch, Node node){
        links[ch-'a'] = node;
    }
    
    Node get(char ch){
        return links[ch-'a'];
    }
    
    void incPrefix(){
        prefix++;
    }
    
    void incEnd(){
        endswith++;
    }
    
    void decEnd(){
        endswith--;
    }
    
    void decPrefix(){
        prefix--;
    }
    
    int getPrefix(){
        return prefix;
    }
    
    int getW(){
        return endswith;
    }
    
    
}
public class Trie {
    public Node root;
    public Trie() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node node= root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
                
            }
            node = node.get(word.charAt(i));
            node.incPrefix();
        }
        node.incEnd();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }
            else{
                return 0;
            }
        }
        return node.getW();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }
            else{
                return 0;
            }
        }
        return node.getPrefix();
    }

    public void erase(String word) {
        // Write your code here.
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }
             node.decPrefix();
        }
        node.decEnd();
    }

}
