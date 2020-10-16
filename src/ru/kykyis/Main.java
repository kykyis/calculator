package ru.kykyis;

import ru.kykyis.exception.IllegalSymbolException;
import ru.kykyis.exception.TwoOperatorsOrNumbersInRowException;
import ru.kykyis.view.ConsoleView;

public class Main {

    public static void main(String[] args) throws IllegalSymbolException, TwoOperatorsOrNumbersInRowException {
        ConsoleView.input();
        ConsoleView.printResult();
    }
}
