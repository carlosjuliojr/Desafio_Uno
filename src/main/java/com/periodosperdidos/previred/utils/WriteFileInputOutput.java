package com.periodosperdidos.previred.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 
 * @author julio Jaimes
 * @apiNote Class is used to write in the System's salida file
 */
public class WriteFileInputOutput {

	public void writeSolution(String address, String nameFile, String content) throws IOException {

		File f = new File(nameFile);
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(content.getBytes());
		fos.close();
	}
}
