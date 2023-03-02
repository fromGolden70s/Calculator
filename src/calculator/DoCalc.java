package calculator;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class DoCalc {
    static ArrayList<String> eq = new ArrayList<>();

    public static void toEquation() {
        String imp = Calculator.getFieldText();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int end = 0;
        for (int i = 1; i <= imp.length(); i++) {
            if (i == imp.length()) {
                eq.add(imp.substring(start));
            } else if (!(imp.charAt(i) >= '0' && imp.charAt(i) <= '9') && imp.charAt(i) != '.') {
                end = i;
                eq.add(imp.substring(start, end));
                eq.add(imp.substring(end, end + 1));
                i++;
                start = i;
            }
        }
    }

    static int getPrecedence(String input) {
        switch (input) {
            case "\u002B":
                return 1;
            case "-":
                return 1;
            case "\u00D7":
                return 2;
            case "\u00F7":
                return 2;
            default:
                return -1;
        }
    }

    static String shuntingYard() {
        eq.clear();
        toEquation();
        ArrayList<String> num = new ArrayList<>();
        num.clear();
        Deque<String> op = new ArrayDeque<>();
        for (int i = 0; i < eq.size(); i++) {
            if (getPrecedence(eq.get(i)) == -1) {
                num.add(eq.get(i));
            } else if (op.isEmpty() || getPrecedence(eq.get(i)) > getPrecedence(op.peek())) {
                op.push(eq.get(i));
            } else {
                num.add(op.pop());
                op.push(eq.get(i));
            }
        }
        while (!op.isEmpty()) {
            num.add(op.pop());
        }
        return result(num);
    }

    static String result(ArrayList<String> num) {
        Deque<Double> stack = new ArrayDeque<>();
        for (String s : num) {
            try {
                double n = Double.parseDouble(s);
                stack.push(n);
            } catch (Exception e) {
                double last = stack.pop();
                double prev = stack.pop();
                switch (s) {
                    case "\u002B":
                        stack.push(prev + last);
                        break;
                    case "-":
                        stack.push(prev - last);
                        break;
                    case "\u00D7":
                        stack.push(prev * last);
                        break;
                    case "\u00F7":
                        if (last == 0) {
                            return "Division by 0";
                        } else {
                            stack.push(prev / last);
                        }
                        break;
                }
            }
        }

        DecimalFormat format = new DecimalFormat("0.####");
        return format.format(stack.pop());
    }

}
