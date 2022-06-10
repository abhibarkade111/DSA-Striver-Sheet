// Best Time to Buy and Sell Stock Problem 
// Problem link :  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// Solution given Arrray
class Solution {
    public int maxProfit(int[] prices) {
        int right = 0;
        int left = 0;
        int maxProfit=0;
        while(right<prices.length){
            int temp = prices[right]- prices[left];
            if(temp<0){
                left = right;
            }
            else{
                maxProfit = Math.max(maxProfit, temp);
            }
            right++;
        }
        return maxProfit;
        
    }
}


// Solution given ArrayList

public class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        int left=0,right=0;
        int maxProfit=0;
        while(right<prices.size()){
            int temp = prices.get(right) - prices.get(left);
            if(temp<0){
                left=right;
            }
            else{
                maxProfit = Math.max(maxProfit, temp);
            }
            right++;
        }
        return maxProfit;
    }
}

// Time Complexity is O(n) and space complexity is O(1)