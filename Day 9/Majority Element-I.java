// Find Majority element from array
// Majority element is appears more than arr.length/2 it's given in problem

// Approach 1: Brute Force 
// Use two loop traverse entire array for each element 
// if element occurs more than length/2 time return that element
// Time Complexity - O(N*N)

// Approach 2: using HashMap
// Use hashmap to store the frequency of the element 
// if any element appears more than length/2 return that element
// else return -1
// Time Complexity - O(N) || O(NlogN)
// Space complexity - O(N)

// Approch 3: Moore's Voting Algorithm
// Moore's voting algorithm gives optimal solution to find the majority element
// 1) Intialze two element count=0, element = arr[0];
// 2) Traverse the array i) if count is 0 then assign element to arr[i] and count++
//                       ii) if ele ==  arr[i] then count++
//  	                 iii) else count--;
// 3) return element

// Time complexity - O(N)
// Space Complexity- O(1)

// Leetcode Solution using moore's algorithm
// Problem link :- https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int ele=nums[0];
        for(int i=0;i<nums.length;i++){
            if(count==0){
                ele = nums[i];
                count++;
            }
            else if(nums[i]==ele){
                count++;
            }
            else{
                count--;
            }
        }
        return ele;
    }
}

// Code Studio solution using hashMap
// Problem link:- https://www.codingninjas.com/codestudio/problems/majority-element_842495?topList=striver-sde-sheet-problems&leftPanelTab=1

public class Solution {
	public static int findMajority(int[] arr, int n) {
        
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
        }
        for(int key : hm.keySet()){
            if(hm.get(key)>n/2){
                return key;
            }
        }
        return -1;
	}
}
