import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class newpanel2 extends JPanel{
        // Properties
        BufferedImage imgAbout = null;

        // Methods
        public void paintComponent(Graphics g){
                g.drawImage(imgAbout, 0, 0, null);
        }

        // Constructor
        public newpanel2(){
                InputStream imageclass = null;
                imageclass = this.getClass().getResourceAsStream("about image.png");
                if(imageclass == null){
                        System.out.println("Unable to load image file");
                }else{
                        try{
                                imgAbout = ImageIO.read(imageclass);
                        }catch (IOException e){
                                System.out.println("Unable to load image file");
                        }
                }
                if(imgAbout == null){
                        try{
                                imgAbout = ImageIO.read(new File("about image.png"));
                        }catch(IOException e){
                                System.out.println("Could not open image");
                        }
                }
        }
}
