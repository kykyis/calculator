package ru.kykyis.service;

import ru.kykyis.exception.IllegalSymbolException;
import ru.kykyis.exception.TwoOperatorsOrNumbersInRowException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalculatorService {

    public static Double calculate(String expression) throws IllegalSymbolException, TwoOperatorsOrNumbersInRowException {
        List<String> expList = ValidationService.validation(ParseService.parse(expression));
        Stack<String> stack = getReversePolishNotation(expList);
        Stack<Double> numberStack = new Stack<>();

        while (!stack.empty()) {
            String s = stack.pop();
            if (s.startsWith("n")) {
                numberStack.push(Double.parseDouble(s.substring(1)));
            } else {
                Double secondOperand = numberStack.pop();
                Double firstOperand = numberStack.pop();
                numberStack.push(operation(firstOperand, secondOperand, s));
            }
        }
        return numberStack.pop();

    }

    private static int getPriority(String s) {
        switch (s) {
            case ("+"):
            case ("-"):
                return 0;
            default:
                return 1;
        }
    }

    private static Stack<String> getReversePolishNotation(List<String> expList) {
        List<String> outputString = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String s : expList) {
            try {
                Double.parseDouble(s);
                outputString.add("n" + s);
            } catch (NumberFormatException e) {
                while (!stack.empty() && getPriority(stack.peek()) >= getPriority(s)) {
                    outputString.add(stack.pop());
                }
                stack.push(s);
            }
        }
        for (int i = outputString.size() - 1; i >= 0; i--) {
            stack.push(outputString.get(i));
        }
        return stack;
    }

    private static Double operation(Double first, Double second, String operator) {
        Double result = null;
        if ("+".equals(operator)) {
            result = first + second;
        } else if ("-".equals(operator)) {
            result = first - second;
        } else if ("*".equals(operator)) {
            result = first * second;
        } else if ("/".equals(operator)) {
            result = first / second;
        }
        return result;
    }
}
