import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class panel extends JPanel{
    //Properties
    BufferedImage imgEqu = null;

    public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 960, 540);
        g.drawImage(imgEqu, 0, 0, null);
    }
    //Constructor
	public panel(){
		try{
			imgEqu = ImageIO.read(new File("formula image.png"));
		}catch(IOException e){
			System.out.println("Unable to load image");
		}
    }
}
