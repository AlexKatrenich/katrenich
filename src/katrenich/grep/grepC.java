package katrenich.grep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * Необходимо реализовать консольную программу, которая бы фильтровала поток текстовой информации
 * подаваемой на вход и на выходе показывала лишь те строчки, которые содержат слово передаваемое
 * программе на вход в качестве аргумента.
 * C) В качестве аргумента может быть задано не конкретное слово, а регулярное выражение
 */

public class grepC {
    public static void main(String[] args) {
    }

    private boolean checkText(String data, String args){
        Pattern p = Pattern.compile(args);
        Matcher m = p.matcher(data);
        return m.matches();
    }
}
