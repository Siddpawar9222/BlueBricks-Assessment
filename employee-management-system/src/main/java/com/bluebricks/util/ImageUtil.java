package com.bluebricks.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.http.Part;

public class ImageUtil { 
	public static byte[] imgToByte(Part imgPart) throws IOException {
		InputStream file = imgPart.getInputStream();
		byte imgData[] = new byte[(int)imgPart.getSize()] ;
		file.read(imgData);
		file.close();
		return imgData ;
	}	
}
