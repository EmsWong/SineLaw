import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;


public class graphics implements ActionListener, KeyListener, MouseListener, MouseMotionListener{
	//Properties
	JFrame theFrame = new JFrame("Sine Law");
	JPanel thePanel = new Jpanel();
	Timer theTimer = new Timer(1000/20.8, this);

	//Methods
	public void mouseMoved(MouseEvent e){
	}

	public void mouseDragged(MouseEvent e){

	}

	public void mouseExited(MouseEvent e){
        
        }

        public void mouseEntered(MouseEvent e){
        
        }

        public void mouseReleased(MouseEvent e){

        }

        public void mousePressed(MouseEvent e){

        }

        public void mouseClicked(MouseEvent e){
        	
        }       

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == theTimer){
			thePanel.repaint();
		}
	}

	public void keyReleased(KeyEvent e){
		
	}

	public void keyPressed(KeyEvent e){
		
	}

	public void keyTyped(KeyEvent e){

	}

	//Constructor
	public graphics(){
		thePanel.setPreferredSize(new Dimension(600,600));
		thePanel.addMouseListener(this);
		thePanel.addMouseMotionListener(this);
		theFrame.addKeyListener(this);
		theFrame.setContentPane(thePanel);
		theFrame.pack();
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theFrame.setVisible(true);
		theTimer.start();
	}

	//Main Method
	public static void main(String[] args){
		new graphics();
	}
}
