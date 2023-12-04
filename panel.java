import java.awt.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class panel extends JPanel{
    //Properties
    BufferedImage imgEqu = null;
	int ax = 212;
	int cx = 237;
	int bx = 223;
	int by = 422;

    public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 960, 540);
        g.drawImage(imgEqu, 0, 0, null);
		g.setColor(Color.BLACK);
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(ax, 445, cx, 445);
		g2.drawLine(ax, 445, bx, by);
		g2.setStroke(new BasicStroke(1));
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
