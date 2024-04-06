// Kth Largetst Elememnt of the Array
// Approach 1: Sort the Array and return
// Approach 2: Use ProirityQueue

// Approach 3: Use QuickSort Technique

// Time Complexity: O(n)
// Space Complexity: O(1)

// Code:
class Solution{
static int partition(int[] arr, int left, int right) {
    int pivot = arr[left] ;
    int l = left + 1 ;
    int r = right;
    while (l <= r) {
        if (arr[l] < pivot && arr[r] > pivot)  {
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp; 
            l++ ;
            r-- ;
        }
        if (arr[l] >= pivot) {
            l++;
        }
        if (arr[r] <= pivot) {
            r--;
        }
    }
    int temp2=arr[left];
    arr[left]=arr[r];
    arr[r]=temp2;
    return r;
}

static int kth_Largest_Element(int[] arr, int k) {
    int left = 0, right = arr.length - 1, kth;
    while (true) {
        int idx = partition(arr, left, right);
        if (idx == k - 1) {
            kth = arr[idx];
            break;
        }
        if (idx < k - 1) {
            left = idx + 1;
        } else {
            right = idx - 1;
        }
    }
    return kth;
}
}