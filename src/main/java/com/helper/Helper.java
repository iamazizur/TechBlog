package com.helper;

import java.io.File;
import java.io.FileOutputStream;

import java.io.InputStream;


import javax.servlet.http.Part;

public class Helper {
	public static boolean deleteFile(String path) {
		try {
			File file = new File(path);
			return file.delete();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean saveFile(Part file, String path) {
		try {
			InputStream inputStream = file.getInputStream();
			byte[] buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(buffer);
			fos.flush();
			fos.close();
			inputStream.close();
			
			return true;
				
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
