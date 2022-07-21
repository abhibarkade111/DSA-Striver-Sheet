// Valid Parenthesis 

// Time Complexity - O(n)
// Space Complexity - O(n)

// Code:

import java.util.*;
public class Solution {
    public static boolean isValidParenthesis(String expression) {
        // Write your code here.
        Stack<Character> st = new Stack<>();
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i)=='(' || expression.charAt(i)=='{' || expression.charAt(i)=='['){
                st.push(expression.charAt(i));
            }
            else if(expression.charAt(i)==')'){
                if(!st.isEmpty() && st.peek()=='('){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else if(expression.charAt(i)==']'){
                if(!st.isEmpty() && st.peek()=='['){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else if(expression.charAt(i)=='}'){
                if(!st.isEmpty() && st.peek()=='{'){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}