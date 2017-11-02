package grep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * Необходимо реализовать консольную программу, которая бы фильтровала поток текстовой информации
 * подаваемой на вход и на выходе показывала лишь те строчки, которые содержат слово передаваемое
 * программе на вход в качестве аргумента.
 * A) Программа не должна учитывать регистр
 */


public class grepA {
    public static void main(String[] args) {
        if(args.length == 1){
            String filter = args[0].toLowerCase();

            System.out.println("Для виходу введіть: \"quit\" ");
            String data = readFromConsolLine().toLowerCase();

            while (true){
                if(data.contains(filter)){
                    System.out.println(data);
                } else if(data.equals("quit") || data.equals("q")){
                    break;
                }
                data = readFromConsolLine().toLowerCase();
            }

        } else {
            System.out.println("Задайте 1 аргумент для виконання програми та запустіть програму ще раз");
        }
    }

    private static String readFromConsolLine(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = "";

        try {
            data = reader.readLine();
        } catch (IOException e) {
            System.out.println("Помилка зчитування даних");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Помилка закриття потоку вводу");
            }
        }

        return data;
    }
}
