// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(1); l.add(2); l.add(3); l.add(4); l.add(5);
        int sum = 5;
        numberCombinations(res, l, sum, 0, new ArrayList<>());
        
        for(int i=0; i<res.size(); i++)
        {
            for(int j=0; j<res.get(i).size(); j++)
                System.out.print(res.get(i).get(j) + " ");
            System.out.println();
        }
    }
    
    private static void numberCombinations(List<List<Integer>> result, List<Integer> l, int sum, int cur, List<Integer> temp)
    {
        
        if(sum == 0)
        {
            result.add(new ArrayList<>(temp));
        }
        else if(sum > 0)
            for(int i=cur; i<l.size(); i++) // replace cur with 0 to get all the combos. with cur 
            {
                //if(temp.contains(l.get(i))) continue; to get combination of distinct numbers
                temp.add(l.get(i));
                numberCombinations(result, l, sum - l.get(i), i, temp);
                temp.remove(temp.size()-1);
            }
    }
}
