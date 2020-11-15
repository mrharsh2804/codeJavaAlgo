/**
Count number of strolling zeros in n!
With each pair for 2 and 5 we get a number ending with 0.
Ex. 4x5 has a 2 and 5. 25 has 2 5s mad 2 2s.
But we don't need to count 2s since there will always be more multiples of 2s than 5.
So we just count 5s along the way from 2 to n;
Optimization: 
Number of 5 factors between 1 to n = n/5. Then count number of 25 factors between 1 to n = n/25, then 125..
for(int i=5; n/i>0; i*=5)
  count += n/i;
*/
public class Main {
    public static void main(String[] args) {
        System.out.println(strollingZCount1(100));
    }
    
    public static int strollingZCount1(int num)
    {
        int count = 0;
        if(num < 0) return -1;
        
        for(int i=5; i<=num; i++)
        {
            int j = i;
            while(j%5==0)
            {
                count++;
                j/=5;
            }
        }
        return count;
    }
    

}
