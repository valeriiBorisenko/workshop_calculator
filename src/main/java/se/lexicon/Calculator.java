package se.lexicon;

import java.util.Objects;
import java.util.Scanner;

public class Calculator {

    public void calculator() {
        boolean isActive = true;
        float number1 = 0;
        float number2;
        String method;

        while (isActive) {
            Scanner scanner = new Scanner(System.in);

            if (number1 == 0) {
                answerPrint("Write number");
                number1 = scanner.nextFloat();
            }

            printMenu();
            method = scanner.next();

            if (Objects.equals(method, "0")) {
                isActive = false;
                answerPrint("Exit");
                scanner.close();
            } else if (Objects.equals(method, "+") || Objects.equals(method, "-") || Objects.equals(method, "*") || Objects.equals(method, "/")) {
                answerPrint("Write number");
                number2 = scanner.nextFloat();

                number1 = switch (method) {
                    case ("+") -> {
                        resultPrint(number1 + " + " + number2 + " = " + (number1 + number2));
                        yield number1 + number2;
                    }
                    case ("-") -> {
                        resultPrint(number1 + " - " + number2 + " = " + (number1 - number2));
                        yield number1 - number2;
                    }
                    case ("*") -> {
                        resultPrint(number1 + " * " + number2 + " = " + (number1 * number2));
                        yield number1 * number2;
                    }
                    case ("/") -> {
                        resultPrint(number1 + " / " + number2 + " = " + (number1 / number2));
                        yield number1 / number2;
                    }
                    default -> number1;
                };
            } else {
                answerPrint("Wrong operation!");
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Write operation: + | - | * | /");
        System.out.println("For exit write: 0");
    }

    private void answerPrint(String text) {
        System.out.println();
        System.out.println(text);
    }

    private void resultPrint(String text) {
        System.out.println();
        System.out.println("Result:");
        System.out.println(text);
    }
}
