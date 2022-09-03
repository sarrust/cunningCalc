import java.util.Scanner;

public class Calc1 {
        public static void main(String[] args) throws Exception{
            CalculatorHelper calculatorHelper = new CalculatorHelper();
            System.out.println("Введите выражение:");
            Scanner myObj = new Scanner(System.in);
            String input = myObj.nextLine();
            System.out.println(calculatorHelper.calc(input));
        }
    }
    class CalculatorHelper {
        public String calc(String input) throws Exception {
            String[] splitText = input.split(" ");
            boolean arab = false;
            boolean rome = false;
            int letter1, letter2;
            int result = 0;
            int countLetters = 0;
            if (splitText.length > 4) {
                throw new Exception("Ошибка! Формат математической операции не " +
                        "удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            } else {
                for (int i = 0; i < 3; i += 2) {
                    try {
                        Integer.parseInt(splitText[i]);
                        arab = true;
                    } catch (NumberFormatException e) {
                        rome = true;
                        countLetters++;
                    }
                }
                if (countLetters == 1) {
                    throw new Exception("Ошибка! Не правильный формат ввода!");
                }
                String output = "";
                if (rome) {
                    letter1 = ConvertRome(splitText[0]);
                    letter2 = ConvertRome(splitText[2]);
                    result = getResultRome(letter1, letter2, splitText[1]);
                    if (letter1 < 0 || letter1 > 10 || letter2 < 0 || letter2 > 10 || letter1 == 0 || letter2 == 0) {
                        System.out.println("Ошибка! Вы ввели не правильные значения!");
                    } else {
                        IntegerToRomanNumeral(result);
                    }
                }
                if (arab) {
                    letter1 = Integer.parseInt(splitText[0]);
                    letter2 = Integer.parseInt(splitText[2]);
                    result = getResultArab(letter1, letter2, splitText[1]);
                    if (letter1 < 0 || letter1 > 10 || letter2 < 0 || letter2 > 10) {
                        System.out.println("Ошибка! Вы ввели не правильные значения!");
                    } else output = String.valueOf(result);
                }
                return output;
            }
        }

        public int getResultRome(int letter1, int letter2, String s) throws Exception {
            int result = 0;
            switch (s) {
                case "/":
                    result = letter1 / letter2;
                    break;
                case "+":
                    result = letter1 + letter2;
                    break;
                case "-":
                    result = letter1 - letter2;
                    break;
                case "*":
                    result = letter1 * letter2;
                    break;
                default:
                    throw new Exception("Ошибка! Не правильный формат ввода");
            }
            return result;
        }

        public Integer getResultArab(int letter1, int letter2, String s) throws Exception {
            int result = 0;
            switch (s) {
                case "/":
                    result = letter1 / letter2;
                    break;
                case "+":
                    result = letter1 + letter2;
                    break;
                case "-":
                    result = letter1 - letter2;
                    break;
                case "*":
                    result = letter1 * letter2;
                    break;
                default:
                    throw new Exception("Ошибка! Не правильный формат ввода");
            }
            return result;
        }

        public static int ConvertRome(String letter) {
            if (letter.equals("I")) return 1;
            if (letter.equals("II")) return 2;
            if (letter.equals("III")) return 3;
            if (letter.equals("IV")) return 4;
            if (letter.equals("V")) return 5;
            if (letter.equals("VI")) return 6;
            if (letter.equals("VII")) return 7;
            if (letter.equals("VIII")) return 8;
            if (letter.equals("IX")) return 9;
            if (letter.equals("X")) return 10;
            else {
                System.out.println("Вы ввели неправильное значение!");
            }
            return 0;
        }

        public static void IntegerToRomanNumeral(double input) {
            if (input < 1 || input > 3999)
                System.out.println("Ошибка! Не существующая римская цифра");
            StringBuilder s = new StringBuilder();
            while (input >= 100) {
                s.append("C");
                input -= 100;
            }
            while (input >= 90) {
                s.append("XC");
                input -= 90;
            }
            while (input >= 50) {
                s.append("L");
                input -= 50;
            }
            while (input >= 40) {
                s.append("XL");
                input -= 40;
            }
            while (input >= 10) {
                s.append("X");
                input -= 10;
            }
            while (input >= 9) {
                s.append("IX");
                input -= 9;
            }
            while (input >= 5) {
                s.append("V");
                input -= 5;
            }
            while (input >= 4) {
                s.append("IV");
                input -= 4;
            }
            while (input >= 1) {
                s.append("I");
                input -= 1;
            }
            System.out.println(s.toString());
        }
    }
