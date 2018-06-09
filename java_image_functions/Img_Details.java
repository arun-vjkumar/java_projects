package java_image_functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Img_Details {
	
	double height, width, type, size;
	String name, path;
	long modified;
	
	public void get_img_details() throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Path Of Image");
		String fileName = br.readLine();
		File in = new File(fileName);
		BufferedImage img = ImageIO.read(in);
		this.height = img.getHeight();
		this.width = img.getWidth();
		this.type = img.getType();
		this.path = in.getAbsolutePath();
		this.size = in.length()/1024;
		this.name = in.getName();
		this.modified = in.lastModified();
	}

}
