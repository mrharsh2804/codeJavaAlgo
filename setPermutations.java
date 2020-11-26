// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] A = new int[]{1,2,2};
        List<List<Integer>> res = combOfSet(A);
        for(List<Integer> l : res)
            System.out.println(Arrays.toString(l.toArray()));
    }
    
    public static List<List<Integer>> combOfSet(int[] A)
    {
        List<List<Integer>> res = new ArrayList<>();
        helper(A, 0, res, new ArrayList<>(), new HashSet<>());
        return res;
    }
    
    //for combination
    private static void helper(int[] A, int start, List<List<Integer>> res, List<Integer> temp, Set<Integer> set) //set not needed
    {
        res.add(new ArrayList(temp));
        for(int i=start; i<A.length; i++)
        {
            if(i>start && A[i]==A[i-1]) continue; //if input had duplicates. input should be sorted.
            //set.add(i);
            temp.add(A[i]);
            helper(A, i+1, res, temp,set);
            temp.remove(temp.size()-1);
            //set.remove(i);
        }
    }
    //for permutation
    private static void helper(int[] A, int start, List<List<Integer>> res, List<Integer> temp, Set<Integer> set)//set needed to check if the item is used already
    {
        if(temp.size() == A.length)
            res.add(new ArrayList(temp));
        for(int i=0; i<A.length; i++)
        {
            if(set.contains(i)                    
            || (i>0 && A[i]==A[i-1] && set.contains(i-1))) //for duplicates. input should be sorted.
              continue;
            set.add(i);
            temp.add(A[i]);
            helper(A, i+1, res, temp,set);
            temp.remove(temp.size()-1);
            set.remove(i);
        }
    }
    
    //Combination sum
    private static void helper(int[] A, int start, int rem, List<List<Integer>> res, List<Integer> temp)
    {
        if(rem<0) return;
        else if(rem==0)
            res.add(new ArrayList(temp));
        for(int i=start; i<A.length; i++)
        {
            if(i>start && A[i]==A[i-1]) continue; //avoid duplicates. needs sorted input
            temp.add(A[i]);
            helper(A, i+1, rem-A[i], res, temp); //i if can reuse items
            temp.remove(temp.size()-1);
        }
    }
    
    //palindrome partition
    private static void helper(char[] A, int start, List<List<String>> res, List<String> temp, Set<Integer> set)
    {
        if(start==A.length)
            res.add(new ArrayList(temp));
        for(int i=start; i<A.length; i++)
        {
            if(isPalindrome(A,start,i)) 
            {
                temp.add(new String(A).substring(start,i+1));
                helper(A, i+1, res, temp,set);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    private static boolean isPalindrome(char[] str, int start, int end)
    {
        while(start<end) {
            if(str[start]!=str[end])
            {
                return false;
            }
            start++;end--;
        }
        return true;
    }
    
}
