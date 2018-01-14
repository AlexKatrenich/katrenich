package katrenich.javaIO.fileNamesToTxt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.File;

public class FileNamesToTxt{

	// Мето повертає масив об'єктів типу Файл
	private static File[] getDirs(File root, boolean fileIncludes) {
		if(root.isDirectory()){
			File[] listFiles = root.listFiles();
			File[] files = new File[]{root};

			if(listFiles != null){
				for (File file: listFiles) {
					// в кожної директорії рекурсивно викликається метод для
					// отримання списку під-директорій
					File[] f = getDirs(file, fileIncludes);
					if(f != null){
						// повернений масив директорій об'єднується з масивом,
						// що включає кореневу директорію
						files = concatenate(files, f);
					}
				}
			}
			return files;
		} else {
			// якщо змінна fileIncludes повертає істину, то файли також додаються до списку
			if(fileIncludes){
				return new File[]{root};
			} else {
				return new File[]{};
			}
		}
	}

	// метод об'єднує два масиви файлів/директорій в один
	private static File[] concatenate(File[] file0, File[] file1) {
		File[] result = new File[file0.length + file1.length];
		System.arraycopy(file0, 0, result, 0, file0.length);
		System.arraycopy(file1, 0, result, file0.length, file1.length);
		return result;
	}

	/**
	 * Метод повертає заповнює та повертає список назв директорій та файлів, що знаходяться в корневій директорії,
	 * яка подається на вхід.
	 * Метод повертає NullPointerException, якщо на вхід подається неініціалізована змінна*/
	public static List getNameFiles(File root, boolean includeFiles) throws NullPointerException {
		if(root != null){
			// очищаємо список від попередніх записів
			List<String> files = new ArrayList<>();

			File[] allFiles = getDirs(root, includeFiles);

			for (File file : allFiles) {
				files.add(file.getName());
			}

			return files;
		} else {
			throw new NullPointerException("Don`t initialized parameter variable on method signature");
		}
	}


	/***/
	public static void writeOnFile(File target, List<String> files) throws IOException, NullPointerException{
		if(target != null && target.exists()){
			if(files != null){
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(target))){
					Iterator<String> iter = files.iterator();
					String s = null;
					while (iter.hasNext()){
						try{
							s = iter.next();
							bw.write(s);
							bw.newLine();
						} catch (IOException e){
							System.err.println("Can`t write on file String: " + s + "\n" + e);
						}
					}
					bw.flush();
				} catch (IOException e){
					throw new IOException(e);
				}
			} else {
				throw new NullPointerException("Not initialized variable in method" +
						"signature");
			}
		} else {
			// Якщо заданий файл не існує, створюємо його та знову викликаємо метод writeOnFile
			try {
				target.createNewFile();
				writeOnFile(target, files);
			} catch (IOException e) {
				throw new IOException("Can`t create new File: " + target + e);
			}
		}
	}
}
