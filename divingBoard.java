//Generate possible lengths a diving board can be made of using k number of planks of types:short and long.
public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(divingBoard(15,2,6).toArray()));
        System.out.println(Arrays.toString(divingBoardOptimized(15,2,6).toArray()));
    }
    
    public static HashSet<Integer> divingBoard(int k, int s, int l)
    {
        HashSet<Integer> set = new HashSet<>();
        getAllLengths(set, k, 0, s, l, new HashSet<String>());
        return set;
    }
    
    private static void getAllLengths(HashSet<Integer> set, int k, int length, int s, int l, HashSet<String> visited)
    {
        if(k == 0)
        {
            set.add(length); return;
        }
        String key = k+"|"+length;
        if(visited.contains(key)) return;
        visited.add(key);
        getAllLengths(set,k-1,length+s, s, l, visited);
        getAllLengths(set,k-1,length+l, s, l, visited);
    }
    
    //we need to find different combinations sets (not orders) of the planks. That mean, 0 of short and k of long, 1 of short and k-1 of long, 2 of short and k-2 of long...
    public static HashSet<Integer> divingBoardOptimized(int k, int s, int l)
    {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<=k; i++)   
        {
            int nLong = k-i;
            int length = i*s+ nLong*l;
            set.add(length);
        }
        
        return set;
    }
    
}
