package ru.kykyis.service;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseService {

    protected static List<String> parse(String expression) {
        List<String> expList = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d+\\.*\\d+)|[^\\s]");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            expList.add(matcher.group());
        }
        return expList;
    }
}
