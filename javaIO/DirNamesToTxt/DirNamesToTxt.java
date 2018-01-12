package katrenich.javaIO.DirNamesToTxt;


import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;


public class DirNamesToTxt {

	public static List getDirNames(File src) throws FileNotFoundException {
		if (src != null){
			List<String> dirNames = new ArrayList<>();
			File[] dirs = getDirs(src);
			for (File f: dirs ) {
				dirNames.add(f.getName() + "\r\n");
			}

			return dirNames;
		} else {
			throw new FileNotFoundException();
		}

	}

	private static File[] getDirs(File root) {
		if(root.isDirectory()){
			File[] listFiles = root.listFiles();
			File[] files = new File[]{root};

			// перебираються файли в директорії, рекурсивно викликається метод getDirs для кожного файлу,
			// всі результати об'єднуються в масив, що повертається в результаті
			for (File file: listFiles) {
				File[] f = getDirs(file);
				if(f != null){
					files = concatenate(files, f);
				}
			}
			return files;
		} else {
			return new File[]{};
		}
	}

	private static File[] concatenate(File[] file0, File[] file1) {
		File[] result = new File[file0.length + file1.length];
		System.arraycopy(file0, 0, result, 0, file0.length);
		System.arraycopy(file1, 0, result, file0.length, file1.length);
		return result;
	}

}
