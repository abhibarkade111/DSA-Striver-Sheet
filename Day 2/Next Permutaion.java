// Find the next permutation of given array
// [1,2,3] -> [1,3,2]
// [3,2,1] -> [1,2,3]


// Both the code have a linear time complexity i.e O(n)


// Using ArrayList
public class Solution 
{
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
        int n = permutation.size();
        int i = n-2;
        while(i>=0 && permutation.get(i)>permutation.get(i+1)) i--;
        if(i>=0){
            int j = n-1;
            while(j>=0 && permutation.get(i)>permutation.get(j)) j--;
            Collections.swap(permutation, i, j);
        }
        i++;
        int j = n-1;
        while(i<j){
           Collections.swap(permutation, i, j);
            i++;
            j--;
        }
        return permutation;  
	}
}

// Using Array

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0){
            int j = nums.length-1;
            while(j>=0 && nums[j]<=nums[i]) j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        i++;
        int j  =nums.length-1;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}`
