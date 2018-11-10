import java.util.Stack;

/*evaluate reverse polish notation, input string with spaces between characters*/
public class Calc {

    public static double evaluate(String expr){

      if(expr.length() == 0){return 0;}
      Stack<Double> results = new Stack<Double>();
      String[] arr = expr.split(" ");
      int i = 0;

      while(i < arr.length){

        String input = arr[i];

        if(input.equals("+")){
          results.push(results.pop() + results.pop());
        } else if(input.equals("-")){
            double arg2 = results.pop();
            results.push(results.pop() - arg2);
        } else if(input.equals("*")){
            results.push(results.pop()*results.pop());
        } else if(input.equals("/")){
            double arg2 = results.pop();
            results.push(results.pop()/arg2);
        } else {
          try {
            Double num = Double.parseDouble(input);
            results.push(num);
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e);
            return 0;
        }
      }

        i++;

      }

      return results.pop();

    }

    public static void main(String args[]){

      //String s = "5 1 2 + 4 * + 3 -";
      String s = "3.5 ";

      System.out.println(evaluate(s));

    }

}
