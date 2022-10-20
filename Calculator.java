//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();
        System.out.println(calc(exp));
    }

    public static String calc(String exp) {
        Converter converter = new Converter();
        int actionIndex = -1;
        int check = 0;
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

                    int result;
                    switch (actions[actionIndex]) {
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a - b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                        default:
                            result = a / b;
                    }

                    if (isRoman) {
                        StringResult = converter.intToRoman(result);
                        return  StringResult;
                    } else {
                        StringResult = Integer.toString(result);
                        return  StringResult;
                    }
                } else {
                    StringResult = "Используются одновременно разные системы счисления";
                    return  StringResult;

                }
            } catch (Exception var14) {
                StringResult = "Неверный формат: " + var14;
                return  StringResult;
            }
        }
    }
}























































/*import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        Scanner scn = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String exp = scn.nextLine();
        int actionIndex=-1;

        int i = 0;
        for(int s = 0; s < exp.length(); s++) {
                    int a = exp.length() - exp.replace(actions[i], "").length();
                    if(exp.contains(actions[i])) {
                        actionIndex++;
                    }
                    if(i >= 3){
                        i = 0;
                    }
                    if(a > 1){
                        System.out.println("Error: т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                        return;
                    }
                    i++;

        }

        if(actionIndex==-1){
            System.out.println("Неверный формат: некорректное выражение");
            return;
        }
        String[] data = exp.split(regexActions[actionIndex]);
        System.out.println(data[1]);
            if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
                int a, b;
                boolean isRoman = converter.isRoman(data[0]);


                if (isRoman) {
                    a = converter.romanToInt(data[0]);
                    b = converter.romanToInt(data[1]);

                } else {
                    a = Integer.parseInt(data[0]);
                    b = Integer.parseInt(data[1]);

                }
                int result;
                switch (actions[actionIndex]) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    default:
                        result = a / b;
                        break;
                }
                if (isRoman) {
                    System.out.println(converter.intToRoman(result));
                } else {
                    System.out.println(result);
                }
            } else {
                System.out.println("Error: используются одновременно разные системы счисления");
            }




    }
}*/
