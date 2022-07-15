// Maximum activities
// Same Problem as the N meetings in one room which is present in the Day 16
// Time Complexity - O(NlogN)
// Space Complexity - O(N)

import java.util.*;
import java.util.Collections.*;
class Activities{
    int start;
    int end;
    Activities(int start, int end){
        this.start = start;
        this.end= end;
    }
}
class activityComparator implements Comparator<Activities>{
    @Override
    public int compare(Activities a,Activities b){
        return a.end - b.end;
    }
}
public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        //Write your code here
        ArrayList<Activities> arr = new ArrayList<>();
        for(int i=0;i<start.size();i++){
            arr.add(new Activities(start.get(i), end.get(i)));
        }
        
        Collections.sort(arr, new activityComparator());
        int ans=1;
        int finish = arr.get(0).end;
        for(int i=1;i<arr.size();i++){
            if(finish<=arr.get(i).start){
                ans++;
                finish = arr.get(i).end;
            }
        }
        return ans;
    }
}
