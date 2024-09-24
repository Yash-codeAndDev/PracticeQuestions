import java.util.ArrayDeque;
import java.util.Deque;

class Main{
    
    public static int precedence(char ch) 
    {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    
    
    public static String infixToPostfix(String exp) {
        
        Deque<Character> st = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        
        int n = exp.length();

        for (int i = 0; i < n; i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                ans.append(c);
            }
            
            else if (c == '(') {
                st.push(c);
            }
            else if (c == ')') 
            {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                
                st.pop();
            } 
            else {
                while (!st.isEmpty() && precedence(c) <= precedence(st.peek())) {
                    ans.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
           
            ans.append(st.pop());
        }
        return ans.toString();
    }


    public static void main(String[] args) 
    {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        String ans = infixToPostfix(exp);
        System.out.println(ans); 
    }
}