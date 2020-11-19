public class Main {
    public static void main(String[] args) {
        System.out.println(compute("2*3+5/6*3+15"));
    }
    
    public static double compute(String s)
    {
        ArrayList exp = stringToList(s);
        Stack<Character> sOps = new Stack<>();
        Stack<Double> sNums = new Stack<>();

        for(Object o : exp)
        {
            char curOp=' ';
            if(sNums.isEmpty() && 
                o.getClass().getName().equals("java.lang.Character")) 
                return -1.0;
            if(o.getClass().getName().equals("java.lang.Double"))
            {
                System.out.println("Push: "+(double)o);
                sNums.push((double)o);
                continue;
            }
            if(o.getClass().getName().equals("java.lang.Character")){
                    curOp = (char) o;
            }
            collapseTop(sOps,sNums,curOp);
            sOps.push(curOp);
        }
        collapseTop(sOps,sNums,' ');
        return sNums.peek();
    }
    
    public static void collapseTop(Stack<Character> sOps, Stack<Double> sNums, char curOp)
    {
        while(!sOps.isEmpty() && sNums.size()>1) {          
                if(priority(curOp) <= priority(sOps.peek()))
                {
                    
                    double res = performOp(sNums.pop(), sNums.pop(), sOps.pop());
                    System.out.println("="+res);
                    sNums.push(res);
                }
                else
                    break;
            }
    }
              
    public static double performOp(double a, double b, char c)
    {
        System.out.print(a+""+c+""+b);
        switch(c)
        {
            case '*': return a*b;
            case '/': return b/a;
            case '+': return a+b;
            case '-': return a-b;
            default: return 0.0;
        }
    }
    
    public static int priority(char c)
    {
        switch(c)
        {
            case '*': return 2;
            case '/': return 2;
            case '+': return 1;
            case '-': return 0;
            default: return 0;
        }
    }

    
    public static ArrayList stringToList(String s)
    {
        ArrayList exp = new ArrayList();
        StringBuilder digit = new StringBuilder();

        for(char c : s.toCharArray())
        {
            if(!Character.isDigit(c)) 
            {
                exp.add(Double.parseDouble(digit.toString()));
                digit= new StringBuilder();
                exp.add(c);
                continue;
            }

            digit.append(c);
        }
        exp.add(Double.parseDouble(digit.toString()));
        System.out.println(exp);
        return exp;
    }

}
