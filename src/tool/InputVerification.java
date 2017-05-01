package tool;

import message.TreeMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class InputVerification {
    // Принимает введенное из консоли число и проверяет на правильность (inputNumber > 0)
    public static int inputNumber() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = -1;

        while (inputNumber <= 0) {
            try {
                inputNumber = Integer.parseInt(reader.readLine());

                if (inputNumber > 0) {
                    return inputNumber;
                }
                else {
                    System.out.println(TreeMessage.VALUE_MUST_BE_POSITIVE);
                }
            } catch (NumberFormatException | InputMismatchException ex) {
                System.out.println(TreeMessage.WRONG_INPUT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    // Возвращает правильную строку
    // preInputMessage - строка, обозначающая, что надо ввести
    public static String inputString(String preInputMessage) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println(preInputMessage);
            String string = reader.readLine().trim();
            if (string.equals("")) {
                System.out.println(TreeMessage.WRONG_STRING_INPUT);
            }
            else {
                return string;
            }
        }
    }
}
