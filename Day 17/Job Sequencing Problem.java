// Job Sequencing Problem
// Approach :
// 1) Sort the array in descending order according to the profit
// 2) find the maximum deadline
// 3) create a array for checking slot is free or occupied of maximum deadline size
// 4) try to complete job on the last day of deadline if last day is not free then check for immediately back days 
// 5) count the jobs and maxProfit and return it

// Time Complexity - O(NlogN + N*M)
// Space Complexity -  O(M)
// where m is maximun daedline 

// Code:

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        Arrays.sort(arr, (a,b)-> (b.profit - a.profit));
        int maxi = 0;
        for(int i=0;i<n;i++){
            if(arr[i].deadline>maxi){
                maxi = arr[i].deadline;
            }
        }
        
        int result[] = new int[maxi+1];
        Arrays.fill(result,-1);
        int countJobs = 0, maxProfit = 0;
        for(int i=0;i<n;i++){
            for(int j=arr[i].deadline;j>0;j--){
                if(result[j]==-1){
                    result[j] = i;
                    countJobs++;
                    maxProfit+=arr[i].profit;
                    break;
                }
            }
        }
        int ans[] = new int[2];
        ans[0] = countJobs;
        ans[1] = maxProfit;
        return ans;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/