
public class DoOp {
    public static String operate(String[] args) {
        try {
        int first = Integer.parseInt(args[0]);
        int last = Integer.parseInt(args[2]);
        if (args.length != 3) {
            return "Error";
        } else if ((args[1] == "/" || args[1] == "%") && last == 0) {
            return "Error";
        }  else {
            switch (args[1]) {
                case "/": {
                return Integer.toString(first / last);
                } 
                case "*": {
                return Integer.toString(first * last);
                }
                case "-": {
                return Integer.toString(first - last);
                } 
                case "+": {
                return Integer.toString(first + last);
                } 
                case "%": {
                return Integer.toString(first + last);
                } 
                default:  return "Error";
            }
        }
        } catch(Exception e) {
            return "Error";
        }
    }
}
