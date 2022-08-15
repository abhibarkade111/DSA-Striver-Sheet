// Maximum XOR With an Element From Array 

// Input: nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
// Output: [3,3,7]
// Explanation:
// 1) 0 and 1 are the only two integers not greater than 1. 0 XOR 3 = 3 and 1 XOR 3 = 2. The larger of the two is 3.
// 2) 1 XOR 2 = 3.
// 3) 5 XOR 2 = 7.

// Approach 1: 

// We can Solve this problem using Trie
// 1) Sort the queries according to the second value i.e mi and also maintain the index
// 2) Sort the array nums
// 3) Insert upto the current value of mi for perticular queries insert the element in trie 
// 4) Now find the maximum for given element in queries from trie
//    As we know that we get maximim xor if opposite bit of that bit is present
//    So we find the opposite bit if present else get as it is
// 5) stores the value for each queries in array for perticular index

// 6) return the ans array

// Code: 

class Node{
    Node links[] = new Node[2];
    
    boolean containsKey(int ind){
        return links[ind]!=null;
    }
    
    void put(int ind, Node node){
        links[ind] = node;
    }
    
    Node get(int ind){
        return links[ind];
    }
}

class Trie{
    public Node root;
    Trie(){
        root= new Node();
    }
    
    public void insert(int num){
        Node node= root;
        for(int i=31;i>=0;i--){
            int  bit = (num>>i)&1;
            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }
    
    public long getMax(int num){
        Node node=  root;
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

class Store implements Comparator<Store>{
    int x;
    int a;
    int i;
    Store(int x, int a, int i){
        this.x = x;
        this.a = a;
        this.i = i;
    }
    
    Store(){}
    
    @Override 
    public int compare(Store s1, Store s2){
        if(s1.a>s2.a){
            return 1;
        }
        if(s1.a<s2.a){
            return -1;
        }
        return 0;
    }
}

class Solution {
    Trie trie = new Trie();
    public int[] maximizeXor(int[] nums, int[][] queries) {
       
        
        int ans[] = new int[queries.length];
        Arrays.sort(nums);
        PriorityQueue<Store> pq = new PriorityQueue<>(new Store());
        for(int i=0;i<queries.length;i++){
            pq.add(new Store(queries[i][0], queries[i][1], i));
        }
        int i=0;
        while(i<nums.length && !pq.isEmpty()){
            Store s = pq.poll();
            long maxi=-1;
            // System.out.println(s.a);
            while(i<nums.length && nums[i]<=s.a){
                trie.insert(nums[i]);
                maxi = Math.max(maxi, trie.getMax(s.x));
                i++;
                System.out.println(s.a);
            }
            // System.out.println(s.a);
            if(i<nums.length && s.a<nums[i] && i!=0){
                maxi = Math.max(maxi, trie.getMax(s.x));
            }
            ans[s.i] = (int)maxi;
        }
        while(!pq.isEmpty()){
            Store s = pq.poll();
            ans[s.i]= (int)trie.getMax(s.x);
        }
        
        return ans;
    }
}


// Approach 2:

// Code: 

public class Solution {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        // Write your code here.
        Collections.sort(arr);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<queries.size();i++){
            int xo = queries.get(i).get(0);
            int limit = queries.get(i).get(1);
            int maxi=-1;
            for(int j=0;j<arr.size();j++){
                if(arr.get(j)>limit){
                    break;
                }
                else{
                    int res = xo^arr.get(j);
                    maxi = Math.max(res,maxi);
                }
            }
            ans.add(maxi);
        }
        return ans;
    }
}