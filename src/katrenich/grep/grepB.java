package grep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * Необходимо реализовать консольную программу, которая бы фильтровала поток текстовой информации
 * подаваемой на вход и на выходе показывала лишь те строчки, которые содержат слово передаваемое
 * программе на вход в качестве аргумента.
 * B) В аргументах может быть передано не одно слово, а несколько
 */

public class grepB {
    public static void main(String[] args) {
        if(args.length > 0){
            System.out.println("Для виходу введіть: \"quit\" ");
            String data = readFromConsolLine().toLowerCase();

            while (true){
                boolean accept = false;
                for (String arg : args) {
                    arg = arg.toLowerCase();
                    if(data.contains(arg)){
                       accept = true;
                    } else {
                        accept = false;
                        break;
                    }
                }

                if(accept){
                    System.out.println(data);
                } else if(data.equals("quit") || data.equals("q")){
                    break;
                }
                data = readFromConsolLine().toLowerCase();
            }

        } else {
            System.out.println("Задайте декілька аргументів для виконання програми та запустіть програму ще раз");
        }
    }

    private static String readFromConsolLine(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = "";

        try {
            data = reader.readLine();
        } catch (IOException e) {
            System.out.println("Помилка зчитування даних");
        }

        return data;
    }
}
