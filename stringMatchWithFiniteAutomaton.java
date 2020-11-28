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
    /**
    trying to find prefix == suffix. 
    Ex.   a b a c 
    state 0 1 2 3 4
    
    lets say, we matched aba and we are now prcessing state 3.
    let's say our next char in the string is b (and not c)
    so here we find prefix == suffix to go to that state.
    in this example, we need to return 1.
                (ns start from 3. look for a b before this one. if its not be, ns-- (lines 41-43)) 
          a b a b 
    state 0 1 2 3 4
            (found b. try to match the prefix [0:ns] with the suffix [state-ns+1+0:state-ns+1+ns]. If matched, return ns (the index of pattern string where we found b.).
          a b a b 
    state 0 1 2 3 4
    
    Prefix == suffix part explaination:
    Prefix [0:ns] is easy to understand.
    Suffix:
    State (where we started from) - ns(where we got the matching char) + i (to move forward as prefix matches suffix)
    Lets see this with other example
            ns    state
          a b c a b
    state 0 1 2 3 4 5
    We need to match ns letters from front. so go back ns from state. thats start of suffix. 0 is start of prefix. now move ahead 1 char at a time using i.
    when i == ns, i.e. while searching when we reach the we know we have matched all chars in prefix to suffix. so return ns. 
    
    In the code we use ns-1 because the state as input is the state that is yet being processed. so the matched part so far is state-1. but in the for loop,
    ns starts with state and not state -1. hence, we use ns-1 everywhere in that for loop.
    (Note: While actually coding, just think of it as if you are given 1 based the index and not 0 baseed. so you need to do -1 on the indices. Its not the correct
    reason why. but it makes coding easier.)
    
    */
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
                    if(p[i]!=p[state-ns+1+i]) break; //state (where we are) - ns (number of chars in prefix) + i (to match each char in the suffix with prefix)
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
