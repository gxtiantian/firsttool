package com.test;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageTest {
    
    public static void main(String[] args) throws Exception {
//        InputStream in = new FileInputStream("F:\\tmp\\1029\\test.jpg");//图片路径
//        BufferedImage image = ImageIO.read(new File("F:\\tmp\\1029\\test.jpg"));
//        Graphics g = image.getGraphics();
//        g.setColor(Color.RED);//画笔颜色
//        g.drawRect(100, 100, 100, 100);//矩形框(原点x坐标，原点y坐标，矩形的长，矩形的宽)
//        //g.dispose();
//        FileOutputStream out = new FileOutputStream("F:\\tmp\\1029\\test2.jpg");//输出图片的地址
//        ImageIO.write(image, "jpeg", out);
        JpgTest();
//        createImage();
        System.out.println("finished");
    }
    
    public static void JpgTest() throws Exception {  
        File _file = new File("F:\\tmp\\1029\\test.jpg"); // 读入文件  
        Image src = javax.imageio.ImageIO.read(_file); // 构造Image对象  
        int width = src.getWidth(null); // 得到源图宽  
        int height = src.getHeight(null); // 得到源图长  
         
        //需要长度  
        int newwidth = 200;//width / 2  
        int newheight = 200;//height / 2  
        BufferedImage image = new BufferedImage(newwidth, newheight,  
          BufferedImage.TYPE_INT_RGB);  
        Graphics graphics = image.getGraphics();  
         
               
        graphics.drawImage(src, 0, 0, newwidth, newheight, null); // 绘制缩小后的图  
       // 画边框,在drawImage后面，下面代码给图片加上两个像素的白边     
        graphics.setColor(Color.RED); 
        Font font = new Font("Serif", Font.BOLD, 20); 
        graphics.setFont(font);
        graphics.drawRect(0, 0, newwidth - 1, newheight - 1);  
        graphics.drawRect(1, 1, newwidth - 1, newheight - 1);  
        graphics.drawRect(0, 0, newwidth - 2, newheight - 2);  
         
        FileOutputStream out = new FileOutputStream("F:\\tmp\\1029\\test3.jpg"); // 输出到文件流  
//        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
//        encoder.encode(image); // JPEG编码  
//        out.close();  
        
        ImageIO.write(image, "jpeg", out);
     }  
    
    
    public static void createImage() throws Exception{
        int width = 400;     
        int height = 400;     
//        String s = "你好";     
             
        File file = new File("F:\\tmp\\1029\\test4.jpg");     
             
        Font font = new Font("Serif", Font.BOLD, 10);     
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);     
        Graphics2D g2 = (Graphics2D)bi.getGraphics();     
        g2.setBackground(Color.WHITE);     
        g2.clearRect(0, 0, width, height);     
        g2.setPaint(Color.RED);    
        g2.setStroke(new BasicStroke(10.0f));
        
        
        g2.drawRect(0, 0, width-1, height-1);
//        g2.drawRect(0, 0, newwidth - 1, newheight - 1);  
        g2.drawRect(1, 1, width - 1, height - 1);  
        g2.drawRect(0, 0, width - 2, height - 2);
        
             
//        FontRenderContext context = g2.getFontRenderContext();     
//        Rectangle2D bounds = font.getStringBounds(s, context);     
//        double x = (width - bounds.getWidth()) / 2;     
//        double y = (height - bounds.getHeight()) / 2;     
//        double ascent = -bounds.getY();     
//        double baseY = y + ascent;     
//             
//        g2.drawString(s, (int)x, (int)baseY);     
             
        ImageIO.write(bi, "jpg", file);      
    }
}
