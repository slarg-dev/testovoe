//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();
        System.out.println(calc(exp));
    }

    public static String calc(String exp) {
        Converter converter = new Converter();
        int actionIndex = -1;
        int check;
        String StringResult;
        String[] actions = new String[]{"+", "-", "/", "*"};
        String[] regexActions = new String[]{"\\+", "-", "/", "\\*"};
        for (int i = 0; i < actions.length; i++) {
            if (exp.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1) {
            StringResult = "Неверный формат: некорректное выражение";
            return  StringResult;
        } else {
            String[] data = exp.split(regexActions[actionIndex]);
            try {
                check = exp.length() - exp.replace(actions[actionIndex], "").length();
                if (check > 1) {
                    StringResult = "Должно быть одно выражение";
                    return  StringResult;
                }
                if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {

                    boolean isRoman = converter.isRoman(data[0]);
                    int a;
                    int b;
                    if (isRoman) {
                        a = converter.romanToInt(data[0]);
                        b = converter.romanToInt(data[1]);
                    } else {
                        a = Integer.parseInt(data[0]);
                        b = Integer.parseInt(data[1]);
                    }

                    int result = switch (actions[actionIndex]) {
                        case "+" -> a + b;
                        case "-" -> a - b;
                        case "*" -> a * b;
                        default -> a / b;
                    };

                    if (isRoman) {
                        StringResult = converter.intToRoman(result);
                    } else {
                        StringResult = Integer.toString(result);
                    }
                } else {
                    StringResult = "Используются одновременно разные системы счисления";

                }
                return  StringResult;
            } catch (Exception var14) {
                StringResult = "Неверный формат: " + var14;
                return  StringResult;
            }
        }
    }
}
























































