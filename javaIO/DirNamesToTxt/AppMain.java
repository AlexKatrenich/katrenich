package katrenich.javaIO.DirNamesToTxt;



import java.io.*;
import java.util.*;

/**
 * Задача:
 * 1) Написати консольний додаток, що буде копіювати та номерувати імена папок в текстовий файл.
 * 2) Потрібно додати графічний користувацький інтерфейс для зручності
 */
public class AppMain {
	public static void main(String[] args) {
		File src = new File("D:\\JAVA\\ЭЛЕКТРОННОЕ_ОБОРУДОВАНИЕ");
		File dest = new File("D:\\JAVA", "DirNamesResult.txt");
		List<String> dirNames = null;
		BufferedWriter bw = null;

		if(!dest.exists()) {
			try {
				dest.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			dirNames = DirNamesToTxt.getDirNames(src);
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}

		try {
			bw =new BufferedWriter(new FileWriter(dest));
		} catch (IOException e) {
			System.err.println(e);
		}

		for (String name: dirNames) {
			try {
				if(name != null) {
					bw.write(name);
				}
			} catch (IOException e) {
				System.err.println(e);
			}
		}

		try {
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done!");


	}
}
