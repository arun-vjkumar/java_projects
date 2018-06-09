package java_image_functions;

import java_image_functions.Img_Details;

public class Image_Info_Display {
	Image_Info_Display(Img_Details img_info){
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Name-" + img_info.name);
		System.out.println("Height-" + img_info.height);
		System.out.println("Width-" + img_info.width);
		// System.out.println("Type-" + img_info.type);
		System.out.println("Absolute Path-" + img_info.path);
		System.out.println("Size in  KB-" + img_info.size);
		System.out.println("Last Modified-" + img_info.modified);
		System.out.println("-----------------------------------------------------------------------------------");
	}
}