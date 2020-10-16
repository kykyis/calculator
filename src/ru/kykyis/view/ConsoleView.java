package ru.kykyis.view;

import ru.kykyis.exception.IllegalSymbolException;
import ru.kykyis.exception.TwoOperatorsOrNumbersInRowException;
import ru.kykyis.service.CalculatorService;

import java.util.Scanner;

public class ConsoleView {
    private static String expression;

    public static void input() {
        System.out.println("Введите выражение:");
        Scanner sc = new Scanner(System.in);
        expression = sc.nextLine();
    }

    public static void printResult() throws IllegalSymbolException, TwoOperatorsOrNumbersInRowException {
        Double result = CalculatorService.calculate(expression);
        System.out.println("Результат выражения:\n" + result);

    }
}
