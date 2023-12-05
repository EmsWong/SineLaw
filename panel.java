import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class panel extends JPanel{
    //Properties
    BufferedImage imgEqu = null;
	// coordinates based on starting triangle values
	int ax = 180;
	int ay = 470;
	int cx = 155;
	int cy = 470;
	int bx = 205;
	int by = 450;

    public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 960, 540);
        g.drawImage(imgEqu, 0, 0, null);
		g.setColor(Color.BLACK);
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(ax, ay, cx, cy);
		g2.drawLine(ax, ay, bx, by);
		g2.drawLine(bx, by, cx, cy);
;		g2.setStroke(new BasicStroke(1));
	}

    //Constructor
	public panel(){
		InputStream imageClass = null;
		imageClass = this.getClass().getResourceAsStream("formula image.png");
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
            imgEqu = ImageIO.read(new File("formula image.png"));
        }catch(IOException e){
            System.out.println("Could not open image");
        }
    }
}
