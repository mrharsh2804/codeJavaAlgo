// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        String pattern = "abab";
        String value = "catgotcatgot";
        System.out.println(patternMatching(pattern, value));
    }
    
    public static boolean patternMatching(String pattern, String value)
    {
        int size = value.length();
        char first = pattern.charAt(0);
        char alt = first == 'a' ? 'b':'a';
        
        int firstCount = getCountOf(first, pattern);
        int altCount = pattern.length() - firstCount;
        int maxFirstSize = size/firstCount;
        int firstIdxAlt = pattern.indexOf(alt);
        
        for(int i=0; i<=maxFirstSize; i++)
        {
            int remLen = size - i*firstCount;
            String firstString = value.substring(0,i);
            
            int altLen = altCount==0?0:remLen / altCount;
            int startAlt = firstIdxAlt * i;
            String altString =  altCount==0?"":value.substring(startAlt, startAlt+altLen);
            String cand = buildFromPattern(pattern, firstString, altString);
            if(cand.equals(value)) return true;
        }
        
        return false;
    }
    
    public static int getCountOf(char c, String pattern)
    {
        int count = 0;
        for(char ch:pattern.toCharArray())
        {
            if(ch == c) count++;
        }
        
        return count;
    }
    
    public static String buildFromPattern(String pattern, String first, String alt)
    {
        StringBuilder sb = new StringBuilder();
        char firstChar = pattern.charAt(0);
        for(char c:pattern.toCharArray())
        {
            if(c==firstChar)
            {
                sb.append(first);
            }
            else
                sb.append(alt);
        }
        return sb.toString();
    }
}
