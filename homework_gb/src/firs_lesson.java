import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class firs_lesson {
    public static void main(String[] args) {

    }

    /* Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
    вместо этого, необходимо повторно запросить у пользователя ввод данных. */
    public static void Echo(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите дробное число с запятой: ");
        try{
            float userAnswer = in.nextFloat();
            System.out.println(userAnswer);
        }
        catch (Exception ex){
            System.out.println("Вы ввели некорректное значение");
            Echo();
        }
    }

    //Если необходимо, исправьте данный код
    public static void taskTwo(int[] intArray){     //Добавляю определение intArray
        System.out.println("Start");
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            //Дополнительный блок, на случай, если массив слишком короткий
            /* Этот блок должен быть перед блоком, отлавливающим деление на 0,
            т.к. иначе он не выполнится, ведь деление на 0 будет в любом случае*/
            System.out.println("Catching exception: " + e);
        }
        catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }

    /* Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    Пользователю должно показаться сообщение, что пустые строки вводить нельзя. */
    public static void NotEmptyString(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите НЕ пустую строку: ");
        String userAnswer = in.nextLine();
        if( userAnswer.isEmpty() ){
            throw new RuntimeException("Пустые строки вводить нельзя");
        }
    }
}
