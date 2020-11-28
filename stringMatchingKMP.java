// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // List<Integer> matches = search("harshalharshharshal", "harsh");
        // for(int i : matches)
        //     System.out.println("Pattern found at: "+i+", ");
        String p = "abaabacc";
        System.out.println(p+"\n"+"abaabarcbabaabacc");
        System.out.println(Arrays.toString(matcherKMP(p.toCharArray())));
                 System.out.println(KMPSearch("abaabacbabaabacc".toCharArray(),p.toCharArray()));
    }
    
    private static int[] matcherKMP(char[] p)
    {
        int m = p.length;
        int[] pt = new int[m];
        int k=0;
        for(int i=1; i<m; i++)
        {
            if(p[k]==p[i]) //add updated length of subseq to pt
            {
                k++;
                pt[i] = k;
            }
            else // what does this mean while search the text for pattern? (i is index of pattern being matched) : if a char doesn't match, pt[i-1] will tells us, which position should we look to fit our new char in. i.e., if pt[i-1]=x, then 0,1,...,x-1 has matched with s[l,...l+(x-1)]. Now if our char fits at x. so now look at p[x] and see if we can match our new char with p[x]. if we can't again go back to pt[x-1].
                //:go to previous length of matched pattern; do not make entry in pt. to keep it blank and process in next iteration, do i-- so we still arrive at the same location in pt.
            {
                if(k>0 && p[k]!=p[i]) 
                {
                    k = pt[k-1];
                    i--;
                }
                else
                {
                    pt[i] = k;
                }
            }
        }
        
        return pt;
    }
    
    private static int KMPSearch(char[] s, char[] p)
    {
        int[] kmpTrans = matcherKMP(p);
        int j=0, i=0, len=0;
        while(i<s.length)
        {
            if(j==p.length-1) return i-p.length+1; //j = kmpTrans[j-1]; to find further matches.
            if(s[i] == p[j])
            {
                i++; j++;
            }
            else if(i<s.length && s[i]!=p[j])
            {
                if(j>0)
                    j = kmpTrans[j-1];
                else
                    i++;
            }
        }
        return -1;
    }
    //for finite automaton string matching
    private static int[][] buildingAutomaton(String p)
    {
        int state = 0;
        int[][] trans = new int [p.length()+1][256];
        int n = p.length();
        
        for(state=0; state<=n; state++)
        {
            for(int a=0; a<256; a++)
            {
                trans[state][a] = nextState(p.toCharArray(), n, state, a);
            }
        }
        
        return trans;
    }
    
    private static int nextState(char[] p, int m, int state, int a)
    {
        if(state < m && a == p[state]) return state+1;
        int ns,i;
        for(ns=state; ns>0;ns--)
        {
            if(p[ns-1] == a) 
            {
                for(i=0; i<ns-1; i++)
                {
                    if(p[i]!=p[state-ns+1+i]) break; //state (where we are) - ns+1 (number of chars in prefix) + i (to match each char in the suffix with prefix)
                    
                }
                if(i == ns-1) return ns;
            }
        }
        return 0;
    }    
    
    private static List<Integer> search(String s, String p)
    {
        int[][] finAuto =  buildingAutomaton(p);
        int state = 0;
        List<Integer> matches = new ArrayList<>();
        for(int i=0; i<s.length(); i++)
        {
            state = finAuto[state][s.charAt(i)];
            if(state == p.length()) 
            {
                matches.add(i-p.length()+1);
            }
        }
        
        return matches;
    }
        
}
