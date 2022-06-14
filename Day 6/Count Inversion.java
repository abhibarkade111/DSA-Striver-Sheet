// Count Inverion In this problem arr[i]>arr[i+1]
// Now we calculate how many pairs having the the left element is greater than right
// If We calculate using brute force then it goes time complexity higher O(n*n)
// So we need optimise this 

// So optimised Approach is use merge sort 
// We know that merge sort divide the array upto single elements and then compare element and if left array element is greater then we add count int the inverson in this way by using the merge sort we can calculate the number of inversions
// Time Complexity is O(nlogn)

public class Solution {
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        long temp[]  = new long[n];
        return merge_sort(arr,temp,0,n-1);
        
    }
    
    public static long merge_sort(long arr[], long temp[],int left, int right){
        int mid;
        long inv_count=0;
        if(right>left){
            mid = (left+right)/2;
            inv_count+=merge_sort(arr,temp,left,mid);
            inv_count+=merge_sort(arr,temp,mid+1,right);
            
            inv_count+=merge(arr,temp,left,mid+1,right);
            
        }
        return inv_count;
    }
    
    public static long merge(long arr[], long temp[],int left, int mid, int right){
        long inv_count=0;
        int i=left;
        int j=mid;
        int k=left;
        while((i<=mid-1) && (j<=right)){
            if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
                inv_count+=(mid-i);
            }
        }
        while(i<=mid-1){
            temp[k++] = arr[i++];
        }
        
        while(j<=right){
            temp[k++] = arr[j++];
        }
        for(int l=left;l<temp.length;l++){
            arr[l] = temp[l];
        }
        return inv_count;
    }
}