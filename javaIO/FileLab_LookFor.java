package katrenich.javaIO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/** Приклад роботи з файлами за допомогою java.IO
 */

public class FileLab_LookFor {
	public static void main(String[] args) {
		File file = new File("d:/tmp");
		print(file);
//		System.out.println(Arrays.toString(lookForBigImage(file)));
	}

	/**
	 * Этот пример кода - проходит по всей директории
	 * (включая вложенные) и выводит имена всех файлов в консоль
 	 */
	public static void print(File root) {
		if (root.isFile()) {
			System.out.println(root.getName() + " length: " + root.length());
		} else {
			File[] fileArray = root.listFiles();
			for (File file : fileArray) {
				print(file);
			}
		}
	}

	/** 1) метод выводит только имена файлов, которые представляют собой большие
	 * (File.length() > 1024*1024) картинки (имя файла заканчивается (String.endsWith(String))
	 * на ".jpg"/".png"/".bmp"/".gif".
	 * 2) собирал нужные файлы в масив.
	 **/

	public static File[] lookForBigImage(File root){
		if(root.isDirectory()){
			File[] listFiles = root.listFiles();
			File[] files = new File[]{};

			// перебираються файли в директорії, рекурсивно викликається метод lookForBigImage для кожного файлу,
			// всі результати об'єднуються в масив, що повертається в результаті
			for (File file:listFiles) {
				File[] f = lookForBigImage(file);
				if(f != null){
					files = concatenate(files, f);
				}
			}
			return files;
		} else if (isRightFile(root)){
			return new File[]{root};
		} else {
			// коли root - файл, що не підходить по умовам - повертається null
			return null;
		}
	}

	// метод перевіряє характеристики файлів на відповідність певним умовам, повертає істину, якщо характеристики
	// відповідають заданим умовам
	private static boolean isRightFile(File file){
		if(file.isFile() && file.length() > 1024*1024){
			if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png")
					|| file.getName().endsWith(".bmp") || file.getName().endsWith(".gif")){
				return true;
			}
		}
		return false;
	}

	// метод об'єднує 2 масива файлів в один та повертає результуючий масив
	public static File[] concatenate(File[] file0, File[] file1) {
		File[] result = new File[file0.length + file1.length];
		System.arraycopy(file0, 0, result, 0, file0.length);
		System.arraycopy(file1, 0, result, file0.length, file1.length);
		return result;
	}
}
