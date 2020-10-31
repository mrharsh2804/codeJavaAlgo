// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int floors = 1000;
        int eggs = 6;
        int[][] memo = new int[eggs][floors]; 
        for(int i=0; i<eggs; i++)
            Arrays.fill(memo[i], -1);
        System.out.println(nEggs(eggs-1, floors-1, memo));
    }
    
    private static int nEggs(int eggs, int floors, int[][] memo)
    {
        if(memo[eggs][floors] != -1) return memo[eggs][floors];
        if(floors == 0 || floors == 1) return floors;
        if(eggs == 1) return _2Eggs(floors);
        int drops = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i=1; i<floors; i++)
        {
            drops = Math.max(nEggs(eggs-1, i, memo), 
                             nEggs(eggs, floors-i, memo));
            if(drops<min)
                min = drops;
        }
        memo[eggs][floors] = min+1;
        return min + 1;
    }
    
    private static int _2Eggs(int floors)
    {
        //solve for quadratic equation n^2+n-floors=0 using -b+/- sqrt(b^2-4ac/2a)
        int a, b,c;
        double r1=0.0, r2=0.0;
        a = 1; b = 1; c = -floors*2;
        double result = b * b - 4.0 * a * c;
        if (result > 0.0) {
            r1 = (-b + Math.pow(result, 0.5)) / (2.0 * a);
            r2 = (-b - Math.pow(result, 0.5)) / (2.0 * a);
            //System.out.println("The roots are " + r1 + " and " + r2);
        } else if (result == 0.0) {
            r1 = -b / (2.0 * a);
            //System.out.println("The root is " + r1);
        } else {
            //System.out.println("The equation has no real roots.");
        }
        
        return (int)Math.ceil(Math.max(r1,r2));
    }
    
}
