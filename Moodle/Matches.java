public class Matches {
    public static boolean matches(String s) {
        ArrayDeque<String> stk = new ArrayDeque<String>();
        String[] input = s.split("");
        Boolean match = false;

        for (String str : input) {
            if (str.equals("(") || str.equals("{") || str.equals("[")) {
                stk.push(str);
            } else if ((str.equals(")") || str.equals("}") || str.equals("]"))) {
                if (!stk.isEmpty()) {

                    String top = stk.pop();
                    if (str.equals(")") && top.equals("(")) {
                        match = true;
                    } else if (str.equals("}") && top.equals("{")) {
                        match = true;
                    } else if (str.equals("]") && top.equals("[")) {
                        match = true;
                    } 
                    else {
                        return false;
                    } 
                } 

            }

        }
        if (stk.isEmpty() == true) {
            return match;
        } else {
            return false;
        }
    }
}