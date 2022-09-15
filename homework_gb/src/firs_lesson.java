public class firs_lesson {
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        }
        catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
        catch (Throwable ex) {
            /* Должно стоять последним, иначе остальные блоки не выполнятся никогда */
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b) throws Exception {
        /* FileNotFoundException - выдает ошибку: не удается разрешить символ
         Судя по информации в гугле, после оператора throws перечисляются исключения,
         которые метод может выкинуть.
         Наш метод не обращается ни к каким файлам или каталогам, то и использовать
         FileNotFoundException не имеет смысла*/
        System.out.println(a + b);
    }

}
