package tasks;

import java.util.ArrayList;

public class СheckingСorrectnessNumber {

    public static ArrayList checkCorrectNumber(String number){
        String newNumbr = number;
        String errors = "";
        ArrayList output = new ArrayList();
        if (number.startsWith("+7")) {
            newNumbr = "8" + newNumbr.substring(2, number.length());
            errors = "Замена +7 на 8; ";
        }
        String correctNumber = "";
        for (int i = 0; i < newNumbr.length(); i++){
            if (number.charAt(i) == ' ') {
            }
            else if (number.charAt(i) == '('){
            }
            else if (number.charAt(i) == ')') {
            }
            else {
                correctNumber = correctNumber + newNumbr.charAt(i);
            }
        }
        if (!(correctNumber.equals(newNumbr))){
            newNumbr = correctNumber;
            errors = errors + "В номере есть пробелы и/или скобки";
        }
        if (newNumbr.length() != 11) {
            output.add("Введен некорректный номер");
            output.add("Сумма символов не равна 11");
        }
        else {
            output.add(newNumbr);
            if (errors.isEmpty()) output.add("Не было изменений");
            else output.add(errors);
        }
        return output;
    }

    public static void main(String[] args) {
        String number = "89537376770";
        String number1 = "+79537376770";
        String number2 = "8 (953) 737 67 70";
        String number3 = "8 (953) 737 67 7000";
        System.out.println(checkCorrectNumber(number));
        System.out.println(checkCorrectNumber(number1));
        System.out.println(checkCorrectNumber(number2));
        System.out.println(checkCorrectNumber(number3));
    }
}
