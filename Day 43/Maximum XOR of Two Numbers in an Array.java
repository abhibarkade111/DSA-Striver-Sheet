// Maximum XOR of Two Numbers in an Array 

// Input: nums = [3,10,5,25,2,8]
// Output: 28
// Explanation: The maximum result is 5 XOR 25 = 28.

// Approach : 

// 1) Insert All the element in trie 
// 2) Now find the maximum for each element in array from trie
//    As we know that we get maximim xor if opposite bit of that bit is present
//    So we find the opposite bit if present else get as it is

// 3) return the maximum among the all of the values


// Time Compllexity - O(N*32) +)(N*32)


// Code: 

class Node{
    Node links[] = new Node[2];
    
    boolean containsKey(int ind){
        return (links[ind]!=null);
    }
    
    Node(){}
    
    Node get(int bit){
        return links[bit];
    }
    
    void put(int ind, Node node){
        links[ind] = node;
    }
    
    
}
class Trie{
    public Node root;
    
    Trie(){
        root = new Node();
    }
    
    public void insert(int num){
        Node node = root;
        for(int i=31;i>=0;i--){
            int bit = (num>>i)&1;
            // System.out.println(bit);
            if(!node.containsKey(bit)){
               node.put(bit, new Node()); 
            }
            node = node.get(bit);
        }
    }
    
    public int getMax(int num){
        Node node = root;
        int maxNum=0;
        for(int i=31;i>=0;i--){
            int bit = (num>>i)&1;
            if(node.containsKey(1-bit)){
                maxNum = maxNum | (1<<i);
                node = node.get(1-bit);
            }
            else{
               node = node.get(bit); 
            }
            
        }
        return maxNum;
    }
}
class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int maxi=0;
        for(int i : nums){
            trie.insert(i);
        }
        for(int i : nums){
            maxi = Math.max(maxi, trie.getMax(i));
        }
        return maxi;
    }
}

