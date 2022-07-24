// Roman Number to integer

// Input: s = "MCMXCIV"
// Output: 1994
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

// Time Complexity - O(n)
// Space Complexity - O(7)

// Code:

public class Solution {
    public static int romanToInt(String s) {
        // Write your code here
        int ans=0;
        int len = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        for(int i=0;i<len;i++){
            if(i!=len-1 && s.charAt(i)=='I' && s.charAt(i+1)=='V'){
                ans=ans+4;
                i++;
            }
            else if(i!=len-1 && s.charAt(i)=='I' && s.charAt(i+1)=='X'){
                ans=ans+9;
                i++;
            }
            else if(i!=len-1 && s.charAt(i)=='X' && s.charAt(i+1)=='L'){
                ans=ans+40;
                i++;
            }
            else if(i!=len-1 && s.charAt(i)=='X' && s.charAt(i+1)=='C'){
                ans=ans+90;
                i++;
            }
            else if(i!=len-1 && s.charAt(i)=='C' && s.charAt(i+1)=='D'){
                ans=ans+400;
                i++;
            }
            else if(i!=len-1 && s.charAt(i)=='C' && s.charAt(i+1)=='M'){
                ans=ans+900;
                i++;
            }
            else{
                ans=ans+hm.get(s.charAt(i));
            }
        }
        return ans;
    }
}