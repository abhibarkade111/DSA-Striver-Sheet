// N meetings in one room
// Greedy Algorihtm

// Approach:
//  Steps : 1) Create a class and add start, end and pos 
//          2) Using arrayList Store the all the metting and index
//          3) Sort the meeting as compared with the finishing time elements
//          4) Now check the ending and starting of the next meeting and start>end then add it to solution
//          5) Return the ans

// Time Complexity- O(NlogN)
// Space Complexity - O(N)

// Code :
import java.util.*;
class meeting{
    int start;
    int end;
    int pos;
    meeting(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class meetingComparator implements Comparator<meeting>{
    @Override
    public int compare(meeting o1,meeting o2){
        if(o1.end<o2.end){
            return -1;
        }
        else if(o1.end>o2.end){
            return 1;
        }
        else if(o1.pos<o2.pos){
            return -1;
        }
        return 1;
    }
}
public class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {       
        //Write your code here
        ArrayList<meeting> meet = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            meet.add(new meeting(start[i],end[i],i+1));
        }
        meetingComparator mc = new meetingComparator();
        Collections.sort(meet,mc);
        List<Integer> ans = new ArrayList<>();
        ans.add(meet.get(0).pos);
        int limit = meet.get(0).end;
        for(int i=1;i<start.length;i++){
            if(meet.get(i).start>limit){
                ans.add(meet.get(i).pos);
                limit = meet.get(i).end;
            }
        }
        return ans;
                
            
        
    }
}
