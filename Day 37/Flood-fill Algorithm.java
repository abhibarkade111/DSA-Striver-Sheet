// Flood-fill Algorithm

// Input Matrix :
// output : Change the all adjcaent same value to the new value

// Recursion: Recursively call the function and check adjcent have same value or nor if same value then update it to the new value
// go four directionally of given value

// Code:

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(color!=newColor){
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }
    
    public void dfs(int [][]image, int r, int c, int color, int newColor){
        if(image[r][c]==color){
            image[r][c] = newColor;
            if(r>=1){
                dfs(image, r-1, c, color, newColor);
            }
            if(c>=1){
                dfs(image, r, c-1, color, newColor);
            }
            if(r+1< image.length){
                dfs(image, r+1, c, color, newColor);
            }
            if(c+1< image[0].length){
                dfs(image, r, c+1, color, newColor);
            }
        }
    }
}