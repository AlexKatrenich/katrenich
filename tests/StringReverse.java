package katrenich.tests;
import java.util.Arrays;

/** Завдання: написати додаток, що вирішуватиме наступні задачі:
 *  1) перевертає рядок(наприклад: abcde після перетворення буде edcba)
 *  2) перевіряє чи є два рядки анаграмами (Наприклад рядки:  мука - кума, літо - тіло)
 */


public class StringReverse {

    // метод читає рядок поданий на вході та повертає перевернутий рядок
    public static String reverse(String msg){
        msg = msg.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = msg.length() - 1, k = 0; i >= k; i--) {
            sb.append(msg.charAt(i));
        }
        return sb.toString();
    }

    // метод порівнює кількість букв в кожному слові(порівнюється кількість членів кожної букви).
    // повертає істину якщо всі кількості збігаються
    public static boolean isAnnagrams(String s1, String s2){
        if (s1.length() == s2.length()){
            s1 = s1.toLowerCase();
            s2 = s2.toLowerCase();

            char[] text1 = s1.toCharArray();
            char[] text2 = s2.toCharArray();

            // масиви літер кожного рядка сортуються в паралельних потоках виконання
            Thread thread1 = new Thread( () -> sort(text1));
            thread1.start();
            Thread thread2 = new Thread(() -> sort(text2));
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // результат порівняння відсортованих масивів повертається як результат виконання метода
            return Arrays.equals(text1, text2);

        }

        return false;
    }

    // метод сортує масив символів методом бульбашки
    private static void sort(char[] text) {
        for (int i = 0; i < text.length ; i++) {
            for (int j = 0; j < text.length - i - 1; j++) {
                if(text[j] > text[j+1]){
                    char tmp = text[j+1];
                    text[j+1] = text[j];
                    text[j] = tmp;
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("1) " + isAnnagrams("мука", "кума"));
        System.out.println("2) " + isAnnagrams("літо", "тіло"));
        System.out.println("3) " + isAnnagrams("school master", "the classroom"));
    }

}
