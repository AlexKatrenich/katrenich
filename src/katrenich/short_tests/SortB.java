package short_tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Написать консольную программу, которая бы сортировала текст поданный ей на стандартный вход по алфавиту.
 * Программа должна игнорировать регистр при сортировке
 * Программа должна сортировать не по алфавиту, а по количеству символов в строке
 * Программа в качестве аргумента может получать порядковый номер слова в строке, по которому надо сортировать строки
 * (трохи уточнень)
 * 1) сортуватись повинен список речень, що подаються на вхід
 * 2) речення повинні накопичуватись по мірі введення їх на стандартний вхід
 */
public class SortB implements Runnable{
	// по замовчуванням задається нульовий порядковий номер слова по якому буде проводитись сортування рядків
	private int arg = 0;

	public SortB(int arg) {
		this.arg = arg;
	}

	@Override
	public void run() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		// Створюється сортована структура даних з компаратором, визначеним в лямбда-виразі
		// (для сортування порівнюється довжина рядка)
		TreeSet<String> list = new TreeSet<>((o1, o2) ->{
			String [] text1 = o1.split("\\p{P}?[ \\t\\n\\r]+");
			String [] text2 = o2.split("\\p{P}?[ \\t\\n\\r]+");
			if(text1.length > arg && text2.length > arg){
				return text1[arg].compareToIgnoreCase(text2[arg]);
			} else {
				throw new UnsupportedOperationException("Параметр arg: " + arg + " перевищує кількість " +
						"слів в одному з речень.");
			}
		});

		String data = "";
		try {
			// зчитується рядок з консолі та переводиться в нижній регістр
			System.out.println("Введіть речення");
			data = bufferedReader.readLine();
			while(!data.equals("quit")){
				if (data.equals("clear")) {
					// СД очищається, якщо в консолі вводиться команда 'clear'
					list.clear();
					System.out.println("Список речень - очищено!");
				} else {
					// рядок зчитаний з консолі додається до сортованої СД
					list.add(data);
				}
				// виводиться список збережених рядків
				printList(list);
				data = bufferedReader.readLine();
			}
		} catch (IOException e) {
			System.err.println("Помилка вводу: " + e);
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				System.err.println("Помилка закриття потоку вводу: " + e);
			}
		}
	}

	/** Метод друкує рядки збережені в структурі даних List */
	private void printList(Set<String> list){
		Iterator<String> iter = list.iterator();
		for (;iter.hasNext();)
			System.out.println(iter.next());
	}

}
