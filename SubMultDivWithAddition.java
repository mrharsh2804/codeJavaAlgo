Impletement multiply, subtract and divide using add operation.
/**

2. Mulitply:
For loop. 
1. Subtract:
negate second value and add. 
0. Negate: for negative numbers, add 1 to the number until we reach 0 and return count.
for positive numbers, we add -1 to te number until we reach 0.
Optimization-instead of adding 1/-1 (delta), increameant by delta and if adding delta changes the sign, reset delta. 
This is O((log a)^2). Longest round would be log a and log a iterations
More optimization: instead of resetting, use a stack to store deltas so far and pop out the last delta and check signs. this way, we don't need to go all the way back to 1/-1. O(log a)
3. Divide:
For loop. Use Multiply function. 
if x=a/b => a = bx; find x such that diff between a and bx is minimum.
*/

public class Main {
    public static void main(String[] args) {
        System.out.println(divide(4,0));
    }
    
    public static int negate(int a)
    {
        int neg = 0;
        int newSign = a>0?-1:1; //if positive we add -1 to reach 0.
        while(a!=0)
        {
            neg = neg + newSign;
            a = a + newSign;
        }
        return neg;
    }

    public static int subtract(int a, int b)
    {
        return a + negate(b);
    }
    public static int multiply(int a, int b)
    {
        int sign = 1;
        int sum = 0;
        if(a<0 && b<0) { a = negate(a); b = negate(b);}
        else if(b<0) { sign = -1; b = negate(b);}
        else if(a<0) { sign = -1; a = negate(a);}
        while(b!=0)
        {
            sum+=a;
            b = subtract(b,1);
        }
        
        if(sign == -1)
        {
            sum = negate(sum);
        }
        return sum;
    }

    public static int divide(int a, int b)
    {
        if(b==0) return Integer.MIN_VALUE;
        int sign = 1;
        if(a<0) { sign = -1; a = negate(a);}
        if(b<0) { sign = -1; b = negate(b);}
        if(a<0 && b<0) { sign = -1; a = negate(a); b = negate(b);}
        int div = 1;
        int diff = Integer.MAX_VALUE;
        int curDiff = Integer.MAX_VALUE;
        while(curDiff >= diff)
        {
            curDiff = subtract(a, multiply(b,div));
            if(curDiff>=0 && curDiff<diff)
            {
                diff = curDiff;
                div += 1;
            }
        }
        div = div+(-1);
        if(sign == -1)
        {
            div = negate(div);
        }
        return div;
    }

    

}
