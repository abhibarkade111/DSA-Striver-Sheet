class SegmentTree
{
    static int st[];
    public static void build(int ind, int low, int high, int arr[]){
        if(low==high){
            st[ind] = arr[low];
            return;
        }
        int mid = (low+high)/2;
        build(2*ind+1,low,mid,arr);
        build(2*ind+2,mid+1,high,arr);
        st[ind] = Math.min(st[2*ind+1],st[2*ind+2]);
    }
    public static int[] constructST(int arr[], int n)
    {
        // Add your code here
        st = new int[4*n];
        build(0,0,n-1,arr);
        return st;
    }
    
    public static int query(int ind, int st[], int low, int high, int l, int r){
        if(low>=l && high<=r) return st[ind];
        if(low>r || high<l) return Integer.MAX_VALUE;
        int mid = (low+high)/2;
        int left = query(2*ind+1,st,low,mid,l,r);
        int right = query(2*ind+2,st,mid+1,high,l,r);
        return Math.min(left, right);
    }
    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int st[], int n, int l, int r)
    {
       // Add your code here
       return query(0,st,0,n-1,l,r);
    }
    
    
}