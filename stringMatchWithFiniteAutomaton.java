// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println("Pattern found at: "+search("AABAACAADAABAAABAA", "AACAAD"));
    }
    
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
        int ns;
        for(ns=state; ns>0;ns--)
        {
            if(p[ns-1] == a) 
            {
                for(int i=0; i<ns-1; i++)
                {
                    if(p[i]!=p[state-ns+1+i]) break; //state (where we are) - ns+1 (number of chars in prefix) + i (to match each char in the suffix with prefix)
                    if(i == ns-1) return ns;
                }
            }
        }
        return 0;
    }
    
    
    private static int search(String s, String p)
    {
        int[][] finAuto =  buildingAutomaton(p);
        int state = 0;
        for(int i=0; i<s.length(); i++)
        {
            state = finAuto[state][s.charAt(i)];
            if(state == p.length()) return i-p.length()+1;
        }
        
        return -1;
    }
        
}
