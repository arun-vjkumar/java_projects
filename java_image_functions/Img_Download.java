package java_image_functions;

import java.io.*;
import java.net.*;

public class Img_Download{
	
	public Img_Download() {
		// TODO Auto-generated constructor stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Enter The FileName For Storing");
			String file_name = br.readLine();
			System.out.println("Enter URL OF IMAGE");
			String website = br.readLine();
			System.out.println("Downloading File From: " + website);
			URL url = new URL(website);
			InputStream inputStream = url.openStream();
			OutputStream outputStream = new FileOutputStream(file_name);
			byte[] buffer = new byte[2048];
			int length = 0;
			while ((length = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, length);
			}
			inputStream.close();
			outputStream.close(); 
		}
		
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
