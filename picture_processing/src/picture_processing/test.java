package picture_processing;
import   java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import   java.awt.image.BufferedImage;    
import   javax.imageio.ImageIO;    
     
public   class   test      
{       
	  
	public static List<File> getFiles(String path)
	{
	    File root = new File(path);
	    List<File> files = new ArrayList<File>();
	    String reg = "(jpg|png|JPG|PNG)";
	    Matcher m = null; //为需要匹配的路径
	    //String filename =  null;
	   
	    if(!root.isDirectory())
	    {
	        files.add(root);
	    }
	    else
	    {  //filename = m.group(1);  
		    File[] subFiles = root.listFiles();
	        for(File f : subFiles)
	         {  
	        	    System.out.println("path"+f.getPath());
	          	m = Pattern.compile(reg).matcher(f.getPath());
	          	if(m.find()) 
	            {
	            files.addAll(getFiles(f.getAbsolutePath()));
	            }
	        	 } 
	    } 
	    return files;
	}
  
	public   static   void   main(String   args[]) throws IOException      
  {  
	List<File> image_folder_1 = test.getFiles("/Users/rayaesthe/Desktop/imagefolder1");//需要合并图片的文件夹
	System.out.println("00000000000000000");
	System.out.println(image_folder_1.size());
	File   fileZero   =  image_folder_1.get(0);
    BufferedImage   Image_0   =   ImageIO.read(fileZero);    
    System.out.print(fileZero.getPath());
    int   width_check_0   =   Image_0.getWidth();//图片宽度    
    //int   height   =   ImageOne.getHeight();//图片高度    
	int height_sum = 0;
	int width_check = width_check_0;//设定第一张图片的宽度用来检查
	 BufferedImage   ImageZero;
	 File   file_loop;
	for(int i=0;i<image_folder_1.size();i++) //loop得到需要生成的image总高度
	{    
		System.out.println(i);
		 file_loop   =  image_folder_1.get(i);
		 assert(file_loop.exists());
		 System.out.println("is exist? "+file_loop.exists());
		 
		 System.out.println(file_loop==null);
		 ImageZero   =   ImageIO.read(file_loop);  
		 System.out.println(ImageZero==null);
		 int   width_0    =   ImageZero.getWidth();//图片宽度    
	     int   height_0   =   ImageZero.getHeight();//图片高度
	     height_sum += height_0;
	     if(width_0!= width_check) 
	     {
	    	 System.out.print("存在宽度不匹配的图片");
	     break;
	     }
	}
	System.out.println(height_sum);
	//List<File> image_folder_2 = test.getFiles("/Users/rayaesthe/Desktop/imagefolder2");
	// File   fileOne   =  image_folder_1.get(0);
    //BufferedImage   ImageOne   =   ImageIO.read(fileOne);    
    // int   width    =   ImageOne.getWidth();//图片宽度    
    // int   height   =   ImageOne.getHeight();//图片高度    
	
	 BufferedImage   ImageNew   =   new   BufferedImage(width_check_0 ,height_sum,BufferedImage.TYPE_INT_RGB); //设定最后输出用的image 寄存器
	 
	height_sum=0;
	for(int i=0;i<image_folder_1.size();i++) 
	{
		 
	    try    
	    {   
	      //读取第一张图片    
	      // File   fileOne   =   new   File("/Users/rayaesthe/Desktop/IMG_0480.JPG"); 
	    	   System.out.println("00000000000000000");
	    	   System.out.println(i);
//	    	   System.out.println("00000000000000000");
//	    	   System.out.println(image_folder_1.size());
	    	   File fileOne   =  image_folder_1.get(i);
	       BufferedImage   ImageOne   =   ImageIO.read(fileOne);    
	       int   width    =   ImageOne.getWidth();//图片宽度    
	       int   height   =   ImageOne.getHeight();//图片高度    
	  
	       //从图片中读取RGB    
	       int[]   ImageArrayOne   =   new   int[width*height];    
	       ImageArrayOne   =   ImageOne.getRGB(0,0,width ,height,ImageArrayOne,0,width );    
	       ImageNew.setRGB(0,height_sum,width,height,ImageArrayOne,0,width );//设置上半部分的RGB
	       height_sum=height+height_sum;
	       System.out.println("00000000000000000");
    	       System.out.println(height_sum);
// 	       ImageNew.setRGB(0 ,height,width_2,height_2,ImageArrayTwo,0,width_2 );//设置下半部分的RGB    
//	       对第二张图片做相同的处理    
//	       File   fileTwo   =   new   File("/Users/rayaesthe/Desktop/未命名作品 2.jpg");  
//	       File   fileTwo  =  image_folder_1.get(i+1);
//	       BufferedImage   ImageTwo   =   ImageIO.read(fileTwo);
//	       int   width_2   =   ImageTwo.getWidth();//第二张图片宽度   
//	       int   height_2   =   ImageTwo.getHeight();//第二张图片高度    
//	       
//	       int[]   ImageArrayTwo   =   new   int[width_2 *height_2];    
//	       ImageArrayTwo   =   ImageTwo.getRGB(0,0,width_2 ,height_2,ImageArrayTwo,0,width_2 );    
	  	       
//	       if( width != width_2 ) 
//	       {
//	       System.out.printf("picture width not match.");
//	       break;
//	       }
//	       //生成新图片    
//	       BufferedImage   ImageNew   =   new   BufferedImage(width ,height+height_2,BufferedImage.TYPE_INT_RGB);    
//	       ImageNew.setRGB(0,0,width,height,ImageArrayOne,0,width );//设置上半部分的RGB    
//	       ImageNew.setRGB(0 ,height,width_2,height_2,ImageArrayTwo,0,width_2 );//设置下半部分的RGB    
//	       
//	       String save_path;
//	       save_path=String.format("/Users/rayaesthe/Desktop/coimage/"+"%d.JPG", i);
//	       File   outFile   =   new   File(save_path);    
//	       ImageIO.write(ImageNew,   "jpg",   outFile);//写图片    
	     }  catch(Exception   e)  {    
	           e.printStackTrace();    
	     }
    }   
	String save_path;
	String ok="saved";
	save_path=String.format("/Users/rayaesthe/Desktop/coimage/"+"%s.JPG", ok);
    File   outFile   =   new   File(save_path);    
    ImageIO.write(ImageNew,   "jpg",   outFile);//写图片    
	
  }
}     