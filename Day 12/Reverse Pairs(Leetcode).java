// Reverse the pairs such as condition is nums[i]>2*nums[j]
// Problem Link:- https://leetcode.com/problems/reverse-pairs/

// Approch 1: - Brute force 
// using two nested loop check for each elemnts and return count of satisfying conditions
// Ṭime Complexity:- o(n*n)
// Space Complexity:- O(n)

// Approach 2: uisng Merge sort
// Optimal Approach
// We can use merge sort technique to check whether first element satisfying condtion after this all the elemnts satisfying conditon beacuse we have to sort it

// Code:-

class Solution {
    static int merge(int[] nums, int low,int mid,int high){
        int cnt=0;
        int j=mid+1;
        for(int i=low;i<=mid;i++){
            while(j<=high && nums[i]>(2*(long)nums[j])){
                j++;
            }
            cnt+= (j-(mid+1));
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        int left=low,right=mid+1;
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left++]);
            }
            else{
                temp.add(nums[right++]);
            }
        }
        
        while(left<=mid){
            temp.add(nums[left++]);
        }
        while(right<=high){
            temp.add(nums[right++]);
        }
        
        for(int i=low;i<=high;i++){
            nums[i] = temp.get(i-low);
        }
        return cnt;
    }
    static int mergeSort(int[] nums, int low, int high){
        if(low>=high) return 0;
        int mid= (low+high)/2;
        int inv =  mergeSort(nums,low,mid);
        inv+= mergeSort(nums,mid+1,high);
        inv+= merge(nums,low,mid,high);
        return inv;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
}


// Same Code but using ArrayList on the CodingStudio

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
    public static int merge(ArrayList<Integer> arr, int low, int mid, int high){
        int cnt=0;
        int j = mid+1;
        for(int i=low;i<=mid;i++){
            while(j<=high && arr.get(i)>(2*(long)arr.get(j))){
                j++;
            }
            cnt+= (j-(mid+1));
        }
        
        ArrayList<Integer> temp = new ArrayList<>();
        int left=low, right=mid+1;
        while(left<=mid && right<=high){
            if(arr.get(left)<=arr.get(right)){
                temp.add(arr.get(left++));
            }
            else{
                temp.add(arr.get(right++));
            }
        }
        while(left<=mid){
            temp.add(arr.get(left++));
        }
        while(right<=high){
            temp.add(arr.get(right++));
        }
        
        for(int i=low;i<=high;i++){
            arr.set(i,temp.get(i-low));
        }
        return cnt;
    }
    public static int mergeSort(ArrayList<Integer> arr, int low, int high){
        if(low>=high) return 0;
        int mid = (low+high)/2;
        int inv = mergeSort(arr,low,mid);
        inv+= mergeSort(arr,mid+1,high);
        inv+= merge(arr,low,mid,high);
        return inv;
    }
    public static int reversePairs(ArrayList<Integer> arr) 
    {
        // Write your code here.
        return mergeSort(arr, 0, arr.size()-1);
    }
}


// Time Complexity:- O(nlogn)
// Sapce Complexity:- O(n)