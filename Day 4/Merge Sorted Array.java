// Merge two sorted array
// First Approach is Using one more array for sorting

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    
        int ans[] = new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                ans[k]=nums1[i];
                i++;
            }
            else{
                ans[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(j!=n){
             // System.out.println(k);
            ans[k] = nums2[j];
            j++;
            k++;
        }
        while(i!=m){
            ans[k] = nums1[i];
            i++;
            k++;
        }
        k=0;
       
        for(int l=0;l<ans.length;l++){
            nums1[l] = ans[k];
            k++;
        }
        // return ans;
    }
        
}




// Second and main approach is by without using extra space
// Using Gap Algorithm

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int gap = (int)Math.ceil((double)(n+m)/2.0);
        while(gap>0){
            int i=0;
            int j=gap;
            while(j<(n+m)){
                if(j<m && nums1[i]>nums1[j]){
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                }
                else if(j>=m && i<m && nums1[i]> nums2[j-m]){
                    int temp = nums1[i];
                    nums1[i] = nums2[j-m];
                    nums2[j-m] = temp;
                }
                else if(j>=m && i>=m && nums2[i-m]>nums2[j-m]){
                    int temp = nums2[i-m];
                    nums2[i-m] = nums2[j-m];
                    nums2[j-m] = temp;
                }
                j++;
                i++;
            }
            if(gap==1){
                gap=0;
            }
            else{
                gap = (int)Math.ceil((double)gap/2.0);
            }
        }
        int k = 0;
        for(int i : nums2){
            nums1[m+k] = i;
            k++;
        }
    }
}