import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class userData {
    public String firstName;
    public String lastName;
    public String patronymic;
    public long phoneNumber = 0;
    public Date dateBirth = new Date();
    public char gender = ' ';

    userData(){
        DataAnalysis(DataEntry());
    }

    // Запрашивает данные, проверяет данные по количеству
    private String[] DataEntry() {
        /* Не очень яно по заданию должно ли быть ФИО тоже в разнобой или в своем порядке
         Я решила оставить по порядку, вычлинять эти данные очень долго */
        Scanner scanner = new Scanner(System.in);
        byte amoutData = 6;
        System.out.println("Введите ФИО, номер, дату рождения и пол в произвольном порядке через пробел");
        System.out.println("Например: Петров Иван Артёмович m 30.06.1995 88005553535");
        String userStr = scanner.nextLine();
        String[] userData = userStr.split(" ");
        if (userData.length == amoutData) {
            return userData;
        } else if (userData.length > amoutData) {
            throw new RuntimeException("Данных введено слишком много.");
        } else if (userData.length < amoutData) {
            throw new RuntimeException("Данных введено слишком мало.");
        } else {
            throw new RuntimeException("Что-то пошло не так.");
        }
    }

    //Анализирует данные
    private void DataAnalysis(String[] userData) {
        for(int i = 0; i < userData.length; i++){
            // Анализ пола
            if(userData[i].length() == 1) {
                GenderAnalysis(userData[i]);
            }
            // Анализ номера (предполагается, что в номере 11 цифр)
            //  и начинается с 8
            char[] somenumber = userData[i].toCharArray();
            if (userData[i].length() == 11 && somenumber[0] == '8') {
                PhoneNumberAnalysis(userData[i]);
            }
            // Анализ даты
            // Третий символ ДОЛЖЕН быть точкой
            char[] somedate = userData[i].toCharArray();
            if (userData[i].length() == 10 && somedate[2] == '.') {
                Birthday(userData[i]);
            }
            // Анализ ФИО
            if (lastName == null){
                if (Pattern.matches("[а-яА-я]+", userData[i]) && !userData[i].matches("[0-9]+")){
                    lastName = userData[i];
                    firstName = userData[i + 1];
                    patronymic = userData[i + 2];
                }
            }
        }
    }

    // Метод установки пола
    private void GenderAnalysis(String somegender){
        if(somegender.equals("f")) {
            gender = 'f';
        } else if (somegender.equals("m")) {
            gender = 'm';
        } else {
            throw new RuntimeException("Вы указали недопустимый параметр пола");
        }
    }
    // Метод установки номера
    private void PhoneNumberAnalysis(String somenumber) {
        try {
            phoneNumber = Long.parseLong(somenumber);
        } catch (ClassCastException exception) {
            System.out.println("Введен недопустимый номер");
            throw exception;
        }
    }

    // Метод установки даты
    private void Birthday(String somedate) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            dateBirth = format.parse(somedate);
        } catch (ParseException exception) {
            throw new RuntimeException("Указана некорректная дата");
        }
    }
}
