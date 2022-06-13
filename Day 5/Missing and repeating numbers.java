// In array of n elements one element is repeating and other is missing
// We can find this using Three Approaches
// 1) Using Counting sort method by using extra array and checking the frequency
// 2) By using the Math calculations
// 3) By using XOR

// Problem Link :-  https://www.codingninjas.com/codestudio/problems/873366?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
// Below solution using the Math Calculations Reamaining two will be added soon...

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        // Write your code here
        int a=10;
//         System.out.println(a);
        int len = arr.size();
        long m=0,r=0;
        long s = (len *(len+1))/2;
        long p = (len*(len+1)*(2*len+1))/6;
        
        for(int i=0;i<len;i++){
            s-=(long)arr.get(i);
            p-=(long)arr.get(i)*(long)arr.get(i);
        }
        
        m = (s+ p/s)/2;
        r = m -s;
        
        return new int[]{(int)m,(int)r};
    }
}