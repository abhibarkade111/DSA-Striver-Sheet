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
//         long temp[]  = new long[n];
        long inv_count=0;
        inv_count=merge_sort(arr,0,n-1);
        return inv_count;
        
    }
    
    public static long merge_sort(long arr[],int left, int right){
        int mid=0;
        long inv_count=0;
        if(right>left){
            mid = (left+right)/2;
            inv_count+=merge_sort(arr,left,mid);
            inv_count+=merge_sort(arr,mid+1,right);
            
            inv_count+=merge(arr,left,mid,right);
        }
        return inv_count;
    }
    
    public static long merge(long arr[],int left, int mid, int right){
        long inv_count=0;
        int i=0;
        int j=0;
        int k=left;
        long leftArr[] =  Arrays.copyOfRange(arr,left,mid+1);
        long rightArr[] = Arrays.copyOfRange(arr,mid+1,right+1);
        while((i<leftArr.length) && (j<rightArr.length)){
            if(leftArr[i]<=rightArr[j]){
                arr[k++] = leftArr[i++];
            }
            else{
                arr[k++] = rightArr[j++];
                inv_count= inv_count+ (mid+1) - (left+i);
            }
        }
        while(i<leftArr.length){
            arr[k++] = leftArr[i++]; 
        }
        
        while(j<rightArr.length){
            arr[k++] = rightArr[j++];
        }
//         for(int l=left;l<temp.length;l++){
//             arr[l] = temp[l];
//         }
        return inv_count;
    }
}