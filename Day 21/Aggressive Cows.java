// Aggresive Cows
// Given the number of cows and array having distance we need to place all the cows and return the maximum minimum distance between the cows

//Appraoch: Binary Search (Optimised Approach)
// Same as the prebious problem i.e Alloacate minimum nuber of pages  

// Time Complexity : O(N*logN)
// Space Complexity : O(1)

// Code:

public class Solution {

    public static boolean canPlace(int dist,int c, int positions[]){
        int cnt=1;
        int cordi = positions[0];
        for(int i=1;i<positions.length;i++){
            if(positions[i]-cordi>=dist){
                cnt++;
                cordi = positions[i];
            }
            if(cnt==c){
                return true;
            }
        }
        return false;
    }
    public static int chessTournament(int[] positions, int n,  int c) 
	{
        // Write your code here.   
        Arrays.sort(positions);
        int low = 1;
        int high = positions[n-1]-positions[0];
        int res=-1;
        while(low<=high){
            int mid = (low+high)>>1;
            if(canPlace(mid,c,positions)){
                res = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return res;
    }

}