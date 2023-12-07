import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class newpanel1 extends JPanel{
        // Properties
        BufferedImage imgHelp = null;
        
        // Methods
        public void paintComponent(Graphics g){
                g.drawImage(imgHelp, 0, 0, null);
        }

        // Constructor
        public newpanel1(){
                InputStream imageClass = null;
                imageClass = this.getClass().getResourceAsStream("help image.png");
                if(imageClass == null){
                        System.out.println("Unable to load image file");
                }else{
                        try{
                                ImageIO.read(imageClass);
                        }catch (IOException e){
                                System.out.println("Unable to load image file");
                        }
                }
                try{
                        imgHelp = ImageIO.read(new File("help image.png"));
                }catch(IOException e){
                        System.out.println("Could not open image");
                }
        }
}

