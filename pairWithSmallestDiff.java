Two arrays of integers
Return pair with smallest difference (non-zero)

Ex. 
A: 1 3 15 11 2
B: 23 127 235 19 8

A: 1 2 3 11 15
B: 8 19 23 127 235

/**
1. Compare each element of A with each element of B.
2. Sort arrays. Go through arrays as if you are merging these arrays.
*/

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] A = new int[]{1,3,15,11,8};
        int[] B = new int[]{23,127,235,19,8};
        Pair p = minDiffPair(A,B);
        System.out.println(p.x+", "+p.y);
    }
    
    public static Pair minDiffPair(int[] A, int[] B)
    {
        int i=0, j=0;
        int min = Integer.MAX_VALUE;	
        int curDiff = Integer.MAX_VALUE;
        Pair minPair = null;
        Arrays.sort(A);
        Arrays.sort(B);
        while(i<A.length && j<B.length)
        {
            curDiff = Math.abs(A[i]-B[j]);	
            System.out.println(curDiff);
            if(curDiff < min)
            {
                min = curDiff;
                minPair = new Pair(A[i],B[j]);
            }
            if(A[i] < B[j])i++;
            else if(A[i] == B[j]) return new Pair(A[i],B[j]);
            else j++; 
        }
        return minPair;
    }
}

class Pair
{
	int x,y;
	Pair(int x,int y)
	{
		this.x = x;
		this.y = y;
	}
}


