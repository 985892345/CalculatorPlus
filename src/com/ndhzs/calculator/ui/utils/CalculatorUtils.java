package com.ndhzs.calculator.ui.utils;

import java.util.*;

/**
 * ...
 *
 * @author 985892345 (Guo Xiangrui)
 * @email 2767465918@qq.com
 * @date 2022/6/7 12:24
 */
public class CalculatorUtils {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("输入：");
            String input = scanner.next();
            System.out.println("结果为 = " + getResult(input));
        }
    }

    public static double getResult(String input) {
        Deque<String> dequeLRD = transformLRD(input);
        Deque<String> dequeResult = new ArrayDeque<>();
        while (!dequeLRD.isEmpty()) {
            String first = dequeLRD.removeFirst();
            if (!first.matches("(^\\d.*)|(^-\\d.*)")) {
                switch (first) {
                    case "+" :
                    case "-" :
                    case "×" :
                    case "÷" :
                    case "%" :
                    case "^" :
                        String  b = dequeResult.removeLast();
                        String  a = dequeResult.removeLast();
                        dequeResult.add(binaryCalculate(a, b, first));
                        break;
                    case "√" :
                    case "!" :
                    case "lg(" :
                    case "ln(" :
                    case "sin(" :
                    case "cos(" :
                    case "tan(" :
                    case "csc(" :
                    case "sec(" :
                    case "cot(" :
                    case "arcsin(" :
                    case "arccos(" :
                    case "arctan(" :
                        String c = dequeResult.removeLast();
                        dequeResult.add(unaryOperation(c, first));
                }
            } else {
                dequeResult.add(first);
            }
        }
        return Double.parseDouble(dequeResult.getFirst());
    }

    private static String unaryOperation(String a, String symbol) {
        double x = Double.parseDouble(a);
        double result = 0;
        switch (symbol) {
            case "√" :
                result = Math.sqrt(x);
                break;
            case "!" :
                result = 1;
                if (x < 1) {
                    throw new RuntimeException("阶乘出错，x = " + x);
                }
                while (x != 1) {
                    result *= x;
                    x--;
                }
                break;
            case "lg(" :
                result = Math.log10(x);
                break;
            case "ln(" :
                result = Math.log1p(x - 1);
                break;
            case "sin(" :
                result = Math.sin(x);
                break;
            case "cos(" :
                result = Math.cos(x);
                break;
            case "tan(" :
                result = Math.tan(x);
                break;
            case "csc(" :
                result = Math.pow(Math.sin(x), -1);
                break;
            case "sec(" :
                result = Math.pow(Math.cos(x), -1);
                break;
            case "cot(" :
                result = Math.cos(x) / Math.sin(x);
                break;
            case "arcsin(" :
                result = Math.asin(x);
                break;
            case "arccos(" :
                result = Math.acos(x);
                break;
            case "arctan(" :
                result = Math.atan(x);
                break;
        }
        return String.valueOf(result);
    }

    private static String binaryCalculate(String a, String b, String symbol) {
        double x = Double.parseDouble(a);
        double y = Double.parseDouble(b);
        double result = 0;
        switch (symbol) {
            case "+" :
                result = x + y;
                break;
            case "-" :
                result = x - y;
                break;
            case "×" :
                result = x * y;
                break;
            case "÷" :
                result = x / y;
                break;
            case "%" :
                result = x % y;
                break;
            case "^" :
                result = Math.pow(x, y);
                break;
        }
        return String.valueOf(result);
    }


    private static final Map<String, Integer> PRIORITY_MAP = new HashMap<>();

    static {
        PRIORITY_MAP.put("+", 1);
        PRIORITY_MAP.put("-", 1);
        PRIORITY_MAP.put("×", 2);
        PRIORITY_MAP.put("÷", 2);
        PRIORITY_MAP.put("%", 2);
        PRIORITY_MAP.put("√", 3);
        PRIORITY_MAP.put("^", 4);
        PRIORITY_MAP.put("!", 5);
        PRIORITY_MAP.put("(", 0);
        PRIORITY_MAP.put("lg(", 0);
        PRIORITY_MAP.put("ln(", 0);
        PRIORITY_MAP.put("sin(", 0);
        PRIORITY_MAP.put("cos(", 0);
        PRIORITY_MAP.put("tan(", 0);
        PRIORITY_MAP.put("csc(", 0);
        PRIORITY_MAP.put("sec(", 0);
        PRIORITY_MAP.put("cot(", 0);
        PRIORITY_MAP.put("arcsin(", 0);
        PRIORITY_MAP.put("arccos(", 0);
        PRIORITY_MAP.put("arctan(", 0);
    }

    private static Deque<String> transformLRD(String input) {
        List<String> substringList = new ArrayList<>();
        getSubstring(0, input.length() - 1, input, substringList);
        ArrayDeque<String> dequeLRD = new ArrayDeque<>();
        ArrayDeque<String> dequeSymbol = new ArrayDeque<>();
        String last0 = substringList.get(substringList.size() - 1);
        if (last0.endsWith("e")) {
            // 如果已 e 结尾，则需要把它改为大小，而不是科学计数法
            String num = last0.substring(0, last0.length() - 1);
            substringList.remove(substringList.size() - 1);
            substringList.add(String.valueOf(Double.parseDouble(num) * Math.E));
        }
        for (String s : substringList) {
            if (s.matches("(^\\d.*)|(^-\\d.*)")) {
                dequeLRD.add(s);
            } else {
                if (s.contains("(")) {
                    dequeSymbol.add(s);
                } else if (")".equals(s)) {
                    String last = dequeSymbol.removeLast();
                    while (!last.contains("(")) {
                        dequeLRD.add(last);
                        last = dequeSymbol.removeLast();
                    }
                    if (!"(".equals(last)) {
                        dequeLRD.add(last);
                    }
                } else {
                    if (!dequeSymbol.isEmpty()) {
                        String last = dequeSymbol.getLast();
                        if ("√".equals(s) && "√".equals(last)) {
                            // 解决 √√  问题，后面已经压栈
                        } else {
                            while (PRIORITY_MAP.get(s) <= PRIORITY_MAP.get(last)) {
                                dequeLRD.add(dequeSymbol.removeLast());
                                if (!dequeSymbol.isEmpty()) {
                                    last = dequeSymbol.getLast();
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                   dequeSymbol.add(s);
                }
            }
        }
        while (!dequeSymbol.isEmpty()) {
            String last = dequeSymbol.removeLast();
            if (!"(".equals(last)) {
                dequeLRD.add(last);
            }
        }
        return dequeLRD;
    }

    private static void getSubstring(int start, int end, String input, List<String> substringList) {
        if (start == end + 1) {
            return;
        }
        char c = input.charAt(start);
        if (Character.isDigit(c)) {
            if (!substringList.isEmpty()) {
                String last = substringList.get(substringList.size() - 1);
                if (last.matches("(^[-1-9]\\d*((\\.)|(\\d)|(\\.\\d+)|(\\.?\\d*e[+-]?\\d*))$)|^[1-9]$|^0((\\.\\d*)|(\\.\\d+e[+-]?\\d*))$")) {
                    substringList.remove(substringList.size() - 1);
                    substringList.add(last + c);
                } else if ("-".equals(last)) {
                    if (substringList.size() >= 2) {
                        String lastSecond = substringList.get(substringList.size() - 2);
                        if ("(".equals(lastSecond)) {
                            substringList.remove(substringList.size() - 1);
                            substringList.add(last + c);
                        } else  {
                            substringList.add(String.valueOf(c));
                        }
                    } else {
                        substringList.remove(0);
                        substringList.add(last + c);
                    }
                } else {
                    if (last.matches("[)!]$")) {
                        substringList.add("×");
                    }
                    substringList.add(String.valueOf(c));
                }
            } else {
                substringList.add(String.valueOf(c));
            }
            getSubstring(start + 1, end, input, substringList);
            return;
        } else {
            // 输入的不是数字
            if (!substringList.isEmpty()) {
                String last = substringList.get(substringList.size() - 1);
                if (last.endsWith("e")) {
                    // 如果已 e 结尾，则需要把它改为大小，而不是科学计数法
                    String num = last.substring(0, last.length() - 1);
                    substringList.remove(substringList.size() - 1);
                    substringList.add(String.valueOf(Double.parseDouble(num) * Math.E));
                }
            }
        }
        char c2 = ' ';
        if (start + 1 <= end) {
            c2 = input.charAt(start + 1);
        }
        char c3 = ' ';
        if (start + 2 <= end) {
            c3 = input.charAt(start + 2);
        }
        char c4 = ' ';
        if (start + 3 <= end) {
            c4 = input.charAt(start + 3);
        }
        switch (c) {
            case ' ':
                getSubstring(start + 1, end, input, substringList);
                break;
            case '+':
                substringList.add("+");
                getSubstring(start + 1, end, input, substringList);
                break;
            case '-':
                substringList.add("-");
                getSubstring(start + 1, end, input, substringList);
                break;
            case '×':
                substringList.add("×");
                getSubstring(start + 1, end, input, substringList);
                break;
            case '÷':
                substringList.add("÷");
                getSubstring(start + 1, end, input, substringList);
                break;
            case '%':
                substringList.add("%");
                getSubstring(start + 1, end, input, substringList);
                break;
            case '^' :
                substringList.add("^");
                getSubstring(start + 1, end, input, substringList);
                break;
            case '!' :
                substringList.add("!");
                getSubstring(start + 1, end, input, substringList);
                break;
            case '√' :
                if (!substringList.isEmpty()) {
                    if (substringList.get(substringList.size() - 1).matches("(^\\d.*)|!|\\)")) {
                        substringList.add("×");
                    }
                }
                substringList.add("√");
                getSubstring(start + 1, end, input, substringList);
                break;
            case '(' :
                if (!substringList.isEmpty()) {
                    if (substringList.get(substringList.size() - 1).matches("(^\\d.*)|!|\\)")) {
                        substringList.add("×");
                    }
                }
                substringList.add("(");
                getSubstring(start + 1, end, input, substringList);
                break;
            case ')' :
                substringList.add(")");
                getSubstring(start + 1, end, input, substringList);
                break;
            case 'l' :
                if (!substringList.isEmpty()) {
                    if (substringList.get(substringList.size() - 1).matches("(^\\d.*)|!|\\)")) {
                        substringList.add("×");
                    }
                }
                if (c2 == 'g') {
                    substringList.add("lg(");
                } else {
                    substringList.add("ln(");
                }
                getSubstring(start + 3, end, input, substringList);
                break;
            case 's' :
                if (!substringList.isEmpty()) {
                    if (substringList.get(substringList.size() - 1).matches("(^\\d.*)|!|\\)")) {
                        substringList.add("×");
                    }
                }
                if (c2 == 'i') {
                    substringList.add("sin(");
                } else {
                    substringList.add("sec(");
                }
                getSubstring(start + 4, end, input, substringList);
                break;
            case 'c' :
                if (!substringList.isEmpty()) {
                    if (substringList.get(substringList.size() - 1).matches("(^\\d.*)|!|\\)")) {
                        substringList.add("×");
                    }
                }
                if (c3 == 's') {
                    substringList.add("cos(");
                } else if (c3 == 'c') {
                    substringList.add("csc(");
                } else if (c3 == 't') {
                    substringList.add("cot(");
                }
                getSubstring(start + 4, end, input, substringList);
                break;
            case 't' :
                if (!substringList.isEmpty()) {
                    if (substringList.get(substringList.size() - 1).matches("(^\\d.*)|!|\\)")) {
                        substringList.add("×");
                    }
                }
                substringList.add("tan(");
                getSubstring(start + 4, end, input, substringList);
                break;
            case 'a' :
                if (!substringList.isEmpty()) {
                    if (substringList.get(substringList.size() - 1).matches("(^\\d.*)|!|\\)")) {
                        substringList.add("×");
                    }
                }
                if (c4 == 's') {
                    substringList.add("arcsin(");
                } else if (c4 == 'c') {
                    substringList.add("arccos(");
                } else {
                    substringList.add("arctan(");
                }
                getSubstring(start + 7, end, input, substringList);
                break;
            case 'π' :
               if (!substringList.isEmpty()) {
                    String last = substringList.get(substringList.size() - 1);
                    if (last.matches("(^[-1-9]\\d*((\\d)|(\\.\\d+)|(\\.?\\d*e[+-]?\\d+))$)|^[1-9]$|^0((\\.\\d*)|(\\.\\d+e[+-]?\\d*))$")) {
                        double lastResult = Double.parseDouble(last);
                        String result = String.valueOf(lastResult * Math.PI);
                        substringList.remove(substringList.size() - 1);
                        substringList.add(result);
                    } else {
                        substringList.add(String.valueOf(Math.PI));
                    }
                } else {
                    substringList.add(String.valueOf(Math.PI));
                }
                getSubstring(start + 1, end, input, substringList);
                break;
            case 'e' :
                if (!substringList.isEmpty()) {
                    String last = substringList.get(substringList.size() - 1);
                    if (last.matches("(^[-1-9]\\d*((\\d)|(\\.\\d+))$)|^[1-9]$|^0(\\.\\d+)")) {
                        substringList.remove(substringList.size() - 1);
                        substringList.add(last + "e");
                    } else {
                        substringList.add(String.valueOf(Math.E));
                    }
                } else {
                    substringList.add(String.valueOf(Math.E));
                }
                getSubstring(start + 1, end, input, substringList);
                break;
            case '.' :
                if (!substringList.isEmpty()) {
                    String last = substringList.get(substringList.size() - 1);
                    if (last.matches("(^[-\\d]\\d*(\\d)$)|^\\d$")) {
                        substringList.remove(substringList.size() - 1);
                        substringList.add(last + ".");
                    }
                }
                getSubstring(start + 1, end, input, substringList);
                break;
        }
    }
}
