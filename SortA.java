package katrenich;

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
public class SortA implements Runnable{
	@Override
	public void run() {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// Створюється сортована структура даних з компаратором, визначеним в лямбда-виразі
		// (для сортування порівнюється довжина рядка)
		TreeSet<String> list = new TreeSet<>((o1, o2) ->
				o1.length() > o2.length() ? 1 : (o1.length() == o2.length() ? 0 : -1));

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
