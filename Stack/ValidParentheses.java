import java.util.*;;

public class ValidParentheses {
     public static boolean isValidParentheses(String str) {
          Stack<Character> s = new Stack<Character>();

          for (int i = 0; i < str.length(); i++) {
               char ch = str.charAt(i);
               // opening brackets in stack
               if (ch == '(' || ch == '[' || ch == '{') {
                    s.push(ch);
               }

               else {
                    // if given parenthesis is )))))), so the stack is empty
                    if (s.isEmpty()) {
                         return false;
                    }
                    else if((s.peek() == '(' && ch == ')') || 
                         (s.peek() == '[' && ch == ']') ||
                         (s.peek() == '{' && ch == '}')) 
                         {
                         s.pop();
                    } 
                    else {
                         return false;
                    }
               }
          }

          if(s.isEmpty()){
               return true;
          }
          else{
               return false;
          }


     }

     public static void main(String[] args) {
          String str = "[{([{}])";
          System.out.println(isValidParentheses(str));
     }
}
