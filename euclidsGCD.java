// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(euclidsGCD(19,57));
    }
    
    private static int euclidsGCD(int a, int b)
    {
        if(b==0) return a;
        return euclidsGCD(b,a%b);
    }
}
