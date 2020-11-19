/**
Return pair of an array with specified sum.
*/
public class Main {
    public static void main(String[] args) {
        int[] A = new int[]{5,6,7,4};
        int sum = 11;
        System.out.println(getSumPair(A,sum).toString());
    }
    
    /**
    
    */
    
    public static ArrayList<Pair> getSumPair(int[] A, int sum)
    {
        ArrayList<Pair> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int x:A)
        {
            int comp = sum - x;
            if(map.getOrDefault(comp,0)>0)
            {
                res.add(new Pair(x,comp));
                map.put(comp, map.getOrDefault(comp,0)-1);
            }
            else
            {
                map.put(x, map.getOrDefault(comp,0)+1);
            }
        }
        return res;
    }    
}

class Pair
{
    int x,y;
    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString()
    {
        return x+","+y;
    }
}
