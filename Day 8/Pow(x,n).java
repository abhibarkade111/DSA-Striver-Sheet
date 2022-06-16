// We need to find the x^n without using any inbuilt function like a Math.pow() or x**n

// Approach 1:  Use Brute Force 
//              Using loop we multiply every time x to the ans upto n times and return ans
//              if n is positive then no problem do the above step
//              if n is negative then convert n to the positive assuming edge case if number is Integer.MIN_VALUE then we are not able to convert it to the the max beacause it's get out of range of int so use long datatype to convert

// Approach 2: Optimised Approach
//             1) Convert n if neagtive to positve
//             2) if n%2==1 then multiply ans to the x i.e ans=ans*x; and n--;
//             3) if n%2==0 then x=x*x; and n=n/2;
//             4) continuously do upto the n>0


class Solution {
    public double myPow(double x, int n) {
       double ans=1.0;
        double nn = n;
        if(nn<0) nn=-1*nn;
        while(nn>0){
            if(nn%2==1){
                ans = ans*x;
                nn-=1;
            }
            else{
                x=x*x;
                nn=nn/2.0;
            }
        }
        if(n<0) ans = (double)(1.0)/(double)(ans);
        return ans;
    }
}

// Time Complexity - O(logn)

// Different Problem on CodeStudio
// Solution

public class Solution {
    public static int modularExponentiation(int x, int n, int m) {
        // Write your code here.  
        long ans = 1;
        long xx=x;
        while(n>0){
            if(n%2==1){
                ans = (ans*xx%m)%m;
                n=n-1;
            }
            else{
                xx= (xx%m*xx%m)%m;
                n/=2;
            }
        }
        return (int)ans%m;
    }
}