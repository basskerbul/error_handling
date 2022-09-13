public class firs_lesson {
    public static void main(String[] args) {

    }
    //Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
    public static int method1(int a, int b){
        //Может появиться деление на 0
        return a/b;
    }
    public static void method2(int[] arr){
        //Переданный массив может оказаться короче, будет выход за пределы массива
        System.out.println(arr[10]);
    }
    public static int method3(String str){
        //Переданная строка может оказаться некорректной для перевода в int
        return Integer.parseInt(str.trim());
    }

    /* Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый
    массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
    Если длины массивов не равны, необходимо как-то оповестить пользователя. */
    public static int[] ArrayDifference(int[] a, int[] b){
        if(a.length != b.length){
            System.out.println("Массивы не равны. Возвращено значение null");
            return null;
        }

        int[] result = new int[a.length - 1];
        for(int i = 0; i < a.length; i++){
            result[i] = a[i] - b[i];
        }
        return result;
    }

    /* Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый
    массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если
    длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода
    единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше */
    public static int[] DividingArrays(int[] a, int[] b){
        if(a.length != b.length){
            throw new RuntimeException("Массивы разной длинны");
        }

        int[] result = new int[a.length - 1];
        for (int i = 0; i < a.length; i++){
            if(b[i] == 0){
                throw new RuntimeException("На ноль делить нельзя");
            }
            result[i] = a[i] / b[i];
        }
        return result;
    }

}
