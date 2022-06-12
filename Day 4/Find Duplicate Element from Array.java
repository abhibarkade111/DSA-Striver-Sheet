// Problem Link:- https://leetcode.com/problems/find-the-duplicate-number/submissions/
// There is only one element in array
// First Approach -1) Sort the Array 
//                 2) And find arr[i] == arr[i+1]
//                 3) return array element
// Time Complexity is O(nlogn + n)
// Space Complexity is O(1)

// Second Appraoch - Use Hashing to reduce time coplexity
// Time Complexity is O(n)
// Space Coplexity is O(n)

// Third Aprroach is Optimal Appraoch Use Slow and Fast Pointer
// Intially slow assign to the first element 
// slow will move one step and fast will move the two steps 
// It's found a cycle then we need to one more time traverse by assign fast to the initaial element again
// Time complexity is O(n)

// Using arrayList as given
public class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        // Write your code here.
        int slow = arr.get(0);
        int fast = arr.get(0);
        do{
            slow = arr.get(slow);
            fast = arr.get(arr.get(fast));
        }while(slow!=fast);
        
        fast = arr.get(0);
        while(slow!=fast){
            slow = arr.get(slow);
            fast = arr.get(fast);
        }
        return slow;
    }
}

// Using array as Given
class Solution {
    public int findDuplicate(int[] nums) {
        int slow= nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        
        fast = nums[0];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}