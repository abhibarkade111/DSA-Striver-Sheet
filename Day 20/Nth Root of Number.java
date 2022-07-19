// Nth Root of the number
// Input: n=3, m=27
// Output: 3.000000

// We need find the 3rd root of 27 i.e 27^(1/3)

// Approach: Binary Search
// Steps: low =1.0 and high=m  and find the mid if mid>m then high=mid else low=mid do until the difference between the low and high is less than the 10^-6 

// Time Complexity - O(N*logm^d) d-decomal
// Space Complexity - O(1)

// Code:

public class Solution {
    public static double findNthRootOfM(int n, long m) {
    	// Write your code here.
        double lo = 0.00, hi= m;
        double k = 0.00;
        for(int j=1;j<=100;j++){
            double mid= (lo+hi)/2.00;
            double ans = 1.00;
            for(int i=1;i<=n;i++){
                ans=ans*mid;
            }
            if(ans<=m){
                k=mid;
                lo=mid;
            }
            else{
                hi=mid;
            }
        }
        return k;
    }
}

// Code 2:

public class Solution {
    public static double multiply(double m, double n){
        double ans=1.0;
        while(n>0){
            ans=ans*m;
            n--;
        }
        return ans;
    }
    public static double findNthRootOfM(int n, long m) {
    	// Write your code here.
        double ans = 0.0;
        double low = 1.0;
        double high = (double)m+1;
        double eps = 1e-9;
        while((high-low)>eps){
            double mid = (low+high)/2.00000000;
            if(multiply(mid,n)<(double)m){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
}