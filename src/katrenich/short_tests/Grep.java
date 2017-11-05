package short_tests;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Потрібно написати програму, що вирішує наступні задачі:
 * Необходимо реализовать консольную программу, которая бы фильтровала поток текстовой информации подаваемой на вход и
 * на выходе показывала лишь те строчки, которые содержат слово передаваемое программе на вход в качестве аргумента.

 * Варианты усложнения:
 * Программа не должна учитывать регистр
 * В аргументах может быть передано не одно слово, а несколько
 */
public class Grep {
	public static void grepB(String[] args){
		if (args != null && args.length > 0){
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String inputData = "";

			try	{
				System.out.println("Введіть речення");
				inputData = br.readLine();
				boolean accept = false;
				while(!inputData.equals("quit")){
					for(String s: args){
						if(inputData.toLowerCase().contains(s.toLowerCase())){
							accept = true;
						} else {
							accept = false;
							break;
						}
					}
					if(accept){
						System.out.println(inputData);
					}
					inputData = br.readLine();
				}
			} catch (IOException e) {
				System.err.println("Помилка вводу даних!");
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("Помилка закриття потоку вводу!");
				}
			}
		} else {
			System.out.println("Задайте аргументи программи та запустіть спочатку");
		}
	}
}
