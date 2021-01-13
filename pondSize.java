/**
Given a matrix representation of plot of land, find the sizes of all the ponds in the matrix.
0 indicates the water. Pond is the regionof water connected vertically, horizontally or diagonally.
"""

grid = [[0, 2, 1, 0],
        [0, 1, 0, 1],
        [1, 1, 0, 1],
        [0, 1, 0, 1]]
        
    
*/
public class Main {
    public static void main(String[] args) {
        int[][] grid = new int[][] 
        {{0, 2, 1, 0},
         {0, 1, 0, 1},
         {1, 1, 0, 1},
         {0, 1, 0, 1}};
        System.out.println(Arrays.toString(getPondSizes(grid).toArray()));
    }
    
    public static List<Integer> getPondSizes(int[][] land)
    {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<land.length; i++)
        {
            for(int j=0; j<land[0].length; j++)
            {
                if(land[i][j] == 0)
                    res.add(helper(land,i,j));
            }
        }
        return res;
    }
    
    public static int helper(int[][] land, int i, int j)
    {
        if(i<0 || j<0 || i>=land.length || j>=land[0].length || 
           land[i][j]!=0) return 0;
        
        int count = 1;
        land[i][j] = -1;
        
        count += helper(land, i+1, j);
        count += helper(land, i-1, j);
        count += helper(land, i, j-1);
        count += helper(land, i, j+1);
        count += helper(land, i-1, j-1);
        count += helper(land, i-1, j+1);
        count += helper(land, i+1, j-1);
        count += helper(land, i+1, j+1);
        
        return count;
    }
}
