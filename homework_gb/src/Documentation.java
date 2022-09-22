import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Documentation {
    public static void WriteFile(String lastN, String firstN, String patronymic, long phone, Date birthday, char gender)
    {
        //<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
        String text = lastN +" "+ firstN +" "+ patronymic +" "+ birthday +" "+ phone +" "+ gender;
        String fileName = lastN + ".txt";

        try {
            File file = new File(fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(fileName);
            pw.println(text);
            pw.close();
        } catch (IOException exception){
            exception.fillInStackTrace();
        }
    }
}
