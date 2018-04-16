package test;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		
		File file = new File("G:\\kosta\\files");
		
		
		System.out.println(file.isDirectory());
		
		String[] files = file.list();

		for (String string : files) {
			
			System.out.println(string);
		}
	}
}
