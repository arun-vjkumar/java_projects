package java_image_functions;

import java.util.Scanner;
import java.io.*;
import java_practice_programs.*;

public class Image_Download {

	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		for ( ; ; ) {
			System.out.println("Menu");
			System.out.println("1.Download Image");
			System.out.println("2.GrayScale");
			System.out.println("3.Image Details");
			Scanner s = new Scanner(System.in);
			int opt = s.nextInt();
			switch (opt) {
			case 1:
				new Img_Download();
				break;

			case 2:
				System.out.println("Enter the filename");
				String img_file_path = br.readLine();
				Img_Grayscale.grayscale(img_file_path);
				break;
			
			case 3:
				Img_Details img_info = new Img_Details();
				img_info.get_img_details();
				new Image_Info_Display(img_info);
				break;
				
			default:
				System.out.print("Exiting");
				System.exit(0);
				break;
			}
		}
	}

}