// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{10,2,12,3,6,4,1};
        int x = nthMinNumber(arr, 0 , arr.length-1, 5);
        // System.out.println(Arrays.toString(arr));
        System.out.println(x);
    }
    
    private static int nthMinNumber(int[] A, int i, int j, int n)        
    {
        if(i==j) return A[i];
        int p = partition(A,i,j);
        int k = p-i+1;//in case the n is in second half, we need to shift second half to left by k so that it would vitrually start index from 0; similarly, we need n-kth element now since the second half shifted by k elements to the left.
        if(n == k) return A[p];
        else if(n < k)
            return nthMinNumber(A,i,p-1,n);
        else
            return nthMinNumber(A,p+1,j,n-k);
    }
    
    private static int partition(int[] A, int l, int h)
    {
        int i = l-1;
        int p = A[Math.max(l,Math.min(new Random().nextInt(h-l)+l,h-1))];
        for(int j=l; j<h; j++)
        {
            if(A[j]<=p)
            {
                i++;
                swap(A,i,j);
            }
        }
        swap(A,i+1,h);
        return i+1;
    }
    
    private static void swap(int[] A, int i, int j)
    {
        if(i==j) return;
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
        
}
