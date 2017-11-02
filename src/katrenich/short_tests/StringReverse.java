package short_tests2;

import java.util.Arrays;



public class StringReverse {
    public static String reverse(String msg){
        msg = msg.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = msg.length() - 1, k = 0; i >= k; i--) {
            sb.append(msg.charAt(i));
        }
        return sb.toString();
    }

    public static boolean isAnnagrams(String s1, String s2){
        if (s1.length() == s2.length()){
            s1 = s1.toLowerCase();
            s2 = s2.toLowerCase();

            char[] text1 = s1.toCharArray();
            char[] text2 = s2.toCharArray();

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    sort(text1);
                }
            });
            thread1.start();
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    sort(text2);
                }
            });
            thread2.start();

            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return Arrays.equals(text1, text2);

        }

        return false;
    }

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
