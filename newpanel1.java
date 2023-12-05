import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class newpanel1 extends JPanel{
    // Properties
    BufferedImage imgHelp = null;

    public void paintComponent(Graphics g){
        g.drawImage(imgHelp, 0, 0, null);
    }


    // Constructor
    public newpanel1(){
        try{
            imgHelp = ImageIO.read(new File("help image.png"));
        }catch(IOException e){
            System.out.println("Could not load image");
        }
    }
}

