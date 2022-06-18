// Majority Element-II 
// Find the element which is occurs more than N/3 times

// Now only hashMap Solution is uploaded remaining approaches such as moore's voting algorithm uploaded soon ......

public class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : arr){
            hm.put(i, hm.getOrDefault(i,0)+1);
        }
        for(int key : hm.keySet()){
            if(hm.get(key)>arr.size()/3){
                ans.add(key);
            }
        }
        return ans;
    }
}