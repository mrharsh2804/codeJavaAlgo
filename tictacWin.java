// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'o','x','o'},
                                      {'o','x','o'},
                                      {'x','x','x'}
                                     };
        System.out.println(hasWon(board,'x'));
    }

    public static boolean hasWon(char[][] board, char c)
    {
        boolean won = false;
        int[][] dir = new int[][]{{0,1},{1,0},{1,1}};
        
        //check starting with 0th row only
        for(int j=0; j<board.length; j++)
        {
            char[] dirArr = new char[2];
            if(board[0][j] == c)
            {
                int k = 1;
                int x = 0 + dir[k][0];
                int y = j + dir[k][1];
                if(x<board.length && y<board[0].length && board[x][y] == c)
                    won = won | helper(board, c, dir[k],new Position(x,y), 2);
            }
        }
        //check starting with 0th column only
        for(int i=0; i<board.length; i++)
        {
            char[] dirArr = new char[2];
            if(board[i][0] == c)
            {
                int k = 0;
                int x = i + dir[k][0];
                int y = 0 + dir[k][1];
                if(x<board.length && y<board[0].length && board[x][y] == c)
                    won = won | helper(board, c, dir[k],new Position(x,y), 2);
            }
        }
        
        //check reverse column
        
        return won;
    }

    private static boolean helper(char[][] board, char sign, int[] dirArr, Position cur, int count)
    {
        if(count == board.length) return true;
        Position nextPos = new Position(cur.x+dirArr[0], cur.y+dirArr[1]);
        if(nextPos.x>=board.length || nextPos.y>=board[0].length) return false;
        if(board[nextPos.x][nextPos.y] == sign)
        {
            count++;
            return true & helper(board, sign, dirArr, nextPos, count);
        }
        else
            return false;
    } 
}

class Position
{
    int x, y;
    Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

