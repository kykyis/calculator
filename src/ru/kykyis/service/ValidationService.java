package ru.kykyis.service;

import ru.kykyis.exception.IllegalSymbolException;
import ru.kykyis.exception.TwoOperatorsOrNumbersInRowException;

import java.util.*;

public class ValidationService {
    private final static Set<Character> validOperators = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

    protected static List<String> validation(List<String> expList) throws IllegalSymbolException, TwoOperatorsOrNumbersInRowException {
        if (validOperators.contains(expList.get(0).charAt(0))) {
            throw new IllegalSymbolException("операнд в начале выражения");
        }
        int countOfNumbersInRow = 0;
        int countOfOperatorsInRow = 0;
        for (String s : expList) {
            try {
                Double.parseDouble(s);
                countOfOperatorsInRow = 0;
                countOfNumbersInRow++;
            } catch (NumberFormatException e) {
                if (!validOperators.contains(s.charAt(0))) {
                    throw new IllegalSymbolException(s);
                }
                countOfNumbersInRow = 0;
                countOfOperatorsInRow++;
            }
            if (countOfNumbersInRow >= 2 || countOfOperatorsInRow >= 2) {
                throw new TwoOperatorsOrNumbersInRowException("Два оператора или числа подряд.");
            }
        }
        return expList;
    }
}
