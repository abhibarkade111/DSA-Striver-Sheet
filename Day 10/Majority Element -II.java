// Majority Element-II 
// Find the element which is occurs more than N/3 times

// Approach 1: Brute Force 
// Time Complexity - O(n*n)
// Space Complexity - O(1)

// Approach 2: HashMap

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

// Time Complexity - O(nlogn)
// Space Coplexity  - O(n)

// Approch 3: Moore's Voting Algorithm
// Only maximum two majority(more than n/3) elements is present in array

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans =  new ArrayList<>();
        int num1=Integer.MIN_VALUE,num2=Integer.MIN_VALUE,c1=0,c2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num1){
                c1++;
            }
            else if(nums[i]==num2){
                c2++;
            }
            else if(c1==0){
                num1 = nums[i];
                c1++;
            }
            else if(c2==0){
                num2 = nums[i];
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==num1){
                c1++;
            }
            if(nums[i]==num2){
                c2++;
            }
        }
        if(c1>nums.length/3){
            ans.add(num1);
        }
        if(c2>nums.length/3){
            ans.add(num2);
        }
        return ans;
    }
}

// Time Complexity  - O(n)
// Space Complexity - O(1)



