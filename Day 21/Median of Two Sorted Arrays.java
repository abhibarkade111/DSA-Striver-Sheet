// Median of Two Sorted Arrays
// Given two sorted array w need to find the median of it 
// Median = length==even ? (addition of middle two elements)/2 : middle element

// Approach 1: Brute Force
// Use Merge sort to find the middle elements and return the median
// Time Complexity - O(N1+N2)
// Space Complexity  - O(N1+N2)


// To Optimise the above approach no need to use data structure also travese to the end we know that median is middle two or one element so traverse upto mid and return the median

// Approach 2: Optimised Approach - Binary Search
// Steps first array make length shorter than next
// then cut the array according to the binary search two equal elements on the both the half is even else greater element n left
// And according to find the left1,left2 , right1,right2 and comapare it move the low and high
// Return the median

// Time Complexity - O(log(Math.min(N1,N2)))
// Space Complexity - O(1)

Code:
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length) return findMedianSortedArrays(nums2,nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low=0;
        int high = n1;
        while(low<=high){
            int cut1 = (low+high)/2;
            int cut2 = (n1+n2+1)/2-cut1;
            int left1 = cut1==0? Integer.MIN_VALUE:nums1[cut1-1];
            int left2 = cut2==0? Integer.MIN_VALUE:nums2[cut2-1];
            
            int right1 = cut1==n1? Integer.MAX_VALUE:nums1[cut1];
            int right2 = cut2==n2? Integer.MAX_VALUE:nums2[cut2];
            
            if(left1<=right2 && left2<=right1){
                if((n1+n2)%2==0){
                    return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
                }
                else{
                    return Math.max(left1,left2);
                }
            }
            else if(left1>right2){
                high = cut1-1;
            }
            else{
                low= cut1+1;
            }
        }
        return 0.0;
      
    }
}class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length) return findMedianSortedArrays(nums2,nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low=0;
        int high = n1;
        while(low<=high){
            int cut1 = (low+high)/2;
            int cut2 = (n1+n2+1)/2-cut1;
            int left1 = cut1==0? Integer.MIN_VALUE:nums1[cut1-1];
            int left2 = cut2==0? Integer.MIN_VALUE:nums2[cut2-1];
            
            int right1 = cut1==n1? Integer.MAX_VALUE:nums1[cut1];
            int right2 = cut2==n2? Integer.MAX_VALUE:nums2[cut2];
            
            if(left1<=right2 && left2<=right1){
                if((n1+n2)%2==0){
                    return (Math.max(left1,left2)+Math.min(right1,right2))/2.0;
                }
                else{
                    return Math.max(left1,left2);
                }
            }
            else if(left1>right2){
                high = cut1-1;
            }
            else{
                low= cut1+1;
            }
        }
        return 0.0;
      
    }
}