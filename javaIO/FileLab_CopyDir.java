package katrenich.javaIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
  * Данный код создает копию структуры папок
  */
public class FileLab_CopyDir {
	public static void main(String[] args) {
		copy2(new File("d:/tmp"), new File("d:/tmp2"));
	}

	private static void copy(File src, File dst) {
		if (src.isDirectory()) {
			if (!dst.exists()) {
				dst.mkdir();
			}
			for (File srcSubDir : src.listFiles()) {
				String subDirName = srcSubDir.getName();
				copy(srcSubDir, new File(dst, subDirName));
			}
		}
	}

	/*
	 * Модифицируйте/допишите код, что бы он создавал не только копию папок, но и копии всех файлов.
	 * */
	private static void copy2(File src, File dst) {
		if (src.isDirectory()) {
			if (!dst.exists()) {
				dst.mkdir();
			}
			for (File srcSubDir : src.listFiles()) {
				String subDirName = srcSubDir.getName();
				copy2(srcSubDir, new File(dst, subDirName));
			}
		} else {
			try {
				Files.copy(src.toPath(), dst.toPath());
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}
}
