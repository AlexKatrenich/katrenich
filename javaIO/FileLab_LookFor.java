package katrenich.javaIO;

import java.io.*;

/** Этот пример кода - проходит по всей директории
 * (включая вложенные) и выводит имена всех файлов в консоль
 */

public class FileLab_LookFor {
	public static void main(String[] args) {
		File file = new File("d:/tmp");
		print(file);
	}

	// файл - друкується, в директорії проходження рекурсією.
	public static void print(File root) {
		if (root.isFile()) {
			System.out.println(root);
		} else {
			File[] fileArray = root.listFiles();
			for (File file : fileArray) {
				print(file);
			}
		}
	}

	// 1) метод выводит только имена файлов, которые представляют собой большие
	// (File.length() > 1024*1024) картинки (имя файла заканчивается (String.endsWith(String))
	// на ".jpg"/".png"/".bmp"/".gif".
	// 2) собирал нужные файлы в масив.
	public static File[] lookForBigImage(File root){
		if (root.isFile() && root.length() > 1024*1024){

		} else {

		}
		return null;
	}
}
